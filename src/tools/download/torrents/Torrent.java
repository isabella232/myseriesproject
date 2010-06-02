/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tools.download.torrents;

import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author lordovol
 */
public class Torrent {
  /**
   * The torrents path : "torrents/"
   */
  public static final String TORRENTS_PATH = "torrents/";
  /**
   * The eztv rss link "http://ezrss.it/search/index.php?"
   */
  public static String EZTV_RSS = "http://ezrss.it/search/index.php?";
  /**
   * List of qualities
   */
  public static String[] QUALITIES = {"", "HDTV", "720p", "1080i", "1080p", "DSRip", "DVBRip", "DVDR", "DVDRip", "DVDScr", "HR.HDTV", "HR.PDTV", "PDTV", "SatRip", "SVCD", "TVRip", "WebRip"};
  /**
   * The torrents title
   */
  public String title;
  /**
   * The torrents link
   */
  public String link;

  public Torrent(String title, String link) {
    this.title = title;
    this.link = link;
  }

  @Override
  public String toString() {
    return title;
  }

  /**
   * Gets the torrents URI
   * @return The torrents URI or null if there's a syntax error
   */
  public URI getUri() {
   String encodedLink = link.replaceAll("\\[", "%5B");
    encodedLink = encodedLink.replaceAll("\\]", "%5D");
    try {
      return new URI(encodedLink);
    } catch (URISyntaxException ex) {
      return null;
    }
  }


}
