package london.syntax.genscraper.scraper;

import java.util.List;
import london.syntax.genscraper.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Validator;

/**
 * Implements the basic Scraper and enforces validation
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public abstract class AbstractValidatingScraper implements Scraper, Validator {

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
        List<Post> posts = scrapeInternal(max);
        
//        for (Post post: posts) {
//            Errors errors = new Errors();
//            validate(post, errors);
//        }

        return posts;
        
    }

//    private List<Post> validate(List<Post> posts) {
//
//        if (posts == null) {
//            posts = new ArrayList<>();
//        }
//        List<Post> validPosts = new ArrayList<>(posts.size());
//
//        logger.debug("Validating [" + posts.size() + "] posts");
//        for (Post post : posts) {
//            if (post.isValid()) {
//                validPosts.add(post);
//            }
//
//        }
//        logger.debug("Found [" + validPosts.size() + "] valid posts");
//
//        return validPosts;
//    }
}