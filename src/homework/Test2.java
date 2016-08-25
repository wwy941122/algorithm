package homework;

import java.io.*;





public class Test2 {
	final static int MAX = 100000000;
	public static int[] theArray = new int[MAX];

	
	public static int partition(int[] S, int p, int r){
		int i = p-1;
		int j;
		int x = S[r];
		for ( j = p; j < r; j++) {
			if(S[j] <= x){
				i++;
				int temp;
				temp = S[j];  //交换
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
	
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		
		File file = new File("D:/yiyi.txt");
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			for(int i = 0; i < theArray.length; i++){
				theArray[i] = Integer.parseInt(reader.readLine());
			}
			System.out.println("读取成功");
			reader.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Arrays.sort(theArray);


		quickSort(theArray,0, MAX -1);
		
//		for(int i = 0; i < theArray.length; i++){
//			System.out.println(theArray[i]);
//		}
		
		
		
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "ms");
	}

}
