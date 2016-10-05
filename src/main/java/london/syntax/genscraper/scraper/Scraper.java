package london.syntax.genscraper.scraper;

import com.google.gson.Gson;
import java.util.Collections;
import java.util.List;
import london.syntax.genscraper.model.Post;

/**
 * Scraper interface for scraping and validating online posts
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public interface Scraper {

    List<Post> scrape(int max);
    
    /**
     * Convert List to json using Java 8 "default implementation"
     * 
     * @param posts Posts to be Jsonised. These will be sorted first
     * @return String representation
     */
    default String asJson(List<Post> posts) {
        Collections.sort(posts);
        return new Gson().toJson(posts);
    }
}
