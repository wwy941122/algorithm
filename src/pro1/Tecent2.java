package pro1;



import java.util.Scanner;
public class Tecent2 {
	public static void main(String[] args){
		//ArrayList<String> list = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		String origin = in.nextLine();
		in.close();
		String[] s = origin.split(" ");
		for(int i = s.length - 1; i >= 0; i--){
				int length = s[i].length();
				if(s[i].charAt(length) == '.'){
					
				}
				System.out.print(s[i] + " ");
			
		}
	}
	
	

}
