package files.task5;

public class ReduceFilePath {
	public static String reduceFilePath(String path) {
		
		return path.replaceAll("(\\w+/[.]{2}/)|[.]{2}/", "").replaceAll("/[.]", "").replaceAll("(//+)", "/").replaceAll("^/$", "//").replaceAll("/$", "");
		
	}
}
