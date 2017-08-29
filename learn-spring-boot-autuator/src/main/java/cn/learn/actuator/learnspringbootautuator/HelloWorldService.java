package cn.learn.actuator.learnspringbootautuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class HelloWorldService {
	
	@Autowired
	private ServiceProperties serviceProperties;

	
	public String getMessage() {
		return "Hello " + serviceProperties.getName();
	}
}
