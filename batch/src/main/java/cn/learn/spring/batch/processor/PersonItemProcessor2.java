package cn.learn.spring.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import cn.learn.spring.batch.domain.Person1;

/**
 * 把Reader读取的Person内容Upper
 * @author chunhui.li
 *
 */
public class PersonItemProcessor2 implements ItemProcessor<Person1, Person1> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor2.class);

    @Override
    public Person1 process(final Person1 person) throws Exception {
//        final String firstName = person.getFirstName().toUpperCase();
//        final String lastName = person.getLastName().toUpperCase();

//        final Person transformedPerson = new Person(firstName, lastName);

//        log.info("Converting (" + person + ") into (" + transformedPerson + ")");
    	log.info("process..." + person.toString());

        return person;
    }

}