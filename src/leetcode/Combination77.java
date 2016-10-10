package leetcode;
import java.util.*;
public class Combination77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        dfs(n, k, 1, tmp, res);
        return res;
    }
	
	
	public void dfs(int n, int k, int pos, List<Integer> tmp, List<List<Integer>> res){
		if(k < 0) {
			return;
		} else if (k == 0) {
			res.add(new ArrayList(tmp));
		} else{
			for(int i = pos; i <= n; i++){
				tmp.add(i);
				dfs(n, k-1, i+1, tmp, res);
				tmp.remove(tmp.size()-1);
			}
		}
	}

}
