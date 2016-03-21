package sort;

public class HeapSort {
	
	public static void main(String[] args){
		int[] data = new int[] {5, 3, 6, 2, 1, 9, 4, 8, 7};
		//buildMaxHeap(data);
		heapSort(data);
		for(int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
		
	}
	
	/**
	 * 算法导论上的递归方法
	 * @param array
	 * @param i
	 */
	public static void maxHeap(int[] array, int i){
		int largest; 
		int leftChild = 2 * i +1;
		int rightChild = 2 * i + 2;
		if(leftChild < array.length && array[leftChild] > array[i]){
			largest = leftChild;
		}
		else{
			largest = i;
		}
		if(rightChild < array.length && array[rightChild] > array[largest]){
			largest = rightChild;
		}
		if(largest != i){
			swap(array, largest, i);
			maxHeap(array, largest);
		}
		
		
	}
	
	public static void buildMaxHeap(int[] array){
		for(int i = (array.length - 1) / 2 - 1 ; i >= 1; i--){
			maxHeap(array, i);
		}
	}
	
	public static void heapSort(int[] array){
		buildMaxHeap(array);
		for (int i = (array.length-1); i>=0; i--){
			swap(array,0,i);
			maxHeap(array, 0);
			
		}
	}
	
	public static void swap (int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
