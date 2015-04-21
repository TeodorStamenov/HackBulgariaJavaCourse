package files.task4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class EncodingSubtitle {
	private static File file;
	private static BufferedWriter bw;
	private static byte[] stringInBytes;

	public static void fixEncoding(Path path) {
		try {
			file = path.toFile();

			File file2 = new File("fileNewSubsUTF.srt");

			if (!file2.exists()) {
				file2.createNewFile();
			}

			stringInBytes = Files.readAllBytes(path);
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file2), "UTF-8"));
			bw.write(new String(stringInBytes, "Windows-1251"));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
