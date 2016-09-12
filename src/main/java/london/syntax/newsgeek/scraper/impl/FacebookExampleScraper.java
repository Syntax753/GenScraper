package london.syntax.newsgeek.scraper.impl;

import java.util.List;
import london.syntax.newsgeek.model.Post;
import london.syntax.newsgeek.scraper.AbstractValidatingScraper;
import org.springframework.stereotype.Service;

/**
 * Example scraper for grabbing a list of scrapped Blog objects from Facebook
 * 
 * @author Peter Turner <syntax.valid@gmail.com>
 */
@Service("facebookScraper")
public class FacebookExampleScraper extends AbstractValidatingScraper {

    @Override
    protected final List<Post> scrapeInternal(int max) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 }
