/*
 * Copyright 2008-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.learn.spring.batch.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.util.Assert;

/**
 * @author Dan Garrette
 * @since 2.0
 */
public class ErrorLogTasklet implements Tasklet, StepExecutionListener {
    private static Log log = LogFactory.getLog(ErrorLogTasklet.class);
	private String jobName;
	private StepExecution stepExecution;
	private String stepName;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		Assert.notNull(this.stepName, "Step name not set.  Either this class was not registered as a listener "
				+ "or the key 'stepName' was not found in the Job's ExecutionContext.");
//		this.jdbcTemplate.update("insert into ERROR_LOG values (?, ?, '"+getSkipCount()+" records were skipped!')",
//				jobName, stepName);
		log.info("insert into ERROR_LOG values (?, ?, '"+getSkipCount()+" records were skipped!')" + ", " + jobName + "," + stepName);
		return RepeatStatus.FINISHED;
	}

	/**
	 * @return
	 */
	private int getSkipCount() {
		if (stepExecution == null || stepName == null) {
			return 0;
		}
		for (StepExecution execution : stepExecution.getJobExecution().getStepExecutions()) {
			if (execution.getStepName().equals(stepName)) {
				return execution.getSkipCount();
			}
		}
		return 0;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		this.jobName = stepExecution.getJobExecution().getJobInstance().getJobName().trim();
		this.stepName = (String) stepExecution.getJobExecution().getExecutionContext().get("stepName");
		this.stepExecution = stepExecution;
		stepExecution.getJobExecution().getExecutionContext().remove("stepName");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		return null;
	}
}
