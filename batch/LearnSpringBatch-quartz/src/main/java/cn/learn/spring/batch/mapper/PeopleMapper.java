package cn.learn.spring.batch.mapper;

import java.util.List;
import java.util.Map;

import cn.learn.spring.batch.domain.Person;

public interface PeopleMapper {

	int insertPerson(Person record);
	List<Person> selectAll();
	
	public List<Person>  selectByPersonId(Map<String,Object> map) ;  
}
