package xiaomi;
/*
 * 
 * Ê¶±ðOne two three
 *
 * 
 * */
import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		for(int i = 0; i < t; i++){
			
			
			int[] nums = getNum(in.nextLine());
			for(int j = 0; j < nums.length; j++){
				System.out.print(nums[j]);
			}
			System.out.println();
		}
		
	}	
	
	public static int[] getNum(String s){
		StringBuilder sb  = new StringBuilder();
		char[] str = s.toCharArray();
		for(int i = 0; i < s.length()-1; i++){
			if(str[i] == 'Z' && str[i+1] == 'E') sb.append("2");
			else if(str[i] == 'O' && str[i+1] == 'N') sb.append("3");
			else if(str[i] == 'T' && str[i+1] == 'W') sb.append("4");
			else if(str[i] == 'T' && str[i+1] == 'H') sb.append("5");
			else if(str[i] == 'F' && str[i+1] == 'O') sb.append("6");
			else if(str[i] == 'F' && str[i+1] == 'I') sb.append("7");
			else if(str[i] == 'S' && str[i+1] == 'I') sb.append("8");
			else if(str[i] == 'S' && str[i+1] == 'E') sb.append("9");
			else if(str[i] == 'E' && str[i+1] == 'I') sb.append("0");
			else if(str[i] == 'N' && str[i+1] == 'I') sb.append("1");
		}
		String result = sb.toString();
		int[] nums = new int[result.length()];
		for(int j = 0; j < result.length(); j++){
			nums[j] = Integer.parseInt(String.valueOf(result.charAt(j)));
		}
		Arrays.sort(nums);
		return nums;
		
	}

}
