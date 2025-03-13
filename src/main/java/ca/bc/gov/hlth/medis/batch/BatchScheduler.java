package ca.bc.gov.hlth.medis.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class BatchScheduler {
	private static final Logger logger = LoggerFactory.getLogger(BatchScheduler.class);
	
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job importJob;
	
	@Value("${sftp.remote-directory}")
	private String remoteDirectory;
	
	@Value("${sftp.flag-file}")
	private String flagFile;

	@Scheduled(cron = "${batch.cron}")
	public void schedule() throws Exception {
		JobParameters params = new JobParametersBuilder()
				.addString("JobID", String.valueOf(System.currentTimeMillis()))
				.addString("remoteDirectory", remoteDirectory)
				.addString("flagFile", flagFile)
				.toJobParameters();
		JobExecution execution = jobLauncher.run(importJob, params);
		logger.info("Job finished with status " + execution.getStatus());
	}
	
}
