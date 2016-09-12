package london.syntax.newsgeek.exception;

/**
 * (unchecked) Exception for any validation issues
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public class ScraperValidationException extends IllegalArgumentException {

    public ScraperValidationException(String message) {
        super(message);
    }

    public ScraperValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScraperValidationException(Throwable cause) {
        super(cause);
    }

}
