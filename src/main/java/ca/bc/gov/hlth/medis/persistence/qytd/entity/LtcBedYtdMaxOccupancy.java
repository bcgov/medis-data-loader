package ca.bc.gov.hlth.medis.persistence.qytd.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "LTCFIN_BED_YTD_MAX_OCCUPANCY")
public class LtcBedYtdMaxOccupancy extends BaseEntity {

	@Id
	@Column(name = "LTCFBYMO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@CsvBindByPosition(position = 1)
	@Column(name = "BED_INDEX")
	private String bedIndex;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "QUARTER_INVENTORY")
	private String quarterInventory;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "BED_FUNDING_TYPE")
	private String bedFundingType;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "BED_SUBTYPE")
	private String bedSubype;
	
	@CsvBindByPosition(position = 5)
	@CsvDate(value = "yyyyMMddHHmmss")
	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@CsvBindByPosition(position = 6)
	@CsvDate(value = "yyyyMMddHHmmss")
	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@CsvBindByPosition(position = 7)
	@Column(name = "NUMBER_OF_BEDS")
	private BigDecimal numberOfBeds;
	
	@CsvBindByPosition(position = 8)
	@Column(name = "MAXIMUM_BED_DAYS")
	private BigDecimal maximumBedDays;
	
	@CsvBindByPosition(position = 9)
	@Column(name = "NOTES")
	private String notes;	

	
	
}
