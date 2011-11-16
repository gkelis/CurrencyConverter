/*
 * Link.java
 * By Fotios P. Gkelis
 * 
 * The "Link" attribute class
 * 
 * http://imfog.wordpress.com
 *
 * Created on Nov 14, 2011
 */
 
public class Link {
  private String redirect_link;
  
  public Link(String redirect_link) {
      this.redirect_link = redirect_link;
  }
  
  public String getLink() {
      return redirect_link;
  }
}