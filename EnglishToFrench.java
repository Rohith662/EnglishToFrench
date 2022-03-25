package Demo;

import java.io.*;
import java.util.*;

public class  EnglishToFrench  {
   public static void main(String[] args) {
	   try {long startTime = System.currentTimeMillis();
			File f1 = new File("D:\\Translate\\Eng2fre\\TranslateWords Challenge\\find_words.txt");
			File f2 = new File("D:\\Translate\\Eng2fre\\TranslateWords Challenge\\t8.shakespeare.txt");
			File f3 = new File("D:\\Translate\\Eng2fre\\TranslateWords Challenge\\french_dictionary.csv");
			File f4 = new File("D:\\Translate\\Eng2fre\\TranslateWords Challenge\\t8.shakespeare.translated.txt");
			boolean flag=false;
			String[] line= null;
			String[] fre = new String[2];
			Scanner r1 = new Scanner(f1);
			Scanner r2;
			Scanner r3 = new Scanner(f3);
			BufferedWriter w1 = new BufferedWriter(new FileWriter("D:\\Translate\\Eng2fre\\TranslateWords Challenge\\t8.shakespeare.translated.txt",true));
			
			while(r1.hasNextLine()) {
				flag=false;
				String word = r1.nextLine();
				r2 = new Scanner(f2);
				while(r2.hasNextLine()) {
					String orgLine = r2.nextLine();
					line = orgLine.split(" ");
					for(String i: line) {
						if(i.equals(word)) {
							while(r3.hasNextLine()) {
								fre=r3.nextLine().split(",");
								if(fre[0].equals(word)) {
									orgLine= orgLine.replace(word, fre[1]);
									System.out.println(fre[0]+" "+fre[1]);
									flag=true;
									break;
								}
							}
							w1.write(orgLine);
							w1.write("\n");
							break;
						}
						
					}
					w1.write(orgLine);
					w1.write("\n");
					if (flag){
						r2.close();
						break;
					}
				}r2.close();
			}
			r1.close();
			r3.close();
			w1.close();
		long endTime = System.currentTimeMillis();
				System.out.print("Minutes "+(endTime-startTime)/60000+" Seconds "+((endTime-startTime)/1000)%60);
	}
	catch(IOException e) {
		System.out.print("Error Occured");
	}

}

}
