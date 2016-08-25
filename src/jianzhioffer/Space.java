package jianzhioffer;

public class Space {
	 public static String replace (StringBuffer str){
		 int spacenum = 0;
		 for(int i = 0; i < str.length(); i++){
			 if (str.charAt(i) == ' '){
				 spacenum++;
			 }
		 }
		 
		 int oldLength = str.length();
		 int newLength = oldLength + 2 * spacenum;
		 str.setLength(newLength);
		 int oldIndex = oldLength - 1;
		 int newIndex = newLength - 1;
		 
		 while(oldIndex >= 0 && oldIndex <= newIndex){
			 if(str.charAt(oldIndex) == ' '){
				 str.setCharAt(newIndex--, '0');
				 str.setCharAt(newIndex--, '2');
				 str.setCharAt(newIndex--, '%');
			 } else {
				 str.setCharAt(newIndex--, str.charAt(oldIndex));
			 }
			 oldIndex--;
		 }
		 
		 return str.toString();
	 }
	 
	 public static void main(String[] args){
		 
		 StringBuffer sb = new StringBuffer("Happy fefe fefe ww");
		 String s = replace(sb);
		 System.out.println(s);
	 }

}
