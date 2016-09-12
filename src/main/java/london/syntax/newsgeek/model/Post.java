package london.syntax.newsgeek.model;

import london.syntax.newsgeek.exception.ScraperValidationException;

/**
 * Interface for common attributes shared among online posts/articles/blogs etc
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public interface Post {

    String getTitle();

    String getUri();

    String getAuthor();

    /**
     * Ranking for ordering
     * 
     * @return rank of post and used for ordering
     */
    int getRank();

    void validate() throws ScraperValidationException;

    /**
     * Each post implements the business rules to self-validate
     *
     * @return whether the post is valid
     */
    boolean isValid();

    /**
     * Json representation of post
     * TODO: enum for various output formats
     * 
     * @return json representation of post
     */
    String asJson();
}
