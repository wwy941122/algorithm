package xiecheng;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int time = in.nextInt();
		int graph[][] = new int[time][time];
		in.nextLine();
		for(int i = 0; i < time; i++){
			String s = in.nextLine();
			String[] str = s.split("'");
			for(int j = 0; j < time; j++){
				graph[i][j] = Integer.parseInt(str[j]);
			}
			
 		}

	}

}
