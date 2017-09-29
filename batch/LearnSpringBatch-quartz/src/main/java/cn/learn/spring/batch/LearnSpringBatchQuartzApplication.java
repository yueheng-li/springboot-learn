package cn.learn.spring.batch;

import java.util.Set;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//mapper 接口类扫描包配置
@MapperScan("cn.learn.spring.batch.mapper")
@ComponentScan(basePackages = "cn.learn.spring.batch")
public class LearnSpringBatchQuartzApplication {

	public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(LearnSpringBatchQuartzApplication.class);
        Set<Object> set = springApp.getSources();
        set.add("classpath:job-quartz.xml");
        springApp.setSources(set);
        springApp.run(args);
	}
}
