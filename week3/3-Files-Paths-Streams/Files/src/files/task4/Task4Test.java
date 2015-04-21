package files.task4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Task4Test {
	public static void main(String[] args) throws IOException {
		File file = new File("lost.srt");
		Path path = file.toPath();
		EncodingSubtitle.fixEncoding(path);
	}
}