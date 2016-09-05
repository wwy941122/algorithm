package JD;
/*
 * ������
ʱ�����ƣ�C/C++���� 1000MS���������� 3000MS
�ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
��Ŀ������
С��ͬѧѧϰ�˲�ͬ�Ľ���֮��������һЩ������������Ϸ��С��ͬѧ֪�������ճ�������������õ���ʮ�����������ڼ�����У���������Ҳ�ܳ��á����ڶ���һ������x��С��ͬѧ���������������f(x)��g(x)��
f(x)��ʾ��x�������ʮ����д���������λ�ϵ�����֮�͡���f(123)=1+2+3=6��
g(x)��ʾ��x������ö�����д���������λ�ϵ�����֮�͡���123�Ķ����Ʊ�ʾΪ1111011����ôg(123)=1+1+1+1+0+1+1=6��
С��ͬѧ���ֶ���һЩ������x����f(x)=g(x)�������������ֳ�Ϊ����������������֪����С�ڵ���n���������ж��ٸ���
 * */

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		
		for(;m > 0; m--){
			int count = 0;
			int standard = in.nextInt();
			for(int i = 1; i <= standard; i++){
				if(lucky(i) == true){
					count++;
				}
			}
			System.out.println(count);
		}
		
		
			

	}
	
	public static boolean lucky(int n){
		int nn = n;
		String bin = Integer.toBinaryString(n);
		int sumbin = 0, sum = 0;
		for(int i = 0; i < bin.length(); i++){
			sumbin += (n & (0x1 << i)) >> i;
		}
		//System.out.println(sumbin);
		while(nn > 0){
			sum += nn % 10;
			nn = nn / 10;
		}
		//System.out.println(sum);
		//return (sum == sumbin) ? true : false;
		if(sum == sumbin){
			return true;
		} else {
			return false;
		}
		
	}

}
