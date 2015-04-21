package files.task7;

import java.io.File;

public class Task7Test {
	public static void main(String[] args) {
		File file = new File("original.txt");
		Compress.compress(file.toPath().toAbsolutePath());
		File file2 = new File("compressFile.compr");
		Compress.decompress(file2.toPath());
	}
}
