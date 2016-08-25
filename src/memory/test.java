package memory;

import java.util.*;


public class test {
	
	private static final int PRO_MEMORY = 3;//�ڴ����
	private static Page[] pages = new Page[PRO_MEMORY];//
	private static int capacity;//��ǰ�ڴ��ռ����
	private static int countOldPoint;//��¼��õ�ҳ��
	private static int lackTime;//ȱҳ����
	private static List<Integer> userPageList = new ArrayList<Integer>();
	
	public  void init(){ //��ʼ��
		for(int i = 0; i < pages.length; i++){
			pages[i] = new Page();
			
		}
		System.out.println("init");
	}
	
	public void input(){//����˳��
		System.out.println("������˳��");
		Scanner in = new Scanner(System.in);
		String input  = in.nextLine();
		String[] inputList = input.split("\\s");
		for(String num : inputList){
			userPageList.add(Integer.valueOf(num));
		}
		in.close();
		
	}
	
	public void display(){
		System.out.println("�ڴ���ʣ�µ�ҳ���ǣ�");
		for(Page page : pages){
			System.out.println(page.getId() + " ");
		}
	}
	
	public void FIFO(){
		Iterator<Integer> iterator = userPageList.iterator();
		while(iterator.hasNext()){
			countOldPoint = countOldPoint % PRO_MEMORY;
			int inPageId = iterator.next();
			if(search1(inPageId)){
				System.out.println("��ǰҳ��"+inPageId+"�����ڴ��У������滻");
			} else {
				if(capacity < PRO_MEMORY ){
					pages[capacity].setId(inPageId);
					System.out.println(inPageId + "���ڷ����ڴ�");
					capacity++;
					lackTime++;
				} else {
					replace1(inPageId);
					lackTime++;
					countOldPoint++;
				}
				display();
			}
		}
		System.out.println("ȱҳ����Ϊ��" + lackTime +" , "+ "ȱҳ��Ϊ��" + (float)lackTime/userPageList.size());
		
	}
	
	public  boolean search1(int pageId){//����ҳ���Ƿ����
		for(int i = 0; i < pages.length; i++){
			if(pages[i].getId() == pageId){
				return true;
			} 
		}
		return false;
		
	}
	
	public  void replace1(int pageId){//FIFO��ʹ�õ��滻�㷨�����õ�ǰҳ���滻��õ�ҳ��
		int outPageId = -1;
		outPageId = pages[countOldPoint].getId();
		pages[countOldPoint].setId(pageId);
		System.out.println("ҳ��" + pageId + "���룬ҳ��" + outPageId +"����");
	}
	
	

	
	public void LRU(){
		Iterator<Integer> iterator = userPageList.iterator();
		while(iterator.hasNext()){
			int inPageId = iterator.next();
			if(search2(inPageId)){
				System.out.println(inPageId + "�����ڴ��У������滻");
			} else{
				if(capacity < PRO_MEMORY){
					pages[capacity].setId(inPageId);
					System.out.println(inPageId + "���ڷ����ڴ�");
					reSet(capacity);
					capacity++;
					timeRefresh();
					lackTime++;
				} else{
					replace2(inPageId);
					timeRefresh();
					lackTime++;
				}
			}
			display();
		}
		System.out.println("ȱҳ����Ϊ��" + lackTime +" , "+ "ȱҳ��Ϊ��" + (float)lackTime/userPageList.size());
		
	}
	
	public boolean search2(int pageId){
		for (int i = 0; i < pages.length; i++) {
			if(pageId == pages[i].getId()){
				timeRefresh();
				reSet(i);
				return true;
			}
			
		}
		return false;
	}
	
	public void reSet(int pageId){
		pages[pageId].setCount(0);
		
	}
	
	public void timeRefresh(){
		for(Page page: pages){
			page.countInc();
		}
	}
	
	public void replace2(int pageId){
		//����count����ҳ��
		int outPageId = -1;//������ҳ��
		int pId = 0;//��¼�±�
		int max = 0;
		int countOfpage;
		for (int i = 0; i < pages.length; i++) {
			
		 countOfpage = pages[i].getCount();
			if(max < countOfpage){
				max = countOfpage;
				pId = i;
				outPageId = pages[i].getId();
			}
			
		}
		reSet(pId);
		pages[pId].setId(pageId);
		System.out.println("ҳ��" + pageId + "���룬ҳ��" + outPageId +"����");
		
	}
	
	
	
	
	public static void main(String[] args){
		System.out.println("��ѡ��1��FIFO��2��LRU");
		Scanner in = new Scanner(System.in);
		int choose = in.nextInt();

		
		if(choose == 1){
			test t = new test();
			t.init();
			t.input();
			t.FIFO();

		} else if(choose == 2){
			test t = new test();
			t.init();
			t.input();
			t.LRU();
		}
		
		
	}
	
	
	
	class Page{
		private int id;
		private int count;//ģ�����ڼ�¼�ļĴ���
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
		public void countInc(){
			count++;
		}
		
	}
	
	
		
	

}
