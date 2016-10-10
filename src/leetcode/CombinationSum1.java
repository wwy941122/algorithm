package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 其实和Subset是一种题，就是求子集的各种可能
public class CombinationSum1 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        List<Integer> tmp = new ArrayList<Integer>();  
        Arrays.sort(candidates);  
        dfs(res,tmp,candidates,target,0);  
        return res;  
    }
	
	public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] candi, int target, int pos){
		if(target < 0){
			return;
		} else if (target == 0){
			res.add(new ArrayList<Integer>(tmp));
		} else {
			for(int i = pos; i < candi.length; i++){
				tmp.add(candi[i]);
				dfs(res, tmp, candi,target-candi[i], i);
				tmp.remove(tmp.size()-1);
			}
		}
	}
	
	//第二种解法，也就是每次只拿大于等于的数，阻止重复拿
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        List<Integer> tmp = new ArrayList<Integer>();  
        Arrays.sort(candidates);  
        dfs2(res,tmp,candidates,target);  
        return res;  
    }
	
	public void dfs2(List<List<Integer>> res, List<Integer> tmp, int[] candi, int target){
		if(target < 0){
			return;
		} else if (target == 0){
			res.add(new ArrayList<Integer>(tmp));
		} else {
			for(int i = 0; i < candi.length; i++){
			     int a = tmp.size();
			     if(a == 0){
			        tmp.add(candi[i]);
					dfs2(res, tmp, candi,target-candi[i]);
					tmp.remove(tmp.size()-1);
			     }else{
			          if(candi[i] >= tmp.get(a-1)){
			        tmp.add(candi[i]);
					dfs2(res, tmp, candi,target-candi[i]);
					tmp.remove(tmp.size()-1);
			      }
			     }
			     
					
			
				
			}
		}
	}
}
