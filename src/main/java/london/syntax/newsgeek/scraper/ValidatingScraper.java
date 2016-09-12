package london.syntax.newsgeek.scraper;

import java.util.List;
import london.syntax.newsgeek.model.Post;

/**
 * Scraper interface for scraping and validating online posts
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public interface ValidatingScraper {

    List<Post> scrape();
}
