package web.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LoadFile {
	
	public ArrayList<String> Load(String File) {
		
		ArrayList<String> Log = new ArrayList<String>();
		
		try {
			
			FileReader fr = new FileReader(File);
			BufferedReader br = new BufferedReader(fr);
			
	        while (br.ready()) {
	          Log.add(br.readLine());
	        }
		
	        fr.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Log;
		
	}
	
	public static void main(String[] arg) {
		//LoadFile l = new LoadFile();
		//l.Load();
	}
}
