package london.syntax.newsgeek.model.entity;

import london.syntax.newsgeek.exception.ScraperValidationException;
import london.syntax.newsgeek.model.AbstractPost;

/**
 * Represents any post which has the features of a news article
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public class News extends AbstractPost {

    private final int points;
    private final int comments;

    public int getPoints() {
        return points;
    }

    public int getComments() {
        return comments;
    }

    public News(int points, int comments, String title, String uri, String author, int rank) {
        super(title, uri, author, rank);
        this.points = points;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return super.toString() + ", News{" + "points=" + points + ", comments=" + comments + '}';
    }

    @Override
    protected void validateInternal() throws ScraperValidationException {
        if (points < 0) {
            throw new ScraperValidationException("Points must not be negative");
        }

        if (comments < 0) {
            throw new ScraperValidationException("Comments must not be negative");
        }
    }
}
