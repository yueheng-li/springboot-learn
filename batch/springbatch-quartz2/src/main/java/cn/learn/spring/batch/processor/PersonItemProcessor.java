package cn.learn.spring.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

import cn.learn.spring.batch.domain.Person;

/**
 * 把Reader读取的Person内容Upper
 * @author chunhui.li
 *
 */
public class PersonItemProcessor extends ValidatingItemProcessor<Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
    
    @Override
    public Person process(final Person person) throws ValidationException {
    	super.process(person);
//        final String firstName = person.getFirstName().toUpperCase();
//        final String lastName = person.getLastName().toUpperCase();
//
//        final Person transformedPerson = new Person(firstName, lastName);

        log.info("Converting (" + person + ") into (" + person + ")");

        return person;
    }

}