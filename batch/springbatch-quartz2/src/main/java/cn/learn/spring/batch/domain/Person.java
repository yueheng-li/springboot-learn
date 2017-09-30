package cn.learn.spring.batch.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String title = "";
	private String firstName = "";
	private String last_name = "";
	private int age = 0;
	private Address address = new Address();
	private List<Child> children = new ArrayList<Child>();

	public Person() {
		children.add(new Child());
		children.add(new Child());
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the children
	 */
	public List<Child> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Child> children) {
		this.children = children;
	}

	/**
	 * Intentionally non-standard method name for testing purposes
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * Intentionally non-standard method name for testing purposes
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the person_title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the person title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Person [address=" + address + ", age=" + age + ", children=" + children + ", firstName=" + firstName
				+ ", last_name=" + last_name + ", title=" + title + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


}
