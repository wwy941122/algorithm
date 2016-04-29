package huawei;

import java.util.Scanner;

public class Num1 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		String origin = in.nextLine();
		in.close();
		char[] next = origin.toCharArray();
		boolean[] asc2 = new boolean[300];
		for(int i = 0; i < next.length; i++){
			asc2[(int)next[i]] = true;
		}
		
		for(int i = 0; i < asc2.length; i++){
			if(asc2[i] == true){ 
				System.out.print((char)i);
			}
		}
	}

}
