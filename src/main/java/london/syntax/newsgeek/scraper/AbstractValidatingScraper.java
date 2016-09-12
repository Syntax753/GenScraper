package london.syntax.newsgeek.scraper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import london.syntax.newsgeek.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the basic Scraper and enforces validation Note the List of Posts
 * is being passed around rather than stored here as a field
 * <p>
 * Scraping will be very different from site to site so state information so
 * scoping state information to implementing classes
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public abstract class AbstractValidatingScraper implements ValidatingScraper {

    protected static Logger logger = LoggerFactory.getLogger(AbstractValidatingScraper.class);

    /**
     * Delegate the scraping logic to subclass
     *
     * @param max Maximum number of posts to scrape
     * @return posts All the scraped posts from the relevant site
     */
    protected abstract List<Post> scrapeInternal(int max);

    /**
     * Full scraping workflow - enforces validation after scraping
     *
     * @param max Maximum number of posts to scrape
     * @return posts All the valid posts
     */
    @Override
    public final List<Post> scrape(int max) {
        logger.debug("Scraping [" + max + "] posts");
        return validate(scrapeInternal(max));
    }

    private List<Post> validate(List<Post> posts) {

        if (posts == null) {
            posts = Collections.EMPTY_LIST;
        }
        List<Post> validPosts = new ArrayList<>(posts.size());

        logger.debug("Validating [" + posts.size() + "] posts");
        for (Post post : posts) {
            if (post.isValid()) {
                validPosts.add(post);
            }

        }
        logger.debug("Found [" + validPosts.size() + "] valid posts");

        return validPosts;
    }
}
