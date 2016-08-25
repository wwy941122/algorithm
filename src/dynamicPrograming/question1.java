package dynamicPrograming;
/*01 背包问题
 * 01背包的状态转换方程 f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] }

f[i,j]表示在前i件物品中选择若干件放在承重为j的背包中，可以取得的最大价值。

 f[i-1,j-Wi]+Pi可以理解为加入第i个物品
 f[i-1,j]则表示不加入此物品，保持原样

 * 
 * */
public class question1 {
	public static void main(String[] args){
		int[][] f = new int[6][11];
		int[] v = {0,6,3,5,4,6};
		int[] w = {0,2,2,6,5,4};
		for(int i = 1; i < 6; i++){
			for (int j = 1; j < 11; j++){
				if(w[i] > j){
					f[i][j] = f[i-1][j];
				} else
					f[i][j] = Math.max(f[i-1][j], f[i-1][j - w[i]] + v[i]);
			}
		}
		

		for(int i = 1; i < 6; i++){
			for (int j = 1; j < 11; j++){
				System.out.print(f[i][j]);
				}
			System.out.print('\n');
			}
			
		

		
	}

}
