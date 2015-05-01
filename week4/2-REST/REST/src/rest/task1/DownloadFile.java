package rest.task1;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFile {
	private static URL download;
	private static ByteArrayOutputStream out;
	private static FileOutputStream fos;
	private static InputStream in;
	private static File file;
	private static int numRead;

	public static void download(String url) {
		try {
			download = new URL(url);
			in = new BufferedInputStream(download.openStream());
			out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			while ((numRead = in.read(buf)) != -1) {
				out.write(buf, 0, numRead);
			}
			out.close();
			in.close();
			byte[] arr = out.toByteArray();
			file = new File("downloadedFile.jpg");
			if(!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			fos.write(arr);
			fos.close();
			System.out.println("Finished");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
