package qunar;

import java.util.HashMap;
import java.util.Scanner;

public class Pro2 {
	 public static void main(String args[])
	    {
	        Scanner cin = new Scanner(System.in);
	      
	        while(cin.hasNext())
	        {
	           String s = cin.nextLine();
	           System.out.println(find(s));
	           
	           
	        }
	        }
	
	public static String find (String str){
		String[] sp = str.split("\\.");
		return sp[sp.length-1];
	}
}
