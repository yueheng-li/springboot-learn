package cn.learn.spring.batch.processor.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.learn.spring.batch.domain.Person;

/**
 * @author Michael Minella
 */
public class PersonValidator implements Validator {

    private static final Logger log = LoggerFactory.getLogger(PersonValidator.class);
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	Person trade = (Person) target;
    	log.info("validate person .... " + trade);

    }
}
