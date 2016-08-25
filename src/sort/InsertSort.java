package sort;

public class InsertSort {
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	
	public static ListNode insertSortList (ListNode head){//�����
		if (head == null || head.next == null){
			return head;
		}
		

		
		return head;
		
	}
	
	public static int[] insertSortArray (int[] array){//�����
		if (array.length == 1){
			return array;
		}
		for (int i = 1; i < array.length; i++){ //�ӵڶ���Ԫ�ؿ�ʼ
			int j = i - 1;
			int temp = array[i];
			while (j >= 0 && temp < array[j] ){
				array[j+1] = array[j];
				j--;
				
			}
			array[j+1] = temp;
			
		}
		return array;
	}
	
	public static void main(String[] args){
		int[] a = new int[]{800,9,3,6,12,54,35,411,3,245,1,0,4};
		a = insertSortArray(a);
		for (int m : a){
			System.out.print(m +" ");
		}
	}
}
