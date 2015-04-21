package files.task6;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindBrokenLinkRecursively {
	private static Stack<File> stack = new Stack<File>();
	private static File[] files;
	private static List<Path> brokenLinksList = new ArrayList<Path>();
	private static Path tempPath;

	public static void findBadLink(Path path) {

		if (!path.toFile().exists()) {
			throw new InvalidPathException("Path not found!",
					"Directory doesn't exist!");
		}

		files = path.toFile().listFiles();

		for (File f : files) {
			stack.push(f);
		}

		while (!stack.isEmpty()) {
			tempPath = stack.pop().toPath();
			if (Files.isSymbolicLink(tempPath)) {
				if (!Files.exists(tempPath)) {
					brokenLinksList.add(tempPath);
				}
			} else if (Files.isDirectory(tempPath)) {
				findBadLink(tempPath);
			}
		}

		if (!brokenLinksList.isEmpty()) {
			System.out.println("Recursively:");
		}

		for (Path p : brokenLinksList) {
			System.out.println(p);
		}

		brokenLinksList.clear();
	}
}
