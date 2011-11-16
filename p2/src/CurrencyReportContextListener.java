/*
 * CurrencyReportContextListener.java
 * By Fotios P. Gkelis
 * 
 * The ContextListener
 * 
 * http://imfog.wordpress.com
 *
 * Created on Nov 14, 2011
 */
 
import javax.servlet.*;
import javax.servlet.http.*;

public class CurrencyReportContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
	
        ServletContext sc = event.getServletContext();
		String url = sc.getInitParameter("redirect_link");
		Link link = new Link(url);
        sc.setAttribute("link", link);

    }

    public void contextDestroyed(ServletContextEvent event) {
	}
}