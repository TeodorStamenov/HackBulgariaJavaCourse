package files.task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Compress {
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static File compressFile;
	private static File decompressFile;
	private static ObjectOutputStream oos;
	private static Map<String, Integer> compressMap = new HashMap<String, Integer>();
	private static Map<String, Integer> decompressMap = new HashMap<String, Integer>();
	private static Map<Integer, String> tempMap = new HashMap<Integer, String>();
	private static Object[] tempStringArray;
	private static Object[] tempIntegerArray;
	private static String tmp;
	private static String[] words;
	private static int count = 0;
	private static StringBuilder build = new StringBuilder();

	public static void compress(Path path) {
		try {
			br = new BufferedReader(new FileReader(path.toFile()));

			compressFile = new File("compressFile.compr");
			if (!compressFile.exists()) {
				compressFile.createNewFile();
			}

			while ((tmp = br.readLine()) != null) {
				build.append("\n");
				build.append(setHashMap(tmp));
			}
			oos = new ObjectOutputStream(new FileOutputStream(compressFile));
			oos.writeObject(compressMap);
			oos.close();
			bw = new BufferedWriter(new FileWriter(compressFile, true));
			bw.write(build.toString());
			build.setLength(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void decompress(Path path) {
		try {
			decompressFile = new File("decompressFile.txt");
			if (!decompressFile.exists()) {
				decompressFile.createNewFile();
			}
			fis = new FileInputStream(path.toFile());
			ois = new ObjectInputStream(fis);
			decompressMap = (HashMap<String, Integer>) ois.readObject();
			ois.close();
			fis.close();
			
			br = new BufferedReader(new FileReader(path.toFile()));
			tempStringArray = decompressMap.keySet().toArray();
			tempIntegerArray = decompressMap.values().toArray();
			for (int i = 0; i < decompressMap.size(); i++) {
				tempMap.put((Integer) tempIntegerArray[i],
						(String) tempStringArray[i]);
			}
			while ((tmp = br.readLine()) != null) {
				if (tmp.indexOf("~") == 0) {
					tmp = tmp.replaceAll("~", "").trim();
					words = tmp.replaceAll("[!.?']", "").split(" ");
					for (String word : words) {
						tmp = tmp.replaceFirst(word,
							tempMap.get(Integer.parseInt(word)));
					}
					build.append(tmp);
					build.append("\n");
				}
			}
			br.close();
			bw = new BufferedWriter(new FileWriter(decompressFile));
			bw.write(build.toString());
			build.setLength(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String setHashMap(String str) {
		words = str.replaceAll("[.!?',]", " ").trim().split(" ");
		for (String word : words) {
			if (!compressMap.containsKey(word)) {
				compressMap.put(word, count++);
			}
			str = str.replaceFirst(word, "~" + compressMap.get(word));
		}
		return str;
	}
}
