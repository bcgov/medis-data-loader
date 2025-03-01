package ca.bc.gov.hlth.medis.batch.tasklet;

import static ca.bc.gov.hlth.medis.util.Constants.SFTP_WAIT;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import ca.bc.gov.hlth.medis.service.SFTPService;

/**
 * Tasklet to delete files from SFTP server once the files have been processed.
 */
public class DeleteFilesTasklet implements Tasklet {

	private static final Logger logger = LoggerFactory.getLogger(DeleteFilesTasklet.class);
	
	@Autowired
	private SFTPService sftpService;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
		System.out.println("Deleting sftp files");

		ExecutionContext executionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();

		@SuppressWarnings("unchecked")
		List<String> sftpFiles = (List<String>) executionContext.get("sftpFiles");
		if (sftpFiles != null) {
			logger.debug("Found {} files to delete", sftpFiles.size());
			sftpFiles.forEach(sftpFile -> {
				logger.debug("Deleting file {}", sftpFile);
				sftpService.removeFile(sftpFile);
				try {
					// Wait between SFTP requests to avoid failures
					Thread.sleep(SFTP_WAIT);
				} catch (InterruptedException e) {
					logger.warn(e.getMessage());
				}
			});
		}

		return RepeatStatus.FINISHED;
	}

}
