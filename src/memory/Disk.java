package memory;

import java.util.ArrayList;
import java.util.*;

public class Disk {
	private static int totalMoving;
	private static int startPosition = 100;
	private static List<Integer> list = new ArrayList<Integer>();
	private static int size;
	private static int moveDirection = 0;//0:�����ƶ�,1:�����ƶ�
	
	
	public static void main(String[] args){

		System.out.println("������Ҫʵ�ֵ��㷨��1��SSTF.2��SCAN");
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		if (i == 1){
			input();
			SSTF();
			display();

		} else if(i == 2) {
			input();
			SCAN();
			display();
		}
		

		
	
	}
	
	
	
	public static void input(){
		System.out.println("���������У�");
		Scanner in = new Scanner(System.in);
		String input1 = in.nextLine();
		String[] input2 = input1.split("\\s");
		for(String num : input2){
			list.add(Integer.valueOf(num));
			size = list.size();
			
		}
		
	}
	
	public static void display(){
		System.out.println("Ѱ��ʱ��Ϊ" + (double)totalMoving/size);
	}
	
	public static void SSTF(){
		int nextNum = 0;
		for (int i = 0; i < size; i++) {
			nextNum = searchMin(startPosition);
			System.out.println("��һ�����ʵ��ǣ�" + nextNum);
			
		}
		
	}
	
	public static int searchMin(int startPosition){
		int min = Integer.MAX_VALUE;
		int theDis = 0;
		int i = 0, indexOfMin = 0;
		int thisPosition = startPosition;
		 Iterator<Integer> it = list.iterator();
		 while(it.hasNext()){
			 int cP = it.next();
			 theDis = Math.abs(startPosition - cP);
			 if (theDis < min){
				 min = theDis;
				 indexOfMin = i;
				 
			 }
			 i++;
			 
		 }
		 thisPosition = list.remove(indexOfMin);
		 totalMoving += Math.abs(startPosition - thisPosition);
		 Disk.startPosition = thisPosition;
		 return thisPosition;
		 
	}
	
	public static void SCAN(){
		int nextNum = 0;
		for (int i = 0; i < size; i++) {
			nextNum = searchMin2(startPosition);
			System.out.println("��һ�����ʵ��ǣ�" + nextNum);
			
		}
	}
	
	public static int searchMin2(int startPosition){
		int min = Integer.MAX_VALUE;
		int theDis = 0;
		int i =0, indexOfMin = 0;
		int thisPosition = startPosition;
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			int cP = it.next();
			theDis = Math.abs(cP - startPosition);
			if((theDis < min) && (moveDirection == 0) && (cP > startPosition)){
				indexOfMin = i;
				min = theDis;
			} else if((theDis < min) && (moveDirection == 1) && (cP < startPosition)){
				indexOfMin = i;
				min = theDis;
			}
			
			if(indexOfMin == -1 && moveDirection == 0){
				moveDirection = 1;
			} else if(indexOfMin == -1 && moveDirection == 1){
				moveDirection = 0;
			}
			
			i++;
		}
		
		thisPosition = list.remove(indexOfMin);
		totalMoving += Math.abs(thisPosition - startPosition);
		Disk.startPosition = thisPosition;
		return thisPosition;
	}
	

}
