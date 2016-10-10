package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation1 {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        
        dfs(res, tmp, nums, visited);
        return res;
    }
	

	public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] visited){
		if(tmp.size() == nums.length){
			res.add(new ArrayList(tmp));
		} else {
			for(int i = 0; i < nums.length; i++){
				if(visited[i] == false){
					tmp.add(nums[i]);
					visited[i] = true;
					dfs(res, tmp, nums,visited);
					tmp.remove(tmp.size()-1);
					visited[i] = false;
				}
				
			}
		}
	}
	
//	public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums){
//	if(tmp.size() == nums.length){
//		res.add(new ArrayList(tmp));
//	} else {
//		for(int i = 0; i < nums.length; i++){
//			if(tmp.contains(nums[i])) continue;//ÍµÀÁ
//			tmp.add(nums[i]);
//			dfs(res, tmp, nums);
//			tmp.remove(tmp.size()-1);
//		}
//	}
//}
}
