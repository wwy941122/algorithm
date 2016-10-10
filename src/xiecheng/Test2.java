package xiecheng;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int key = in.nextInt();
			int length = in.nextInt();
			if(length == 0){
				System.out.println(0);
			}
			int[] nums = new int[length];
			for(int i = 0; i < length; i++ ){
				nums[i] = in.nextInt();
			}
			int result = Find(nums, key);
			if(result >= 0 ){
				System.out.println(result);
			} else {
				System.out.println(result-1);
			}
		}

	}
	
	public static int Find(int[] array, int key){
		for(int i = 0; i < array.length; i++){
			if(array[i] == key){
				return i;
			} else if (array[i] > key){
				return -i;
			}
		}
		return - array.length;
	}

}
