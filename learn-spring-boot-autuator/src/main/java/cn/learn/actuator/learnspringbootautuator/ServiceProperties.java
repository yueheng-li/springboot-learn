package cn.learn.actuator.learnspringbootautuator;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <ul>
 * 读取配置信息中service开头的name 并加载
 * <li>例如:service.name=Hello</li>
 * </ul>
 * @author chunhui.li
 *
 */
@ConfigurationProperties(prefix = "service", ignoreInvalidFields = false)
public class ServiceProperties {

	/**
	 * Name of the service
	 */
	private String name = "World";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
