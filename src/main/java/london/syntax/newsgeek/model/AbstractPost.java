package london.syntax.newsgeek.model;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.logging.Level;
import london.syntax.newsgeek.exception.ScraperValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Base implementation of Posts with the minimal attributes required
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public abstract class AbstractPost implements Post{

    private static final Logger logger = LogManager.getLogger(AbstractPost.class);

    private final String title;
    private final String uri;
    private final String author;
    // Used for ordering the posts
    // TODO: how to sort after merging different post types? Probably need to look at publish date too
    private final int rank;

    protected AbstractPost(String title, String uri, String author, int rank) {
        this.title = title;
        this.uri = uri;
        this.author = author;
        this.rank = rank;
    }

    /**
     * Self-validation for the minimal attributes required for a Post
     *
     * TODO: I imagine this method would end up deprecated in favour of
     * validate(Validator v) where every type of Post implementation (News, Blog
     * etc) would have its own validation impl
     *
     * @throws ScraperValidationException
     */
    @Override
    public void validate() throws ScraperValidationException {
        if (getTitle() == null || getUri() == null || getAuthor() == null) {
            throw new ScraperValidationException("Title, uri and author not set [" + this + "]");
        }

        if (getTitle().isEmpty() || getTitle().length() > 256) {
            throw new ScraperValidationException("Title [" + getTitle() + "] must have between 1 and 256 characters");
        }

        if (getAuthor().isEmpty() || getAuthor().length() > 256) {
            throw new ScraperValidationException("Author [" + getAuthor() + "] must have between 1 and 256 characters");
        }

        if (getRank() < 0) {
            throw new ScraperValidationException("Rank [" + getRank() + "]must not be negative");
        }

        try {
            // Not 100% this will catch all 3986 invalids but time consuming to look into it further right now
            URL url = new URL(getUri());
            url.toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new ScraperValidationException("URI is invalid [" + getUri() + "]", e);
        }

        validateInternal();
    }

    protected abstract void validateInternal() throws ScraperValidationException;

    /**
     * Helper method for validate()
     *
     * @return
     */
    @Override
    public boolean isValid() {
        boolean isValid = false;
        try {
            this.validate();
            isValid = true;
        } catch (ScraperValidationException e) {
            logger.warn("Invalid post [" + this + "]", e);
        }

        return isValid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + this.rank;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractPost other = (AbstractPost) obj;
        if (this.rank != other.rank) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    /**
     * Ordering for top x output
     *
     * @param o to compare to
     * @return Order by rank then title
     */
    @Override
    public int compareTo(Post o) {
        if (this.rank == o.getRank()) {
            return (this.getTitle().compareTo(o.getTitle()));
        }

        return this.getRank() - o.getRank();
    }

    @Override
    public String toString() {
        return "AbstractPost{" + "title=" + title + ", uri=" + uri + ", author=" + author + ", rank=" + rank + '}';
    }

    /**
     * Every post implementation will need a ranking value for ordering
     *
     * @return The rank of the post for sorting purposes
     */
    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public final String getTitle() {
        return title;
    }

    @Override
    public final String getUri() {
        return uri;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
