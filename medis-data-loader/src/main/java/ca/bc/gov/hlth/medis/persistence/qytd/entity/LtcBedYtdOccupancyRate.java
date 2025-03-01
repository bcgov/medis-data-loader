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
@Table(name = "LTCFIN_BED_YTD_OCCUPANCY_RATE")
public class LtcBedYtdOccupancyRate extends BaseEntity {

	@Id
	@Column(name = "LTCFBYOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "OCC_RATE_QUARTER")
	private String occRateQuarter;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "OCC_RATE_BED_TYPES")	
	private String occRateBedTypes;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "PLAN_MAX_OCC_DAYS")
	private BigDecimal planMaxOccDays;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "YTD_MAX_OCC_DAYS")
	private BigDecimal ytdMaxOccDays;
	
	@CsvBindByPosition(position = 5)
	@Column(name = "YTD_OCC_DAYS")
	private BigDecimal ytdOccDays;
	
	@CsvBindByPosition(position = 6)
	@Column(name = "PERCENT_OCC")
	private BigDecimal percentOcc;
	
	@CsvBindByPosition(position = 7)
	@Column(name = "OCC_RATE_NOTES")
	private String occRateNotes;
	
	}
