package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pertuation2 {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, tmp, nums, visited);
        return res;
    }
	

	public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] visited){
		if(tmp.size() == nums.length){
			res.add(new ArrayList(tmp));
		} else {
			for(int i = 0; i < nums.length; i++){
				if(visited[i] == true || (i > 0 && nums[i] == nums[i-1] && !visited[i -1])) continue;
					tmp.add(nums[i]);
					visited[i] = true;
					dfs(res, tmp, nums,visited);
					tmp.remove(tmp.size()-1);
					visited[i] = false;
				
				
			}
		}
	}

}
