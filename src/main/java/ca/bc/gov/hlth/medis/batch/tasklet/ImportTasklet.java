package ca.bc.gov.hlth.medis.batch.tasklet;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import ca.bc.gov.hlth.medis.service.qytd.QytdService;

public class ImportTasklet implements Tasklet {
	
	private static final Logger log = LoggerFactory.getLogger(ImportTasklet.class);
	
	@Autowired
	private QytdService qytdService;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		log.info("ImportTasklet::execute");
		
		ExecutionContext executionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
		
		@SuppressWarnings("unchecked")
		List<File> importFiles = (List<File>)executionContext.get("importFiles");
		qytdService.load(importFiles);

		return RepeatStatus.FINISHED;	
	}

}
