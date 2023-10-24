import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CountLetter {
	public static int getCount(char c, File f) throws Exception {
		int count = 0;
		try(InputStream in = new FileInputStream(f);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
		{String line = null;
		while((line = reader.readLine()) != null) {
			for(int i =0; i<line.length(); i++) {
				if(c==line.charAt(i)) {
					count++;
				}
			}
		}
	}
		return count;
	}
	
	public static void main(String[] args) throws Exception{
		File file = new File("obama.txt");
		int count = getCount('a', file);
		System.out.println("'a'의 횟수: "+count);
		

	}

}
