package files.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Properties {
	private static BufferedReader br;
	private static String currentLine;
	private static int index;
	private static String tempString;
	private static String key;
	private static String value;
	private static Map<String, String> map = new HashMap<String, String>();
	
	
	public static Map<String, String> parseProperties(File file) {
		try {
			br = new BufferedReader(new FileReader(file));
			while ((currentLine = br.readLine()) != null) {
				setKeyValue(currentLine);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return getMap();	
	}

	private static void setKeyValue(String str) {
		tempString = str.trim().replace(" ", "");
		
		if (tempString.charAt(0) != '#') { 
			
			index = tempString.indexOf("=");
			key = tempString.substring(0, index);
			value = tempString.substring(index + 1, tempString.length());
			setHashMap(key, value);
			
		}
	}
	
	private static void setHashMap(String key, String value) {
		map.put(key, value);
	}
	
	private static Map<String, String> getMap() {
		return map;
	}
}
