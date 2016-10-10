package leetcode;
import java.util.*;
public class Subsets1 {
	 public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> tmp = new ArrayList<Integer>();
	        Arrays.sort(nums);
	        dfs(res, tmp, nums, 0);
	        return res;
	        
	    }
	 
	 public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int pos){
		 res.add(new ArrayList<Integer>(tmp));// 记录
		 for(int i = pos; i <= nums.length-1; i++){
			 tmp.add(nums[i]);// 选
			 dfs(res, tmp, nums, i+1);
			 tmp.remove(tmp.size()-1);//不选
		 }
	 }

}
