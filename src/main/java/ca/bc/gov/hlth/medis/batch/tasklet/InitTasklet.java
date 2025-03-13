package ca.bc.gov.hlth.medis.batch.tasklet;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;

/**
 * Tasklet to perform any initialization before the job runs.
 */
public class InitTasklet implements Tasklet {

	private static final Logger logger = LoggerFactory.getLogger(InitTasklet.class);

	@Value("${sftp.local-directory}")
	private String localDirectory;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {

		// Cleanup all import files in case of abnormal termination or failed cleanup
		try {
			FileUtils.cleanDirectory(new File(localDirectory));
		} catch (IOException e) {
			logger.warn("Could not clean import directory");
		}

		return RepeatStatus.FINISHED;
	}

}
