/*
 * CurrencyReport.java
 * By Fotios P. Gkelis
 * 
 * redirecting the user to the
 * specified info resource
 * through a ContextListener
 * 
 * http://imfog.wordpress.com
 *
 * Created on Nov 14, 2011
 */
 
import javax.servlet.http.*;
import java.io.*;

public class CurrencyReport extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
	
		try{
		
			Link link = (Link)getServletContext().getAttribute("link");
			response.sendRedirect(link.getLink());
			
			}
				
		catch (IOException ex) {
		}
    }   
}