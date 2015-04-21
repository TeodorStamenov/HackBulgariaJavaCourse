package files.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class FileUtils {
	private static String currentLine;
	private static BufferedReader br;
	private static StringBuilder strB = new StringBuilder();
	
	private static FileUtils instance = null;
	
	public static FileUtils getInstance() {
		return instance;
	}
	
	private FileUtils() {
	}
	
	public static String readFrom(File file) {
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			while ((currentLine = br.readLine()) != null) {
				strB.append(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		return strB.toString();
	}
	
	public static String readFrom(Path path) {
		return readFrom(path.toFile());
	}	
	
}
