package memory;

import java.util.*;


public class test {
	
	private static final int PRO_MEMORY = 3;//内存块数
	private static Page[] pages = new Page[PRO_MEMORY];//
	private static int capacity;//当前内存的占用数
	private static int countOldPoint;//记录最久的页面
	private static int lackTime;//缺页次数
	private static List<Integer> userPageList = new ArrayList<Integer>();
	
	public  void init(){ //初始化
		for(int i = 0; i < pages.length; i++){
			pages[i] = new Page();
			
		}
		System.out.println("init");
	}
	
	public void input(){//输入顺序
		System.out.println("请输入顺序：");
		Scanner in = new Scanner(System.in);
		String input  = in.nextLine();
		String[] inputList = input.split("\\s");
		for(String num : inputList){
			userPageList.add(Integer.valueOf(num));
		}
		in.close();
		
	}
	
	public void display(){
		System.out.println("内存中剩下的页面是：");
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
				System.out.println("当前页面"+inPageId+"已在内存中，不用替换");
			} else {
				if(capacity < PRO_MEMORY ){
					pages[capacity].setId(inPageId);
					System.out.println(inPageId + "正在放入内存");
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
		System.out.println("缺页次数为：" + lackTime +" , "+ "缺页率为：" + (float)lackTime/userPageList.size());
		
	}
	
	public  boolean search1(int pageId){//查找页面是否存在
		for(int i = 0; i < pages.length; i++){
			if(pages[i].getId() == pageId){
				return true;
			} 
		}
		return false;
		
	}
	
	public  void replace1(int pageId){//FIFO中使用的替换算法，即用当前页面替换最久的页面
		int outPageId = -1;
		outPageId = pages[countOldPoint].getId();
		pages[countOldPoint].setId(pageId);
		System.out.println("页号" + pageId + "换入，页号" + outPageId +"换出");
	}
	
	

	
	public void LRU(){
		Iterator<Integer> iterator = userPageList.iterator();
		while(iterator.hasNext()){
			int inPageId = iterator.next();
			if(search2(inPageId)){
				System.out.println(inPageId + "已在内存中，不用替换");
			} else{
				if(capacity < PRO_MEMORY){
					pages[capacity].setId(inPageId);
					System.out.println(inPageId + "正在放入内存");
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
		System.out.println("缺页次数为：" + lackTime +" , "+ "缺页率为：" + (float)lackTime/userPageList.size());
		
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
		//换出count最大的页面
		int outPageId = -1;//换出的页面
		int pId = 0;//记录下标
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
		System.out.println("页号" + pageId + "换入，页号" + outPageId +"换出");
		
	}
	
	
	
	
	public static void main(String[] args){
		System.out.println("请选择1、FIFO，2、LRU");
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
		private int count;//模拟用于记录的寄存器
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
