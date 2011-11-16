/*
 * CurrencyCode.java
 * By Fotios P. Gkelis
 * 
 * redirecting the user to the
 * specified project(source code) 
 * resource by calling the
 * sendRedirect() method
 * 
 * http://imfog.wordpress.com
 *
 * Created on Nov 14, 2011
 */
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrencyCode extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
	  
		response.sendRedirect("https://github.com/gkelis/CurrencyConverter/tarball/master");
  }
} 