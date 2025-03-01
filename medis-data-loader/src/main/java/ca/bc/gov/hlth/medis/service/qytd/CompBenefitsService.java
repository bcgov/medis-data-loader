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

import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdCompAddPos;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdCompBenefits;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdCompHrs;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdCompHrsSubtotals;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdCompHrsTotals;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdCompSal;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdCompSalSubtotals;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdCompSalTotals;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdCompAddPosRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdCompBenefitsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdCompHrsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdCompHrsSubtotalsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdCompHrsTotalsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdCompSalRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdCompSalSubtotalsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdCompSalTotalsRepository;

@Service
public class CompBenefitsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CompBenefitsService.class);

	@Autowired
	private LtcYtdCompAddPosRepository compAddPosRepository;
	
	@Autowired
	private LtcYtdCompBenefitsRepository compBenefitsRepository;
	
	@Autowired
	private LtcYtdCompHrsRepository compHrsRepository;
	
	@Autowired
	private LtcYtdCompHrsSubtotalsRepository compHrsSubtotalsRepository;
	
	@Autowired
	private LtcYtdCompHrsTotalsRepository compHrsTotalsRepository;
	
	@Autowired
	private LtcYtdCompSalRepository compSalRepository;
	
	@Autowired
	private LtcYtdCompSalSubtotalsRepository compSalSubtotalsRepository;
	
	@Autowired
	private LtcYtdCompSalTotalsRepository compSalTotalsRepository;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void deleteAll() {
		compAddPosRepository.deleteAll();
		compBenefitsRepository.deleteAll();
		compHrsRepository.deleteAll();
		compHrsSubtotalsRepository.deleteAll();
		compHrsTotalsRepository.deleteAll();
		compSalRepository.deleteAll();
		compSalSubtotalsRepository.deleteAll();
		compSalTotalsRepository.deleteAll();
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processCompAddPos(FileReader reader) {
		List<LtcYtdCompAddPos> beans = new CsvToBeanBuilder<LtcYtdCompAddPos>(reader).withType(LtcYtdCompAddPos.class).build().parse();
		beans.forEach(bean -> compAddPosRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_COMP_ADD_POS", beans.size());
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processCompBenefits(FileReader reader) {
		List<LtcYtdCompBenefits> beans = new CsvToBeanBuilder<LtcYtdCompBenefits>(reader).withType(LtcYtdCompBenefits.class).build().parse();
		beans.forEach(bean -> compBenefitsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_COMP_BENEFITS", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processCompHrs(FileReader reader) {
		List<LtcYtdCompHrs> beans = new CsvToBeanBuilder<LtcYtdCompHrs>(reader).withType(LtcYtdCompHrs.class).build().parse();
		beans.forEach(bean -> compHrsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_COMP_HRS", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processCompHrsSubtotals(FileReader reader) {
		List<LtcYtdCompHrsSubtotals> beans = new CsvToBeanBuilder<LtcYtdCompHrsSubtotals>(reader).withType(LtcYtdCompHrsSubtotals.class).build().parse();
		beans.forEach(bean -> compHrsSubtotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_COMP_HRS_SUBTOTALS", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processCompHrsTotals(FileReader reader) {
		List<LtcYtdCompHrsTotals> beans = new CsvToBeanBuilder<LtcYtdCompHrsTotals>(reader).withType(LtcYtdCompHrsTotals.class).build().parse();
		beans.forEach(bean -> compHrsTotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_COMP_HRS_TOTALS", beans.size());
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processCompSal(FileReader reader) {
		List<LtcYtdCompSal> beans = new CsvToBeanBuilder<LtcYtdCompSal>(reader).withType(LtcYtdCompSal.class).build().parse();
		beans.forEach(bean -> compSalRepository.save(bean));
		logger.info("Insert {} records into LTCFIN_YTD_COMP_SAL", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processCompSalSubtotals(FileReader reader) {
		List<LtcYtdCompSalSubtotals> beans = new CsvToBeanBuilder<LtcYtdCompSalSubtotals>(reader).withType(LtcYtdCompSalSubtotals.class).build().parse();
		beans.forEach(bean -> compSalSubtotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_COMP_SAL_SUBTOTALS", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processCompSalTotals(FileReader reader) {
		List<LtcYtdCompSalTotals> beans = new CsvToBeanBuilder<LtcYtdCompSalTotals>(reader).withType(LtcYtdCompSalTotals.class).build().parse();
		beans.forEach(bean -> compSalTotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_YTD_COMP_SAL_TOTALS", beans.size());
	}

}
