package cn.learn.spring.batch.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import cn.learn.spring.batch.domain.Person;

public class RetryReader implements ItemReader<Person> {

	private static final Logger log = LoggerFactory.getLogger(RetryReader.class);

	private int limit = 1;
	
	private int counter = 0;


	@Override
	public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		log.info("reader..." + counter);
		if (counter < limit) {
			counter++;
			Person p = new Person();
			p.setTitle("Title"+counter);
			p.setFirstName("f" + counter);
			p.setLast_name("l");
			
			return p;
		}
		return null;
	}

	/**
	 * @param limit number of items that will be generated
	 * (null returned on consecutive calls).
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCounter() {
		return counter;
	}

	public int getLimit() {
		return limit;
	}

	public void resetCounter()
	{
		this.counter = 0;
	}

}
