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
@Table(name = "LTCFIN_BED_YTD_OCCY_RATE_TOT")
public class LtcBedYtdOccupancyRateTotals extends BaseEntity {

	@Id
	@Column(name = "LTCFBYRT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "OCC_RATE_QUARTER")
	private String occRateQuarter;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "TOT_PLAN_MAX_OCC_DAYS")
	private BigDecimal totalPlanMaxOccDays;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "TOT_YTD_MAX_OCC_DAYS")
	private BigDecimal totalYTDMaxOccDays;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "TOT_YTD_OCC_DAYS")
	private BigDecimal totalYTDOccDays;
	
	@CsvBindByPosition(position = 5)
	@Column(name = "TOT_PERCENT_OCC")
	private BigDecimal totalPercentOcc;
	
}
