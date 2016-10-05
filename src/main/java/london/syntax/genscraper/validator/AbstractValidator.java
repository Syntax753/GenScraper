package london.syntax.genscraper.validator;

import london.syntax.genscraper.exception.ScraperValidationException;
import london.syntax.genscraper.model.AbstractPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public abstract class AbstractValidator implements Validator {

    protected static Logger logger = LoggerFactory.getLogger(AbstractValidator.class);

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
            this.validateInternal();
            isValid = true;
        } catch (ScraperValidationException e) {
            logger.warn("Invalid post [" + this + "]", e);
        }

        return isValid;
    }

}
