package cn.java.learn.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("cn.java.learn.redis.dao")
@ComponentScan(basePackages = "cn.java.learn.redis")
public class LearnRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnRedisApplication.class, args);
	}
}
