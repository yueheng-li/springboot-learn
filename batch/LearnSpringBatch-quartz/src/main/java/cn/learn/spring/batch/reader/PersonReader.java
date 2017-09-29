package cn.learn.spring.batch.reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.learn.spring.batch.domain.Person;
import cn.learn.spring.batch.mapper.PeopleMapper;

public class PersonReader implements ItemReader<Person> {

	private static final Logger log = LoggerFactory.getLogger(PersonReader.class);
	
	@Autowired
	public PeopleMapper peopleMapper;

//	@Override
//	protected void doReadPage() {
//		// TODO Auto-generated method stub
//		List<Person> list = new ArrayList<Person>();
//		super.setPageSize(10);
//		
//		Map<String, Object> parameterValues = new HashMap<>();
//		parameterValues.put("toId", toId);
//		parameterValues.put("fromId", fromId);
//		list = peopleMapper.selectByPersonId(parameterValues);
//		if (results == null) {
//			results = new CopyOnWriteArrayList<Person>();
//		} else {
//			results.clear();
//		}
//		log.info("reader ...................." + list);
//		results.addAll(list);
//	}


	@Override
	public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		List<Person> list = peopleMapper.selectAll();
		return null;
	}


}
