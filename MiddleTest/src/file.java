//중간고사 2번 답
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class file
{ 
      
	public static void main(String[] args) throws IOException {
		File file1 = new File("obama.txt");
		File file2 = new File("test.txt"); 
		char CharCounter = 0;       
		BufferedReader in = (new BufferedReader(new FileReader(file1)));
		PrintWriter out = (new PrintWriter(new FileWriter(file2)));
		int ch;
		while ((ch = in.read()) != -1)
		{
		   if (Character.isLowerCase(ch))  {
		        ch=Character.toUpperCase(ch);
		   }
		out.write(ch);
		}
		in.close();
		out.close();
	}
}