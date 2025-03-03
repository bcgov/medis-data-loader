package ca.bc.gov.hlth.medis.batch.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ca.bc.gov.hlth.medis.service.EmailService;

@Component
public class MedisJobExecutionListener implements org.springframework.batch.core.JobExecutionListener  {
	private static final Logger logger = LoggerFactory.getLogger(MedisJobExecutionListener.class);
	
	@Autowired
	private EmailService emailService;
	
	@Value("${mail.enabled}")
	private Boolean mailEnabled;
	
	@AfterJob
	@SuppressWarnings("unchecked")
	public void afterJob(JobExecution jobExecution) {
		
		if (!mailEnabled) {
			return;
		}

		if (jobExecution.getStatus() == BatchStatus.FAILED) {
			emailService.sendNotificationEmail("test@medis-data-loader.com", "wes.kubo@cgi.com", "FAILED", "FAILED");				
	    }
		
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			ExecutionContext executionContext = jobExecution.getExecutionContext();
			List<String> importFiles = (List<String>) executionContext.get("importFiles");
			if (importFiles != null && !importFiles.isEmpty()) {
				emailService.sendNotificationEmail("test@medis-data-loader.com", "wes.kubo@cgi.com", "SUCCESS", "SUCCESS");	
			}
		}
	}
	
}
