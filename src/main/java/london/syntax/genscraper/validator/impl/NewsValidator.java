
package london.syntax.genscraper.validator.impl;

import london.syntax.genscraper.model.entity.News;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Peter Turner <syntax.valid@gmail.com>
 */
public class NewsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return News.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
    }
    
    
    
}
