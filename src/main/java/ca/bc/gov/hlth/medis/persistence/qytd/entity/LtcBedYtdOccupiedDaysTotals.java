package ca.bc.gov.hlth.medis.persistence.qytd.entity;

import java.math.BigDecimal;

import com.opencsv.bean.CsvBindByPosition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LTCFIN_BED_YTD_OCCP_DAYS_TOT")
public class LtcBedYtdOccupiedDaysTotals extends BaseEntity {
	@Id
	@Column(name = "LTCFBYOT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "OCC_QUARTER")
	private String occQuarter;

	@CsvBindByPosition(position = 2)
	@Column(name = "TOT_OCC_DAYS_YTD_IN_SCP_PUB")
	private BigDecimal occDaysYTDInScopePublic;

	@CsvBindByPosition(position = 3)
	@Column(name = "TOT_OCC_DAYS_YTD_OUT_SCP_PUB")
	private BigDecimal occDaysYTDOutScopePublic;

	@CsvBindByPosition(position = 4)
	@Column(name = "TOT_OCC_DAYS_YTD_PRIVATE")
	private BigDecimal occDaysYTDTotalDays;

	@CsvBindByPosition(position = 5)
	@Column(name = "TOT_OCC_DAYS_YTD_TOT_DAYS")
	private BigDecimal occDaysYTDPrivate;

}