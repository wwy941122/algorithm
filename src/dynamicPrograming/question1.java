package dynamicPrograming;
/*01 ��������
 * 01������״̬ת������ f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] }

f[i,j]��ʾ��ǰi����Ʒ��ѡ�����ɼ����ڳ���Ϊj�ı����У�����ȡ�õ�����ֵ��

 f[i-1,j-Wi]+Pi�������Ϊ�����i����Ʒ
 f[i-1,j]���ʾ���������Ʒ������ԭ��

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
