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

import ca.bc.gov.hlth.medis.batch.tasklet.DeleteFilesTasklet;
import ca.bc.gov.hlth.medis.batch.tasklet.ImportTasklet;
import ca.bc.gov.hlth.medis.batch.tasklet.SFTPGetTasklet;

@Configuration
//@EnableBatchProcessing
public class BatchConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(BatchConfiguration.class);
	
	@Bean
	public Job importJob(JobRepository jobRepository, JobExecutionListener listener, Step sftpGet, Step importData, Step deleteFiles) {
	    return new JobBuilder("importJob", jobRepository)
	      .incrementer(new RunIdIncrementer())
	      .listener(listener)
	      .start(sftpGet)
	      .next(importData)
	      .next(deleteFiles)
	      .build();
	}
	
	@Bean
	public Step sftpGet(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		logger.info("Building Step 1 - SFTP Get");
        return new StepBuilder("Step 1 - sftpGet", jobRepository)
                .tasklet(sftpGetTasklet(), transactionManager)
                .build();
	}
	
	@Bean
	public Step importData(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		logger.info("Building Step 2 - Import");
        return new StepBuilder("Step 2 - import", jobRepository)
                .tasklet(importTasklet(), transactionManager)
                .build();
	}

	@Bean
	public Step deleteFiles(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
	   	logger.info("Building Step 3 - Delete files");
        return new StepBuilder("Step 3 - deleteFiles", jobRepository)
                .tasklet(deleteFilesTasklet(), transactionManager)
                .build();
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
	public DeleteFilesTasklet deleteFilesTasklet() {
		return new DeleteFilesTasklet();
	}
	
}
