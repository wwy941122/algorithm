package homework;
/*生成随机数
 * 
 * */
import java.io.*;
import java.util.Random;

public class Test1 {
	public static void main(String[] args){
		
		
		try {
			File file = new File("D:/5000w.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			Random ra = new Random();
			for (int i = 0; i < 50000000; i++){
				int temp = ra.nextInt(65535);
				//System.out.println(temp);
				writer.write(String.valueOf(temp) + System.getProperty("line.separator")); 
				//writer.newLine();
				
			} 
			
			writer.close();
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("完成");
		
	}

}
