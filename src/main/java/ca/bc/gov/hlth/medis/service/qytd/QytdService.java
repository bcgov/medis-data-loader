package ca.bc.gov.hlth.medis.service.qytd;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opencsv.bean.CsvToBeanBuilder;

import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdSubmission;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdSubmissionRepository;
import ca.bc.gov.hlth.medis.util.QytdFile;

@Service
public class QytdService {

	private static final Logger logger = LoggerFactory.getLogger(QytdService.class);

	@Autowired
	private LtcYtdSubmissionRepository submissionRepository;

	@Autowired
	private BedInventoryService bedInventoryService;
	
	@Autowired
	private CompBenefitsService compBenefitsService;
	
	@Autowired
	private DirectCareService directCareService;
	
	@Autowired
	private RevenueExpenseService revenueExpenseService;

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void load(List<File> files) throws IOException {
		// Skip processing if no files to load
		if (files == null || files.isEmpty()) {
			return;
		}

		// Delete old data
		submissionRepository.deleteAll();
		compBenefitsService.deleteAll();
		directCareService.deleteAll();
		revenueExpenseService.deleteAll();
		bedInventoryService.deleteAll();
		
		// Load all files
		for (File file: files) {
			load(file);	
		}
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void load(File file) throws IOException {
		// Strip the timestamp and guid for file matching
		String fileNameWithoutGuid = StringUtils.substringBeforeLast(file.getName(), "_");
		String fileName = StringUtils.substringBeforeLast(fileNameWithoutGuid, "_");

		logger.info("Importing file " + file.getName());

		try (FileReader reader = new FileReader(file)) {
			
			// Submission
			if (fileName.equals(QytdFile.LTC_YTD_SUBMISSION.filename))
				processSubmission(reader);
			
			// Compensation & Benefits YTD
			if (fileName.equals(QytdFile.LTC_YTD_COMP_ADD_POS.filename))
				compBenefitsService.processCompAddPos(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_COMP_BENEFITS.filename))
				compBenefitsService.processCompBenefits(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_COMP_HRS.filename))
				compBenefitsService.processCompHrs(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_COMP_HRS_SUBTOTALS.filename))
				compBenefitsService.processCompHrsSubtotals(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_COMP_HRS_TOTALS.filename))
				compBenefitsService.processCompHrsTotals(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_COMP_SAL.filename))
				compBenefitsService.processCompSal(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_COMP_SAL_SUBTOTALS.filename))
				compBenefitsService.processCompSalSubtotals(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_COMP_SAL_TOTALS.filename))
				compBenefitsService.processCompSalTotals(reader);
			
			// Direct Care Hr & Cost YTD
			if (fileName.equals(QytdFile.LTC_YTD_DIRECT_CARE_COST.filename))
				directCareService.processDirectCareCost(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_DIRECT_CARE_COST_SUBS.filename))
				directCareService.processDirectCareCostSubtotals(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_DIRECT_CARE_HRS.filename))
				directCareService.processDirectCareHrs(reader);

			if (fileName.equals(QytdFile.LTC_YTD_DIRECT_CARE_HRS_SUBS.filename))
				directCareService.processDirectCareHrsSubTotals(reader);

			if (fileName.equals(QytdFile.LTC_YTD_DIRECT_CARE_VACANCY.filename))
				directCareService.processDirectCareVacancy(reader);
			
			// Summary of Rev. & Exp. YTD			
			if (fileName.equals(QytdFile.LTC_YTD_DEP.filename))
				revenueExpenseService.processDep(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_DEP_SUBTOTALS.filename))
				revenueExpenseService.processDepSubTotals(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_EXP.filename))
				revenueExpenseService.processExp(reader);

			if (fileName.equals(QytdFile.LTC_YTD_EXP_SUBTOTALS.filename))
				revenueExpenseService.processExpSubtotals(reader);

			if (fileName.equals(QytdFile.LTC_YTD_REV.filename))
				revenueExpenseService.processRev(reader);

			if (fileName.equals(QytdFile.LTC_YTD_REV_SUBTOTALS.filename))
				revenueExpenseService.processRevSubTotals(reader);
			
			if (fileName.equals(QytdFile.LTC_YTD_SUM_TOTALS.filename))
				revenueExpenseService.processSumTotals(reader);
			
			// Bed Inventory & Occupancy
			if (fileName.equals(QytdFile.LTC_BED_YTD_MAX_OCCUPANCY.filename))
				bedInventoryService.processMaxBedOccupany(reader);
			
			if (fileName.equals(QytdFile.LTC_BED_YTD_MAX_OCCY_TOTALS.filename))
				bedInventoryService.processMaxBedOccupanyTotals(reader);
			
			if (fileName.equals(QytdFile.LTC_BED_YTD_OCCUPANCY_RATE.filename))
				bedInventoryService.processBedOccupanyRate(reader);
			
			if (fileName.equals(QytdFile.LTC_BED_YTD_OCCUPANCY_RATE_TOT.filename))
				bedInventoryService.processBedOccupanyRateTotals(reader);
			
			if (fileName.equals(QytdFile.LTC_BED_YTD_OCCUPIED_DAYS.filename))
				bedInventoryService.processBedOccupiedDays(reader);
			
			if (fileName.equals(QytdFile.LTC_BED_YTD_OCCUPIED_DAYS_TOT.filename))
				bedInventoryService.processBedOccupiedDaysTotals(reader);

		} catch (Exception e) {
			logger.error("Could not import file " + fileName, e);
			throw e;
		} finally {
			file.delete();
		}
	}

	private void processSubmission(FileReader reader) throws IOException {
		List<LtcYtdSubmission> beans = new CsvToBeanBuilder<LtcYtdSubmission>(reader).withType(LtcYtdSubmission.class).build().parse();
		beans.forEach(bean -> submissionRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_SUBMISSION", beans.size());
	}

}
