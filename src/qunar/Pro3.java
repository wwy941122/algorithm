package qunar;
import java.util.*;
public class Pro3 {
	public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        List<List<Integer>> ori = new ArrayList<List<Integer>>();
        while(cin.hasNext())
        {
           String s = cin.nextLine();
           String[] str = s.split(" ");
           List<Integer> tmp = new ArrayList<Integer>();
           for(int i =0; i < str.length; i++){
        	   tmp.add(Integer.parseInt(str[i]));
           }
           ori.add(tmp);   
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(List<Integer> l : ori){
        	for(List<Integer> s : ori){
        		merge(result, l, s);
        	}
        }
        for(int i=0;i<result.size();i++)  
        {  
            List<Integer>temp=result.get(i);  
            for(int j=0;j<temp.size();j++)  
                System.out.print(temp.get(j)+" ");  
            System.out.println();  
        }  
        
        
        
     }
	
	
	public static void merge (List<List<Integer>> result,List<Integer> list1, List<Integer> list2){
		int price1 = list1.get(2);
		int price2 = list2.get(2);
		int s1 = list1.get(0);
		int s2 = list2.get(0);
		int e1 = list1.get(1);
		int e2 = list2.get(1);
		
		if(price1 == price2){
			if(s1 < e2){
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(s2);
				tmp.add(e1);
				tmp.add(price1);
				result.add(tmp);
			} else if (s2 < e1){
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(s1);
				tmp.add(e2);
				tmp.add(price1);
				result.add(tmp);
			}
		}
		
	}
}
