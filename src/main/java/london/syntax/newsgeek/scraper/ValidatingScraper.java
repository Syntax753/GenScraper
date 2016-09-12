package london.syntax.newsgeek.scraper;

import com.google.gson.Gson;
import java.util.Collections;
import java.util.List;
import london.syntax.newsgeek.model.Post;

/**
 * Scraper interface for scraping and validating online posts
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public interface ValidatingScraper {

    List<Post> scrape(int max);
    
    /**
     * Using Java 8's "default" implementation for thsi one but would probably
     * be better in a dedicated util class or the abstract implementing class
     * 
     * @param posts Posts to be Jsonised. These will be sorted first
     * @return String representation
     */
    default String asJson(List<Post> posts) {
        Collections.sort(posts);
        return new Gson().toJson(posts);
    }
}
