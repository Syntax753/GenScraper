package london.syntax.genscraper.model.entity;

import london.syntax.genscraper.exception.ScraperValidationException;
import london.syntax.genscraper.model.AbstractPost;

/**
 * Represents any post which has the features of a news article
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public class News extends AbstractPost {

    private final int points;
    private final int comments;
    private final String author;

    public int getPoints() {
        return points;
    }

    public int getComments() {
        return comments;
    }

    public String getAuthor() {
        return author;
    }

    public News(String title, String uri, String content, int rank, String author, int points, int comments) {
        super(title, uri, content, rank);
        this.points = points;
        this.comments = comments;
        this.author = author;
    }

    
    
//    @Override
//    public String toString() {
//        return super.toString() + ", News{" + "points=" + points + ", comments=" + comments + '}';
//    }

//    @Override
//    protected void validateInternal() throws ScraperValidationException {
//        if (points < 0) {
//            throw new ScraperValidationException("Points must not be negative [" + points + "]");
//        }
//
//        if (comments < 0) {
//            throw new ScraperValidationException("Comments must not be negative [" + comments + "]");
//        }
//    }

    @Override
    public String toString() {
        return super.toString() + ", News{" + "points=" + points + ", comments=" + comments + ", author=" + author + '}';
    }
}
