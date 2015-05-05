package rest.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	public static List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }
	
//	public static void main(String[] args) throws IOException {
//			Queue<String> urls = new LinkedList<String>();
//			URL test = new URL("http://ebusiness.free.bg/");
//			BufferedReader br = new BufferedReader(new InputStreamReader(test.openStream()));
//			String input;
//			while ((input = br.readLine()) != null) {
//				System.out.println(input);
//			}
//			br.close();
//			List<String> list = getAllLinks(" ");
//			System.out.println(list);
//	}

}
