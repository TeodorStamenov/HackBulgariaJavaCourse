package rest.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	private static Stack<URL> stack = new Stack<URL>();
	private static URL url;

	public static void checkForLink(String content) {
		URL tempUrl;
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			try {
                if (!matcher.toString().contains("index.html") && !matcher.toString().contains("http://") && !matcher.toString().contains("https://")) {
                	tempUrl = new URL(String.format("%s%s", url.toString() + "/", matcher.group(1)));
                	stack.push(tempUrl);
                }
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void search(String webAddress, String needle) {
		BufferedReader read = null;
		String input;
		try {
			url = new URL(webAddress);
			stack.push(url);
			while (!stack.isEmpty()) {
				url = stack.pop();
				read = new BufferedReader(new InputStreamReader(
						url.openStream(), "UTF-8"));
				while ((input = read.readLine()) != null) {
					if (input.indexOf(needle) != -1) {
						System.out.println(url.toString());
						stack.clear();
						break;
					} else {
						checkForLink(input);
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
