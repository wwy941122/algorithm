package sort;

import java.lang.reflect.Array;

public class HeapSort2 {
	
	public static void main(String[] args){
		int[] data = new int[] {5, 3, 6, 2, 1, 9, 4, 8, 7};
		//buildMaxHeap(data);
		heapSort(data);
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
		
	}
	public static void buildMaxHeap(int[] array, int lastIndex){
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			int k = i;
			while (2 * k + 1 <= lastIndex){//判断左节点的大小
				int biggerIndex = 2 * k + 1;
				if (biggerIndex < lastIndex){
					if(array[biggerIndex] < array[biggerIndex + 1]){//若右节点大于左节点
						biggerIndex ++;
					}
				}
				if (array[k] < array[biggerIndex]){
					swap(array, k, biggerIndex);
					k = biggerIndex;
				}
				else{
					break;
				}
			}
			
		}
	}
	public static void heapSort(int[] array){
		for (int i = array.length-1; i >= 0; i--){
			buildMaxHeap(array, i);
			swap(array, 0, i);
		}
	}
	public static void swap(int[] data, int i, int j) {  
        if (i == j) {  
            return;  
        }  
        data[i] = data[i] + data[j];  
        data[j] = data[i] - data[j];  
        data[i] = data[i] - data[j];  
    }  

}
