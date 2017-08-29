package cn.learn.actuator.learnspringbootautuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
public class LearnSpringBootAutuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootAutuatorApplication.class, args);
	}
	
	/**
	 * 验证，设置用户名，密码和role
	 * @return
	 * @throws Exception
	 */
	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password("password").roles("USER", "ACTUATOR").build());
		return manager;
	}
	
	public HealthIndicator helloHealthIndicator() {
		return new HealthIndicator() {
			
			@Override
			public Health health() {
				return Health.up().withDetail("helloxxx", "worldxxx").build();
			}
		};
	}
}
