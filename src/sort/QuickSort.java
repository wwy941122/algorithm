package sort;

public class QuickSort {
	public static int [] S = {13,19,9,5,12,8,7,4,21,2,6,11};
	public static int partition(int[] S, int p, int r){
		int i = p-1;
		int j;
		int x = S[r];
		for ( j = p; j < r; j++) {
			if(S[j] <= x){
				i++;
				int temp;
				temp = S[j];  //½»»»
				S[j] = S[i];
				S[i] = temp;
				}
		}
		int temp;
		temp = S[r];
		S[r] = S[i+1];
		S[i+1] = temp;
		return i+1;				
	}
	public static void quickSort(int[] S, int p, int r){
		int q;
		if(p < r){
			q = partition(S, p, r);
			quickSort(S, p, q-1);
			quickSort(S, q+1, r); 
		}
	}

	public static void main(String[] args) {
		
		quickSort(S, 0, S.length-1);
		for (int i = 0; i < S.length; i++) {
			System.out.println(S[i]);
		}
		

	}

}
