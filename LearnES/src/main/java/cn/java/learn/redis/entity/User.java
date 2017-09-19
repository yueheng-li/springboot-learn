package cn.java.learn.redis.entity;

import java.io.Serializable;

public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6519031451254675713L;
	private String username;
    private Integer age;
    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
    
    
}
