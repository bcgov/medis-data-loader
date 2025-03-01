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

import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdDirectCareCost;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdDirectCareCostSubtotals;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdDirectCareHrs;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdDirectCareHrsSubTotals;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcYtdDirectCareVacancy;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdDirectCareCostRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdDirectCareCostSubtotalsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdDirectCareHrsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdDirectCareHrsSubTotalsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcYtdDirectCareVacancyRepository;

@Service
public class DirectCareService {
	private static final Logger log = LoggerFactory.getLogger(DirectCareService.class);
	
	@Autowired
	private LtcYtdDirectCareCostRepository directCareCostRepository;
	
	@Autowired
	private LtcYtdDirectCareCostSubtotalsRepository directCareCostSubtotalsRepository;
	
	@Autowired
	private LtcYtdDirectCareHrsRepository directCareHrsRepository;
	
	@Autowired
	private LtcYtdDirectCareHrsSubTotalsRepository directCareHrsSubTotalsRepository;
	
	@Autowired
	private LtcYtdDirectCareVacancyRepository directCareVacancyRepository;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void deleteAll() {
		directCareCostRepository.deleteAll();
		directCareCostSubtotalsRepository.deleteAll();
		directCareHrsRepository.deleteAll();
		directCareHrsSubTotalsRepository.deleteAll();
		directCareVacancyRepository.deleteAll();
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processDirectCareCost(FileReader reader) {
		List<LtcYtdDirectCareCost> beans = new CsvToBeanBuilder<LtcYtdDirectCareCost>(reader).withType(LtcYtdDirectCareCost.class).build().parse();
		beans.forEach(bean -> directCareCostRepository.save(bean));
		log.info("Inserted {} records into LTCFIN_YTD_DIRECT_CARE_COST", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processDirectCareCostSubtotals(FileReader reader) {
		List<LtcYtdDirectCareCostSubtotals> beans = new CsvToBeanBuilder<LtcYtdDirectCareCostSubtotals>(reader).withType(LtcYtdDirectCareCostSubtotals.class).build().parse();
		beans.forEach(bean -> directCareCostSubtotalsRepository.save(bean));
		log.info("Inserted {} records into LTCFIN_YTD_DIR_CARE_COST_SUBS", beans.size());
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processDirectCareHrs(FileReader reader) {
		List<LtcYtdDirectCareHrs> beans = new CsvToBeanBuilder<LtcYtdDirectCareHrs>(reader).withType(LtcYtdDirectCareHrs.class).build().parse();
		beans.forEach(bean -> directCareHrsRepository.save(bean));
		log.info("Inserted {} records into LTCFIN_YTD_DIRECT_CARE_HRS", beans.size());
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processDirectCareHrsSubTotals(FileReader reader) {
		List<LtcYtdDirectCareHrsSubTotals> beans = new CsvToBeanBuilder<LtcYtdDirectCareHrsSubTotals>(reader).withType(LtcYtdDirectCareHrsSubTotals.class).build().parse();
		beans.forEach(bean -> directCareHrsSubTotalsRepository.save(bean));
		log.info("Inserted {} records into LTCFIN_YTD_DIR_CARE_HRS_SUBS", beans.size());
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processDirectCareVacancy(FileReader reader) {
		List<LtcYtdDirectCareVacancy> beans = new CsvToBeanBuilder<LtcYtdDirectCareVacancy>(reader).withType(LtcYtdDirectCareVacancy.class).build().parse();
		beans.forEach(bean -> directCareVacancyRepository.save(bean));
		log.info("Inserted {} records into LTCFIN_YTD_DIR_CARE_VACANCY", beans.size());
	}

}
