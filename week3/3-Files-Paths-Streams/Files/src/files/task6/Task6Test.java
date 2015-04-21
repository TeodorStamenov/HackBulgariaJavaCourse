package files.task6;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Task6Test {

	public static void main(String[] args) {
		Path path = Paths.get("D:\\blinks");
		FindBrokenLinkRecursively.findBadLink(path);
		FindBrokenLinkBFS.findBadLink(path);
	}
}
