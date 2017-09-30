package cn.learn.spring.batch.writer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import cn.learn.spring.batch.domain.Person;
import cn.learn.spring.batch.mapper.PeopleMapper;

public class PersonWriter  implements ItemWriter<Person> {
    private static Log log = LogFactory.getLog(PersonWriter.class);
	
	@Autowired
	public PeopleMapper peopleMapper;
 
    @Override
	public void write(List<? extends Person> data) {
        for (Person person : data) {
            log.info("Processing: " + person.toString());
//            peopleMapper.insertPerson(person);
		}
    }
}