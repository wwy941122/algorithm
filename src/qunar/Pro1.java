package qunar;
/*
 * 统计字符
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符。
输入
"qywyery23tdd"
输出
y

样例输入
Have you ever gone shopping and
样例输出
e
 * 
 * */
import java.util.HashMap;
import java.util.*;
public class Pro1 {
	
	 public static void main(String args[])
	    {
	        Scanner cin = new Scanner(System.in);
	      
	        while(cin.hasNext())
	        {
	           String s = cin.nextLine();
	           char result = find(s);
	           if(result >= 'a' && result <='z'){
	        	   System.out.println(result);
	           }else{
	        	   System.out.println(-1);
	           }
	           
	        }
	        }
	
	public static char find (String str){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++){
			char cur = str.charAt(i);
			if(cur >= 'A' && cur <= 'Z'){
				cur = (char) (cur -'A' + 'a');
			}
			if(cur >='a'&& cur <= 'z'){
				if(map.containsKey(cur)){
					int tmp = map.get(cur);
					tmp++;
					if(tmp == 3){
						return cur;
					}
					map.put(cur, tmp);
				} else {
					map.put(cur, 1);
				}
			}
		}
		return '0';
	}
}
