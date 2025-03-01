package ca.bc.gov.hlth.medis.service.qytd;

import java.io.FileReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opencsv.bean.CsvToBeanBuilder;

import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdDep;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdDepSubTotals;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdExp;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdExpSubTotals;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdRev;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdRevSubTotals;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdSumTotals;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdDepRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdDepSubTotalsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdExpRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdExpSubtotalsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdRevRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdRevSubTotalsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdSumTotalsRepository;

@Service
public class RevenueExpenseService {
	
	private static final Logger logger = LoggerFactory.getLogger(RevenueExpenseService.class);

	@Autowired
	private LtcYtdDepRepository depRepository;
	
	@Autowired
	private LtcYtdDepSubTotalsRepository depSubTotalsRepository;
	
	@Autowired
	private LtcYtdExpRepository expRepository;
	
	@Autowired
	private LtcYtdExpSubtotalsRepository expSubtotalsRepository;
	
	@Autowired
	private LtcYtdRevRepository revRepository;
	
	@Autowired
	private LtcYtdRevSubTotalsRepository revSubTotalsRepository;
	
	@Autowired
	private LtcYtdSumTotalsRepository sumTotalsRepository;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void deleteAll() {
		depRepository.deleteAll();
		depSubTotalsRepository.deleteAll();
		expRepository.deleteAll();
		expSubtotalsRepository.deleteAll();
		revRepository.deleteAll();
		revSubTotalsRepository.deleteAll();
		sumTotalsRepository.deleteAll();
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processDep(FileReader reader) {
		List<LtcYtdDep> beans = new CsvToBeanBuilder<LtcYtdDep>(reader).withType(LtcYtdDep.class).build().parse();
		beans.forEach(bean -> depRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_DEP", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processDepSubTotals(FileReader reader) {
		List<LtcYtdDepSubTotals> beans = new CsvToBeanBuilder<LtcYtdDepSubTotals>(reader).withType(LtcYtdDepSubTotals.class).build().parse();
		beans.forEach(bean -> depSubTotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_DEP_SUBTOTALS", beans.size());
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processExp(FileReader reader) {
		List<LtcYtdExp> beans = new CsvToBeanBuilder<LtcYtdExp>(reader).withType(LtcYtdExp.class).build().parse();
		beans.forEach(bean -> expRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_EXP", beans.size());
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processExpSubtotals(FileReader reader) {
		List<LtcYtdExpSubTotals> beans = new CsvToBeanBuilder<LtcYtdExpSubTotals>(reader).withType(LtcYtdExpSubTotals.class).build().parse();
		beans.forEach(bean -> expSubtotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_EXP_SUBTOTALS", beans.size());
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processRev(FileReader reader) {
		List<LtcYtdRev> beans = new CsvToBeanBuilder<LtcYtdRev>(reader).withType(LtcYtdRev.class).build().parse();
		beans.forEach(bean -> revRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_REV", beans.size());
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processRevSubTotals(FileReader reader) {
		List<LtcYtdRevSubTotals> beans = new CsvToBeanBuilder<LtcYtdRevSubTotals>(reader).withType(LtcYtdRevSubTotals.class).build().parse();
		beans.forEach(bean -> revSubTotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_REV_SUBTOTALS", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processSumTotals(FileReader reader) {
		List<LtcYtdSumTotals> beans = new CsvToBeanBuilder<LtcYtdSumTotals>(reader).withType(LtcYtdSumTotals.class).build().parse();
		beans.forEach(bean -> sumTotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_SUM_TOTALS", beans.size());
	}

}
