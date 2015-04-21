package files.task6;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBrokenLinkBFS {
	private static Queue<Path> directories = new LinkedList<Path>();
	private static Path tempPath;
	private static File[] childrenDirectories;
	private static List<Path> brokenLinks = new ArrayList<Path>();

	public static void findBadLink(Path path) {
		if (!path.toFile().exists()) {
			throw new InvalidPathException("Wrong path!", "Path not found!");
		}

		directories.offer(path);

		while (!directories.isEmpty()) {
			tempPath = directories.poll();
			childrenDirectories = tempPath.toFile().listFiles();

			for (File f : childrenDirectories) {
				if (Files.isSymbolicLink(f.toPath())
						&& !Files.exists(f.toPath())) {
					brokenLinks.add(f.toPath());
				} else if (f.isDirectory()) {
					directories.offer(f.toPath());
				}
			}
		}

		System.out.println("BFS:");
		for (Path p : brokenLinks) {
			System.out.println(p);
		}
	}
}
