package cn.learn.spring.batch.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class RunScheduler {
//	@Autowired
//	private JobLauncher jobLauncher;
//	@Autowired
//	private Job job;
//
//	@Scheduled(cron = "* */30 * * * ?") // 每20秒执行一次
//	public void run() {
//		try {
//			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
//					.toJobParameters();
//
//			JobExecution execution = jobLauncher.run(job, jobParameters);
//
//			System.out.println("Exit status : " + execution.getStatus());
//		} catch (JobInstanceAlreadyCompleteException e) {
//			e.printStackTrace();
//		} catch (JobExecutionAlreadyRunningException e) {
//			e.printStackTrace();
//		} catch (JobParametersInvalidException e) {
//			e.printStackTrace();
//		} catch (JobRestartException e) {
//			e.printStackTrace();
//		}
//	}
}
