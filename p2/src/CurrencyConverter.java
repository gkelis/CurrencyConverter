/*
 * Currency Converter
 * Using Yahoo Finance
 * CurrencyConverter.java
 * By Fotios P. Gkelis
 * 
 * http://imfog.wordpress.com
 *
 * Created on Nov 6, 2011
 */
 
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class CurrencyConverter extends HttpServlet {
    public void doGet(HttpServletRequest req,
                    HttpServletResponse res)
                    throws ServletException, IOException {
			res.setContentType("text/html");
            PrintWriter out = res.getWriter();
			out.println("<html>");
            out.println("<head><title>Currency Conversion</title></head>");
            out.println("<body>");
			
			// Get curreny from, currency to and amount to convert
		    String curFrom  = req.getParameter("curFrom");
		    String curTo  = req.getParameter("curTo");
            String amount = req.getParameter("amount");
			
		    String[] temp = null;
			temp = curFrom.split(" - ");
			String curFromTitle = temp[0];
			String curFromCode = temp[1];

			temp = curTo.split(" - ");
			String curToTitle = temp[0];
			String curToCode = temp[1];
			
			String URL = "http://finance.yahoo.com/q/bc?s=" + curFromCode + "" + curToCode + "=X&t=5d&l=on&z=m&q=l&c=";
			
            try {
				// Fetch results from Yahoo
				String results = "";
				URL thePage = new URL(URL);
				BufferedReader in = new BufferedReader(new InputStreamReader(thePage.openStream()));
				String inputLine;

				while ((inputLine = in.readLine()) != null) {
				// Process each line.
                results = results + inputLine;
				}
				in.close();
				
				// Pattern matching
				Pattern finalPattern = Pattern.compile("x\">([0-9.]+)</span>");
				Matcher matchFind = finalPattern.matcher(results);
				matchFind.find();
				
				// Calculate the converted amount
				double curRate = Double.valueOf(matchFind.group(1)).doubleValue();
				double totalConvert = curRate * Double.valueOf(amount).doubleValue();
				NumberFormat formatter = new DecimalFormat("#0.000");
				
				// Trade time matching
				finalPattern = Pattern.compile("<span id=\"yfs_t10_[a-zA-Z]+=x\">(.*)</span>:");
				matchFind = finalPattern.matcher(results);
				matchFind.find();
               
			    // Print the conversion
				out.println("<BIG>" + amount + " " +
                    curFromCode + " = " + formatter.format(totalConvert) + 
					" " + curToCode + "</BIG>");
				
				// Print when trade matching occured
				out.println("<p>" + "<BIG>" + "Currency Rates Updated At: " +
					matchFind.group(1) + "</BIG>" + "</p>");
            }
			
            catch (Exception e) {
                out.println("Bad number format");
            }
			
            out.println("</body></html>"); 
    }
}