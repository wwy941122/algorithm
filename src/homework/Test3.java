package homework;

import java.io.*;
import java.util.*;

public class Test3 {
	private static int BUFFER_SIZE = 10000000;//每个内排的排序个数
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		long start = System.currentTimeMillis();
		File original = new File("D:/yiyi.txt");
		mergeEE(split(original));
		System.out.println("ok");
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "ms");
//		ArrayList<File> list = new ArrayList<File>();
//		File one = new File("D:/ttttt/1.txt");
//		File two = new File("D:/ttttt/2.txt");
//		File three = new File("D:/ttttt/3.txt");
//		File four = new File("D:/ttttt/4.txt");
//		list.add(one);
//		list.add(two);
//		list.add(three);
//		list.add(four);
//		mergeAll(list);
	}
	/*
	 * 
	 * 把大文件分为多个小文件
	 * 
	 * */
	private static ArrayList<File> split(File file) throws NumberFormatException, IOException{
		ArrayList<File> files = new ArrayList<File>();
		int[] buffer = new int[BUFFER_SIZE];
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		boolean isFinished = false;
		while(!isFinished){
			int index = buffer.length;
			for(int i = 0; i < buffer.length; i++){
				String temp = br.readLine();
				if(temp != null){
					buffer[i] = Integer.parseInt(temp);
				} else {
					isFinished = true;
					index = i;
				}
				}
				Arrays.sort(buffer, 0, index);
				File out = new File("D:/ttttt/set" + new Random().nextInt() + ".txt");
				FileWriter fw = new FileWriter(out);
				BufferedWriter bw = new BufferedWriter(fw);
				for (int j = 0; j < index; j++) {
					bw.write(String.valueOf(buffer[j]) + System.getProperty("line.separator")); 
				}
				bw.close();
				fw.close();
				files.add(out);

	
		}
		br.close();
		fr.close();
		return files;
		
	}
	/*
	 * 合并所有已排好序的小文件
	 * 
	 * */
	private static File mergeAll(ArrayList<File> list) throws IOException{
		if(list.size() == 1){
			return list.get(0);
		}
		ArrayList<File> inter = new ArrayList<File>();
		for(Iterator<File> it = list.iterator(); it.hasNext();){
			File one = it.next();
			if(it.hasNext()){
				File two =  it.next();
				inter.add(merge(one,two));
				
			}else {
				return one;
			}
		}
		return mergeAll(inter);
	}
	private static void mergeEE(ArrayList<File> list) throws IOException{
		if(list.size() == 1){
			return;
			}
		
		ArrayList<File> inter = new ArrayList<File>();
		for(Iterator<File> it = list.iterator(); it.hasNext();){
			File one = it.next();
			if(it.hasNext()){
				File two =  it.next();
				inter.add(merge(one,two));
				
			} else {
				inter.add(one);
		}
		mergeEE(inter);
		}
		
	}
	
	/*
	 * 合并两个已排好序的小文件
	 * 
	 * */
	public static File merge(File one, File two) throws IOException{//归并两个已排好序的文件
		FileReader fr1 = new FileReader(one);
		FileReader fr2 = new FileReader(two);
		BufferedReader br1 = new BufferedReader(fr1);
		BufferedReader br2 = new BufferedReader(fr2);
		
		//File output = new File("D:/ttttt/output.txt");
		File output = new File("D:/ttttt/merge" + new Random().nextInt() + ".txt");
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		String s1 = br1.readLine();
		String s2 = br2.readLine();	
		boolean finish = false;

		while(!finish){
			
			if((s1 != null) && (s2 != null)){ 
				if(Integer.parseInt(s1) < Integer.parseInt(s2)){
					bw.write(s1 + System.getProperty("line.separator"));
					s1 = br1.readLine();
				} else {
					bw.write(s2 + System.getProperty("line.separator"));
					s2 = br2.readLine();
				}
			} else if((s1 == null) && (s2 != null)) {
				bw.write(s2 + System.getProperty("line.separator"));
				s2 = br2.readLine();
			} else if((s1 != null) && (s2 == null)){
				bw.write(s1 + System.getProperty("line.separator"));
				s1 = br1.readLine();
			} else {
				finish = true;
			}
			
		}
		bw.close();
		fw.close();
		br2.close();
		br1.close();
		fr1.close();
		fr2.close();
		
		
		return output;
		
	}

}
