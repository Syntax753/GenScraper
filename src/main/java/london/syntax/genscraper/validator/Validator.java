package london.syntax.genscraper.validator;

import london.syntax.genscraper.model.AbstractPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 * 
 * TODO: JSR-303 and Spring Hibernate Validator or straight Spring may be a better option here
 * Though will need to investigate how to register it in a non MVC scenario
 * 
 * @see http://www.journaldev.com/2668/spring-validation-example-mvc-validator
 * 
 */
public interface Validator {
    
    boolean isValid();

}
