package london.syntax.newsgeek.model.entity;

import london.syntax.newsgeek.exception.ScraperValidationException;
import london.syntax.newsgeek.model.AbstractPost;

/**
 * Example for a blog post
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public class BlogExample extends AbstractPost {

    private final int like;

    public final int getLike() {
        return like;
    }

    public BlogExample(int like, String title, String uri, String author, int rank) {
        super(title, uri, author, rank);
        this.like = like;
    }

    @Override
    public String toString() {
        return super.toString() + ", BlogExample{" + "like=" + like + '}';
    }

    @Override
    protected void validateInternal() throws ScraperValidationException {
        if (like < 0) {
            throw new ScraperValidationException("Likes must not be negative");
        }
    }
}
