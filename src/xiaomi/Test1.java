package xiaomi;
/**
 * ����һ�����ӣ�ֻ������ĸ�Ϳո񣩣� �������еĵ���λ�÷�ת�������ÿո�ָ�, ����֮��ֻ��һ���ո�ǰ��û�пո�
���磺
��1�� ��hello xiao mi��-> ��mi xiao hello��
����
���������ж��飬ÿ��ռһ�У�����һ������(���ӳ���С��1000���ַ�)
���
����ÿ������ʾ����Ҫ����������е��ʷ�ת���γɵľ���

��������
hello xiao mi
�������
mi xiao hello
 */

import java.util.*;

public class Test1 {
	 public static void main(String[] args){
		 Scanner in = new Scanner(System.in);
		 while(in.hasNext()){
			 String s = in.nextLine();
			 String[] str = s.split(" ");
			 for(int i = str.length-1; i >0; i--){
				 System.out.print(str[i] + " ");
			 }
			 System.out.print(str[0]);
			 }
	 }
}
