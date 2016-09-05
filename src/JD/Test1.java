package JD;
/*
 * 幸运数
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
小明同学学习了不同的进制之后，拿起了一些数字做起了游戏。小明同学知道，在日常生活中我们最常用的是十进制数，而在计算机中，二进制数也很常用。现在对于一个数字x，小明同学定义出了两个函数f(x)和g(x)。
f(x)表示把x这个数用十进制写出后各个数位上的数字之和。如f(123)=1+2+3=6。
g(x)表示把x这个数用二进制写出后各个数位上的数字之和。如123的二进制表示为1111011，那么g(123)=1+1+1+1+0+1+1=6。
小明同学发现对于一些正整数x满足f(x)=g(x)，他把这种数字称为幸运数，现在他想知道，小于等于n的幸运数有多少个。
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
