package cn.learn.spring.batch.listener;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * 作成后的监听作成
 * @author chunhui.li
 *
 */
@Component
public class MultiResultJobListener implements JobExecutionListener {

	private static final Logger log = LoggerFactory.getLogger(MultiResultJobListener.class);
	private DateTime startTime, stopTime;
    
    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = new DateTime();
        System.out.println("MultiResult Job starts at :"+startTime);
    }
     
 
    @Override
    public void afterJob(JobExecution jobExecution) {
        stopTime = new DateTime();
        System.out.println("MultiResult Job stops at :"+stopTime);
        System.out.println("Total time take in millis :"+getTimeInMillis(startTime , stopTime));
         
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            System.out.println("MultiResult job completed successfully");
            //Here you can perform some other business logic like cleanup
        }else if(jobExecution.getStatus() == BatchStatus.FAILED){
            System.out.println("MultiResult job failed with following exceptions ");
            List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
            for(Throwable th : exceptionList){
                System.err.println("exception :" +th.getLocalizedMessage());
            }
        }
    }
     
    private long getTimeInMillis(DateTime start, DateTime stop){
        return stop.getMillis() - start.getMillis();
    }
}
