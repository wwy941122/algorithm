package qunar;
/*
 * ͳ���ַ�
ʱ�����ƣ�C/C++���� 1000MS���������� 3000MS
�ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
��Ŀ������
����һ��Ӣ���ַ���,��дһ�δ����ҳ�����ַ��������ȳ������ε��Ǹ�Ӣ���ַ���
����
"qywyery23tdd"
���
y

��������
Have you ever gone shopping and
�������
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
