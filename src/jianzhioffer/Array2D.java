package jianzhioffer;

public class Array2D {
	 public static boolean Find(int [][] array,int target) {
	        for (int i = 0; i < array.length; i++){
	            int low = 0;
	            int high = array[i].length - 1;
	            while(low <= high){
	                int mid = (low + high)/2;
	                if(array[i][mid] < target){
	                    low = mid + 1;
	                } else if(array[i][mid] > target){
	                    high = mid - 1;
	                } else {
	                    return true;
	                }
	            }
	        }
	        return false;

	    }
	 public static void main(String[] args){
		 int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		 for(int[] a: array){
			 for(int i : a){
				 System.out.print(i + " ");
				 }
			 System.out.println();
		 }
		 System.out.println(Find(array,1));
		 
		 
	 }

}
