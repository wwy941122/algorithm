package didi;
import java.lang.StringBuffer;
import java.util.Scanner;
public class Test2 {
	public static void main(String[] args){
		Scanner in  = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int P = in.nextInt();
		int[][] mat = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				mat[i][j] = in.nextInt();
			}
		}
		boolean[][] visited = new boolean[n][m];
		boolean result = Find(mat, 0,0,P,visited);
//		if(result == false){
//			System.out.println("Can not escape!");
//		}
	}
	
	public static boolean Find(int[][] mat, int n, int m,int P, boolean[][] visited){
		if(n > mat.length -1|| m > mat[0].length -1 || n < 0 ||m < 0) return false;
		if(visited[n][m] == true) return false;
		if(mat[n][m] == 0) return false;
		if(P < 0) return false;
		
		if(n == mat.length-1 && m == mat[0].length-1){
			System.out.print("["+ n + "],[" + m + "]");
			return true;
		}
		visited[n][m] = true;
		System.out.print("["+ n + "," + m + "],");
		return Find(mat, n-1, m, P, visited) || Find(mat, n+1, m, P-3, visited)|| Find(mat, n, m-1, P-1, visited)|| Find(mat, n, m+1, P-1, visited);
	}
}
