package sort;

public class CountingSort {
	public static int [] S = {13,19,9,5,12,8,7,4,21,2,6,11};

	public static int[] theFunction(int[] A, int[] B, int k){
		int []C = new int[k];
		for (int i = 0; i < C.length; i++) {
			C[i] = 0;
			
		}
		for (int j = 0; j < A.length; j++) {
			C[A[j]]++;
		}
		for (int i = 1; i < k; i++) {
			C[i] = C[i] + C[i-1];
		}
		for (int j2 = A.length - 1; j2 >= 0; j2--) {
			B[C[A[j2]]] = A[j2];
			C[A[j2]] = C[A[j2]]-1;
		}
		return B;
	}
	public static void main(String[] args) {
		
		int[] result =new int[13];
		result = theFunction(S,result,22);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

}
}
