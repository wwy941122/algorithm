package xiecheng;

import java.util.Scanner;
/*
 * 假如一个数组中存储了一个股票，在一天交易窗口内各时间点的股票价格（正整数）。只允许一次买入和一次卖出，请提供一个算法，计算出通过卖出和买入可以得到的最大利润
输入
价格序列，用,号隔开
输出
最大的可能利润

样例输入
2,3,2,4
样例输出
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
