package cn.learn.spring.batch.job;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import cn.learn.spring.batch.domain.Person;
import cn.learn.spring.batch.listener.JobCompletionNotificationListener;
import cn.learn.spring.batch.processor.PersonItemProcessor;
import cn.learn.spring.batch.processor.validator.PersonValidator;
import cn.learn.spring.batch.writer.PersonWriter;

@Configuration
@EnableBatchProcessing
public class CsvToDbJobConfiguation {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;
	


	// tag::jobstep[]
	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener)
				.flow(step1()).end().build();
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Person, Person>chunk(10).reader(reader()).processor(processor())
				.writer(writer()).build();
	}

	// end::read process writer
	/**
	 * 读操作（读取CSV文件内容，并作为上下文内容传递）
	 * 
	 * @return
	 */
	@Bean
	public FlatFileItemReader<Person> reader() {
		FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
		// load csv file
		reader.setResource(new ClassPathResource("sample-data.csv"));

		// 读取使用，分割的csv文件内容，并保存到Person中
		reader.setLineMapper(new DefaultLineMapper<Person>() {
			{
				// 截取的内容放到firstName,lastName
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "firstName", "lastName" });
					}
				});

				// 保存到Person
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
					{
						setTargetType(Person.class);
					}
				});
			}
		});

		return reader;
	}

	/**
	 * 调用自定义的Processor，把String的内容Upper
	 * 
	 * @return
	 */
	@Bean
	public PersonItemProcessor processor() {
		PersonItemProcessor processor = new PersonItemProcessor(); // 1
		processor.setValidator(personValidator()); // 2
		return processor;
	}

	/**
	 * 自定义校验类
	 * @return
	 */
	@Bean
	public Validator<Person> personValidator() {
		return new PersonValidator<>();
	}

	/**
	 * 写操作把读取的CSV内容写到DB中
	 * 
	 * @return
	 */
//	@Bean
//	public JdbcBatchItemWriter<Person> writer() {
//		JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
//		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
//		writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
//		writer.setDataSource(dataSource);
//		return writer;
//	}
	@Bean
	public PersonWriter writer() {
		return new PersonWriter();
	}


	// start::read process writer[]
}
