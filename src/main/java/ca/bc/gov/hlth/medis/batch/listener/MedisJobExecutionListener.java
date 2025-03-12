package ca.bc.gov.hlth.medis.batch.listener;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ca.bc.gov.hlth.medis.service.EmailService;

@Component
public class MedisJobExecutionListener implements JobExecutionListener  {
	private static final Logger logger = LoggerFactory.getLogger(MedisJobExecutionListener.class);
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	private static final String EMAIL_FROM = "medis-data-loader@gov.bc.ca";
	
	@Autowired
	private EmailService emailService;
	
	@Value("${mail.enabled}")
	private Boolean mailEnabled;
	
	@Value("${mail.recipients}")
	private String mailRecipients;
	
	@Value("${sftp.import-directory}")
	private String importDirectory;
	
	@AfterJob
	@SuppressWarnings("unchecked")
	public void afterJob(JobExecution jobExecution) {

		ExecutionContext executionContext = jobExecution.getExecutionContext();
		
		// Cleanup all import files
		try {
			FileUtils.cleanDirectory(new File(importDirectory));
		} catch (IOException e) {
			logger.warn("Could not clean import directory");
		}
		
		if (!mailEnabled) {
			return;
		}

		if (jobExecution.getStatus() == BatchStatus.FAILED) {			
			StringBuilder sb = new StringBuilder();

			sb.append("MEDIS data load run at " + jobExecution.getStartTime().format(formatter) + " failed");
			sb.append("\n\nAutomatically generated message in case of failure.");
			emailService.sendNotificationEmail(EMAIL_FROM, mailRecipients, "MEDIS data load run FAILED!", sb.toString());
	    }
		
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			List<String> importFiles = (List<String>) executionContext.get("importFiles");
			if (importFiles != null && !importFiles.isEmpty()) {
				StringBuilder sb = new StringBuilder();

				sb.append("MEDIS data load run at " + jobExecution.getStartTime().format(formatter) + " succeeded");
				sb.append("\n\nAutomatically generated message in case of success.");
				emailService.sendNotificationEmail(EMAIL_FROM, mailRecipients, "MEDIS data load run SUCCEEDED!", sb.toString());	
			}
		}
	}

}
