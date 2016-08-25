package pro1;


import java.util.Scanner;


public class Tencent {
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		String origin = in.nextLine();
		in.close();
		boolean ifCapital = false;

		
	
		
		char[] array = origin.toCharArray();

		for (int i = array.length - 1; i >=0; i--){
			if(array[i] == ' '){
				for(int j = i+1; j < array.length; j++){
					if(ifCapital == true && array[j] <= 122 && array[j] >= 97){
						array[j] = (char) (array[j] - ('a' - 'A'));
						if(array[j] != ' '){
							System.out.print(array[j]);
						}
						
						ifCapital = false;
					}else{
						if(array[j] != ' '){
							System.out.print(array[j]);
						}
						
					}
					if(array[j] == '.'){
						ifCapital = true;
					}
					array[j] = ' ';
				}
				System.out.print(' ');
				
			}
			
		}
		System.out.print(array);
		
		//System.out.println(list.toString());
		
		
	}

}
