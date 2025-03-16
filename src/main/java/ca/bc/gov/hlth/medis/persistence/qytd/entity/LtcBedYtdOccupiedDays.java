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
@Table(name = "LTCFIN_BED_YTD_OCCUPIED_DAYS")
public class LtcBedYtdOccupiedDays extends BaseEntity {

	@Id
	@Column(name = "LTCFBYOD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "OCC_QUARTER")
	private String occQuarter;

	@CsvBindByPosition(position = 2)
	@Column(name = "OCC_MONTH")
	private String occMonth;

	@CsvBindByPosition(position = 3)
	@Column(name = "OCC_DAYS_YTD_IN_SCOPE_PUBLIC")
	private BigDecimal occDaysYTDInScopePublic;

	@CsvBindByPosition(position = 4)
	@Column(name = "OCC_DAYS_YTD_OUT_SCOPE_PUBLIC")
	private BigDecimal occDaysYTOutScopePublic;

	@CsvBindByPosition(position = 5)
	@Column(name = "OCC_DAYS_YTD_PRIVATE")
	private BigDecimal occDaysYTDPrivate;

	@CsvBindByPosition(position = 6)
	@Column(name = "OCC_DAYS_YTD_TOTAL_DAYS")
	private BigDecimal occDaysYtdTotalDays;

}
