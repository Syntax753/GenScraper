package london.syntax.genscraper.model;

import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Base implementation of Posts with the minimal attributes required
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public abstract class AbstractPost implements Post {

//    private static final Logger logger = LoggerFactory.getLogger(AbstractPost.class);

    @NotNull
    private final String title;
    
    @NotNull
    private final String uri;
    
    @NotNull
    private final String content;
    
    @NotNull
    private final int rank;

    protected AbstractPost(String title, String uri, String content, int rank) {
        this.title = title;
        this.uri = uri;
        this.content = content;
        this.rank = rank;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.title);
        hash = 61 * hash + Objects.hashCode(this.uri);
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
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.uri, other.uri)) {
            return false;
        }
        return true;
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
//    @Override
//    public final void validate() throws ScraperValidationException {
//        if (getTitle() == null || getUri() == null || getContent() == null) {
//            throw new ScraperValidationException("Missing title, uri or content in [" + this + "]");
//        }
//
//        if (getTitle().isEmpty() || getTitle().length() > 256) {
//            throw new ScraperValidationException("Title [" + getTitle() + "] must have between 1 and 256 characters");
//        }
//
//        if (getContent().isEmpty() || getContent().length() > 256) {
//            throw new ScraperValidationException("Content [" + getAuthor() + "] must have between 1 and 256 characters");
//        }
//
//        if (getRank() < 0) {
//            throw new ScraperValidationException("Rank [" + getRank() + "] must not be negative");
//        }
//
//        try {
//            // Would seem this technique correctly adheres to ISO 3986 with Java 8
//            URL url = new URL(getUri());
//            url.toURI();
//        } catch (MalformedURLException | URISyntaxException e) {
//            throw new ScraperValidationException("URI is invalid [" + getUri() + "]");
//        }
//
//        validateInternal();
//    }
//
//    protected abstract void validateInternal() throws ScraperValidationException;
//
//    /**
//     * Helper method for validate()
//     *
//     * @return
//     */
//    @Override
//    public boolean isValid() {
//        boolean isValid = false;
//        try {
//            this.validate();
//            isValid = true;
//        } catch (ScraperValidationException e) {
//            logger.warn("Invalid post [" + this + "]", e);
//        }
//
//        return isValid;
//    }
//

    

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
        return "AbstractPost{" + "title=" + title + ", uri=" + uri + ", content=" + content + ", rank=" + rank + '}';
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
    public String getContent() {
        return content;
    }
}
