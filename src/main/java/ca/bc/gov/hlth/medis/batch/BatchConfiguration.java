package ca.bc.gov.hlth.medis.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import ca.bc.gov.hlth.medis.batch.tasklet.CleanupTasklet;
import ca.bc.gov.hlth.medis.batch.tasklet.ImportTasklet;
import ca.bc.gov.hlth.medis.batch.tasklet.InitTasklet;
import ca.bc.gov.hlth.medis.batch.tasklet.SFTPGetTasklet;

@Configuration
public class BatchConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(BatchConfiguration.class);
	
	@Bean
	public Job importJob(JobRepository jobRepository, JobExecutionListener listener, Step init, Step sftpGet, Step importData, Step cleanup) {
	    return new JobBuilder("importJob", jobRepository)
	      .incrementer(new RunIdIncrementer())
	      .listener(listener)
	      .start(init)
	      .next(sftpGet)
	      .next(importData)
	      .next(cleanup)
	      .build();
	}
	
	
	@Bean
	public Step init(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		logger.info("Building Step 1 - Init");
        return new StepBuilder("Step 1 - Init", jobRepository)
                .tasklet(initTasklet(), transactionManager)
                .build();
	}
	@Bean
	public Step sftpGet(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		logger.info("Building Step 2 - SFTP Get");
        return new StepBuilder("Step 2 - sftpGet", jobRepository)
                .tasklet(sftpGetTasklet(), transactionManager)
                .build();
	}
	
	@Bean
	public Step importData(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		logger.info("Building Step 3 - Import");
        return new StepBuilder("Step 3 - import", jobRepository)
                .tasklet(importTasklet(), transactionManager)
                .build();
	}

	@Bean
	public Step cleanup(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
	   	logger.info("Building Step 4 - Cleanup");
        return new StepBuilder("Step 4 - cleanup", jobRepository)
                .tasklet(cleanupTasklet(), transactionManager)
                .build();
	}
	
	@Bean
	public InitTasklet initTasklet() {
		return new InitTasklet();
	}
	
	@Bean
	public SFTPGetTasklet sftpGetTasklet() {
		return new SFTPGetTasklet();
	}

	@Bean
	public ImportTasklet importTasklet() {
		return new ImportTasklet();
	}

	@Bean
	public CleanupTasklet cleanupTasklet() {
		return new CleanupTasklet();
	}
	
}
