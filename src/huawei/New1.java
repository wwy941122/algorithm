package huawei;

import java.util.Scanner;

public class New1 {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		//int[][] array = new int[a][b];
		char[][] array = new char[a][b];
		String[] str = new String[a];
		in.nextLine();
		for(int i = 0; i < a; i++){
			array[i] = in.nextLine().toCharArray();
		}
//		for (int i = 0; i < a; i++) {
//			
//			str[i] = in.nextLine();
//			}
//		for(int i = 0; i < a; i++)	{
//			for(int j = 0; j < b; j++){
//				array[i][j] = str[i].charAt(j);
//			}
//		}
		
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();	
		}

	}

}
