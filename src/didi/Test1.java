package didi;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		String s = String.valueOf(input);
		String newS = "";
		for(int i = s.length()-1; i >= 0 ; i--){
			newS += s.charAt(i);
		}
		System.out.println(newS);
	}

}
