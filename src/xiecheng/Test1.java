package xiecheng;

import java.util.Scanner;
/*
 * ����һ�������д洢��һ����Ʊ����һ�콻�״����ڸ�ʱ���Ĺ�Ʊ�۸�����������ֻ����һ�������һ�����������ṩһ���㷨�������ͨ��������������Եõ����������
����
�۸����У���,�Ÿ���
���
���Ŀ�������

��������
2,3,2,4
�������
2
 * 
 * */
public class Test1 {
	
	public static void main(String[] args){
		Scanner in  = new Scanner(System.in);
		while(in.hasNextLine()){
			String s = in.nextLine();
			String[] str = s.split(",");
			int[] nums = new int[str.length];
	 		for(int i = 0; i < str.length; i++){
	 			nums[i] = Integer.parseInt(str[i]);
	 		}
	 		
	 		System.out.println(Find(nums));
		}
		
	}
	
	public static int Find(int[] array){
		int max = 0;
		for(int i = 0; i < array.length; i++){
			for(int j = i; j < array.length; j++){
				max = Math.max(max, array[j] - array[i]);
			}
		}
		
		return max;
	}

}
