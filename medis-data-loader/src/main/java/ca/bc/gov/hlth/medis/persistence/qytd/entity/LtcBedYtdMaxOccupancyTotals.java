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
@Table(name = "LTCFIN_BED_YTD_MAX_OCCY_TOTALS")
public class LtcBedYtdMaxOccupancyTotals extends BaseEntity {
	
	@Id
	@Column(name = "LTCFBYMT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@CsvBindByPosition(position = 1)
	@Column(name = "BED_OCCUPANCY_TYPE")
	private String occupancyType;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "BED_FUNDING_TYPE")
	private String bedFundingType;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "TOTAL_BEDS_QUARTER_1")
	private BigDecimal totalBedQuarter1;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "TOTAL_BEDS_QUARTER_2")
	private BigDecimal totalBedQuarter2;
	
	@CsvBindByPosition(position = 5)
	@Column(name = "TOTAL_BEDS_QUARTER_3")
	private BigDecimal totalBedQuarter3;
	
	@CsvBindByPosition(position = 6)
	@Column(name = "TOTAL_BEDS_QUARTER_4")
	private BigDecimal totalBedQuarter4;
	
	@CsvBindByPosition(position = 7)
	@Column(name = "TOTAL_PLANNED_BED_DAYS")
	private BigDecimal totalBedDays;
	
}
