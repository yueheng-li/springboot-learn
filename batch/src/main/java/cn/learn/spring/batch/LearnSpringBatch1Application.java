package cn.learn.spring.batch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//mapper 接口类扫描包配置
@MapperScan("cn.learn.spring.batch.mapper")
@ComponentScan(basePackages = "cn.learn.spring.batch")
public class LearnSpringBatch1Application {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBatch1Application.class, args);
	}
}
