package ca.bc.gov.hlth.medis.batch.tasklet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import ca.bc.gov.hlth.medis.service.PGPService;
import ca.bc.gov.hlth.medis.service.SFTPService;
import ca.bc.gov.hlth.medis.service.ZipService;

/**
 * Tasklet to get the files from the SFTP server and store as a local temp file.
 */
public class SFTPGetTasklet implements Tasklet, InitializingBean  {
	
	private static final Logger logger = LoggerFactory.getLogger(SFTPGetTasklet.class);
	
	private static final String DOMAIN_VALUES = "_domain_values_";
	
	private static final String SFTP_FILE_EXTENSION = ".gz.gpg";
	
	@Autowired
	private PGPService pgpService;
	
	@Autowired
	private SFTPService sftpService;
	
	@Autowired
	private ZipService zipService;	
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();

		String remoteDirectory = jobParameters.getString("remoteDirectory");
		String flagFileName = jobParameters.getString("flagFile");
		
		// Load the flag file
		File flagFile = sftpService.getFile(remoteDirectory + flagFileName);
		if (flagFile == null) {
			logger.warn("No flag file found");
			return RepeatStatus.FINISHED;
		}
		
		// List of local files for import
		List<File> importFiles = new ArrayList<File>();
		
		// List of SFTP files for deletion
		List<String> sftpFiles = new ArrayList<String>();
		sftpFiles.add(remoteDirectory + flagFileName);
		
		try (BufferedReader reader = new BufferedReader(new FileReader(flagFile))) {
			String line;
			while ((line = reader.readLine()) != null) {
				
				Boolean domainFile = line.contains(DOMAIN_VALUES); 
				
				String importFileName = remoteDirectory + line;
				if (!domainFile) {
					// Include the extension for all files but *_domain_values
					importFileName += SFTP_FILE_EXTENSION;	
				}
				
				logger.info("Found import file: {}", importFileName);
				
				sftpFiles.add(importFileName);
				
				// Get file
				File importFile = sftpService.getFile(importFileName);
				logger.debug("got file {}", importFile.getAbsolutePath());
				
				if (!domainFile) {					
					// Decrypt
					File decryptedFile = pgpService.decrypt(importFile);				
					logger.debug("decrypted file {} ", decryptedFile.getAbsolutePath());
					
					// Unzip
					File unzippedFile = zipService.unzip(decryptedFile);
					logger.debug("unzipped file {}", unzippedFile.getAbsolutePath());
					
					importFiles.add(unzippedFile);
				}
			}
		} catch (Exception e) {
			logger.error("Could not transfer files", e);
			throw e;
		} finally {
			flagFile.delete();
		}

		ExecutionContext executionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();

		executionContext.put("importFiles", importFiles);
		executionContext.put("sftpFiles", sftpFiles);

		return RepeatStatus.FINISHED;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}

}
