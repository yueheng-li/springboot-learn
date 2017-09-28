package cn.learn.spring.batch.mapper;

import java.util.List;

import cn.learn.spring.batch.domain.Person;

public interface PeopleMapper {

	int insertPerson(Person record);
	List<Person> selectAll();
}
