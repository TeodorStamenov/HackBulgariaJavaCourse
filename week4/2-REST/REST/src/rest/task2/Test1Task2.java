package rest.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Test1Task2 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://ebusiness.free.bg");
		BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
		String input;
		StringBuilder strBuild = new StringBuilder();
		while ((input = read.readLine()) != null) {
			strBuild.append(input);
		}
		read.close();
		List<String> str = WebCrawler.getAllLinks(strBuild.toString());
		for (String s : str){
			System.out.println(s);
		}
	}

}