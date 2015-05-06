package servlet.task2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * Servlet implementation class NewsAgregator
 */
@WebServlet("/NewsAgregator")
public class NewsAgregator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsAgregator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		try {
			URL url1 = new URL("http://www.sportal.bg/uploads/rss_category_2.xml");
			HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
			SyndFeedInput in = new SyndFeedInput();
			SyndFeed feed = in.build(new XmlReader(con1));
			List<?> entries = feed.getEntries();
			Iterator<?> itEntries = entries.iterator();
			while (itEntries.hasNext()) {
	            SyndEntry entry = (SyndEntry) itEntries.next();
	            writer.append("<a href='" + entry.getLink() + "'>" + entry.getTitle() + "</a>" + "<br/>");
	            writer.append(entry.getDescription().getValue());
	        }
			writer.flush();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (FeedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
