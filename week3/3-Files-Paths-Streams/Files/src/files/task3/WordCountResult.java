package files.task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class WordCountResult {
	private static BufferedReader br;
	private static char[] countCharsWords;
	public static int countLines;
	public static int countChars;
	public static int countWords;
	private static String tmp;
	private static WordCountResult instance = null;
	
	public static WordCountResult wordCount(File file) {
		setLineCharWordCount(file);
		return instance;
	}
	
	public static WordCountResult wordCount(Path path) {
		wordCount(path.toFile());
		return instance;
	}
	
	private WordCountResult() {
	}
	
	private static void setLineCharWordCount(File file) {
		try {
			countLines = 0;
			countWords = 0;
			countChars = 0;
			br = new BufferedReader(new FileReader(file));
			while ((tmp = br.readLine()) != null) {
				countLinesCharsWords(tmp);
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
	}
	
	private static void countLinesCharsWords(String str) {
		int cntCh = 0;
		int cntW = 0;
		int cntL = 0;
		
		countCharsWords = str.toCharArray();
		
		for (int i = 0; i < countCharsWords.length; i++) {
			if(!Character.isWhitespace(countCharsWords[i])) {
				cntCh++;
			} else if (cntCh != 0){
				cntW++;
			}
		}
		
		if (cntCh != 0)
			cntW++;
			
		cntL++;
		
		countLines = countLines + cntL;
		countWords = countWords + cntW;
		countChars = countChars + cntCh;
	}
}
