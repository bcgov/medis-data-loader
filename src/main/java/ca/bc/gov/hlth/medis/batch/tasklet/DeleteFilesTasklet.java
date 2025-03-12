package ca.bc.gov.hlth.medis.batch.tasklet;

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

	@SuppressWarnings("unchecked")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
		logger.info("running deleteFiles tasklet");

		ExecutionContext executionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
		
		// Remove SFTP files on successful execution
		List<String> sftpFiles = (List<String>) executionContext.get("sftpFiles");
		logger.debug("Found {} SFTP files to delete", sftpFiles.size());
		sftpFiles.forEach(sftpFile -> {
			logger.debug("Deleting SFTP file {}", sftpFile);
			sftpService.removeFile(sftpFile);
		});

		return RepeatStatus.FINISHED;
	}

}
