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

import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcBedYtdMaxOccupancy;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcBedYtdMaxOccupancyTotals;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcBedYtdOccupancyRate;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcBedYtdOccupancyRateTotals;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcBedYtdOccupiedDays;
import ca.bc.gov.hlth.medis.persistence.qytd.entity.LtcBedYtdOccupiedDaysTotals;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcBedYtdMaxOccupancyRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcBedYtdMaxOccupancyTotalsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcBedYtdOccupancyRateRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcBedYtdOccupancyRateTotalsRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcBedYtdOccupiedDaysRepository;
import ca.bc.gov.hlth.medis.persistence.qytd.repository.LtcBedYtdOccupiedDaysTotalsRepository;

@Service
public class BedInventoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(BedInventoryService.class);

	@Autowired
	private LtcBedYtdMaxOccupancyRepository bedYtdMaxOccupancyRepository;
	
	@Autowired
	private LtcBedYtdMaxOccupancyTotalsRepository bedYtdMaxOccupancyTotalsRepository;

	@Autowired
	private LtcBedYtdOccupancyRateRepository bedYtdOccupancyRateRepository;
	
	@Autowired
	private LtcBedYtdOccupancyRateTotalsRepository bedYtdOccupancyRateTotalsRepository;
	
	@Autowired
	private LtcBedYtdOccupiedDaysRepository bedYtdOccupiedDaysRepository;
	
	@Autowired
	private LtcBedYtdOccupiedDaysTotalsRepository bedYtdOccupiedDaysTotalsRepository;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void deleteAll() {
		bedYtdMaxOccupancyRepository.deleteAll();
		bedYtdMaxOccupancyTotalsRepository.deleteAll();
		bedYtdOccupancyRateRepository.deleteAll();
		bedYtdOccupancyRateTotalsRepository.deleteAll();
		bedYtdOccupiedDaysRepository.deleteAll();
		bedYtdOccupiedDaysTotalsRepository.deleteAll();
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processMaxBedOccupany(FileReader reader) {
		List<LtcBedYtdMaxOccupancy> beans = new CsvToBeanBuilder<LtcBedYtdMaxOccupancy>(reader).withType(LtcBedYtdMaxOccupancy.class).build().parse();
		beans.forEach(bean -> bedYtdMaxOccupancyRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_BED_YTD_MAX_OCCUPANCY", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processMaxBedOccupanyTotals(FileReader reader) {
		List<LtcBedYtdMaxOccupancyTotals> beans = new CsvToBeanBuilder<LtcBedYtdMaxOccupancyTotals>(reader).withType(LtcBedYtdMaxOccupancyTotals.class).build().parse();
		beans.forEach(bean -> bedYtdMaxOccupancyTotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_BED_YTD_MAX_OCCY_TOTALS", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processBedOccupanyRate(FileReader reader) {
		List<LtcBedYtdOccupancyRate> beans = new CsvToBeanBuilder<LtcBedYtdOccupancyRate>(reader).withType(LtcBedYtdOccupancyRate.class).build().parse();
		beans.forEach(bean -> bedYtdOccupancyRateRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_BED_YTD_OCCUPANCY_RATE", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processBedOccupanyRateTotals(FileReader reader) {
		List<LtcBedYtdOccupancyRateTotals> beans = new CsvToBeanBuilder<LtcBedYtdOccupancyRateTotals>(reader).withType(LtcBedYtdOccupancyRateTotals.class).build().parse();
		beans.forEach(bean -> bedYtdOccupancyRateTotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_BED_YTD_OCCY_RATE_TOT", beans.size());
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processBedOccupiedDays(FileReader reader) {
		List<LtcBedYtdOccupiedDays> beans = new CsvToBeanBuilder<LtcBedYtdOccupiedDays>(reader).withType(LtcBedYtdOccupiedDays.class).build().parse();
		beans.forEach(bean -> bedYtdOccupiedDaysRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_BED_YTD_OCCUPIED_DAYS", beans.size());
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void processBedOccupiedDaysTotals(FileReader reader) {
		List<LtcBedYtdOccupiedDaysTotals> beans = new CsvToBeanBuilder<LtcBedYtdOccupiedDaysTotals>(reader).withType(LtcBedYtdOccupiedDaysTotals.class).build().parse();
		beans.forEach(bean -> bedYtdOccupiedDaysTotalsRepository.save(bean));
		logger.info("Inserted {} records into LTCFIN_BED_YTD_OCCP_DAYS_TOT", beans.size());
	}

}
