package cn.learn.actuator.learnspringbootautuator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LearnSpringBootAutuatorApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testHomeIsSecure() throws Exception {
		ResponseEntity<Map> entity  = this.restTemplate.getForEntity("/", Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
		
		Map<String, Object> body = entity.getBody();
		assertThat(body.get("error")).isEqualTo("Unauthorized");
		assertThat(entity.getHeaders()).doesNotContainKey("Set-Cookie");
	}
	
	@Test
	public void testHome() throws Exception {
		ResponseEntity<Map> entity  = this.restTemplate.withBasicAuth("user", "password").getForEntity("/", Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		Map<String, Object> body = entity.getBody();
		assertThat(body.get("message")).isEqualTo("Hello Li, chunhui");
	}

}
