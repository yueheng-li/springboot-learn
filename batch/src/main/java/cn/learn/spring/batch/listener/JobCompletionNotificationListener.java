package cn.learn.spring.batch.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.learn.spring.batch.domain.Person;
import cn.learn.spring.batch.mapper.PeopleMapper;

/**
 * 作成后的监听作成
 * @author chunhui.li
 *
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

//	@Autowired
//	private final JdbcTemplate jdbcTemplate;
//
//	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
    long startTime;
    long endTime;
	
	@Autowired
	public PeopleMapper peopleMapper;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("任务处理开始...");
    }

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

//			List<Person> results = jdbcTemplate.query("SELECT first_name, last_name FROM people", new RowMapper<Person>() {
//				@Override
//				public Person mapRow(ResultSet rs, int row) throws SQLException {
//					return new Person(rs.getString(1), rs.getString(2));
//				}
//			});
			List<Person> results = peopleMapper.selectAll();

			for (Person person : results) {
				log.info("Found <" + person + "> in the database.");
			}

		}
        endTime = System.currentTimeMillis();
        System.out.println("任务处理结束...");
        System.out.println("耗时:" + (endTime - startTime) + " ms");
	}
}
