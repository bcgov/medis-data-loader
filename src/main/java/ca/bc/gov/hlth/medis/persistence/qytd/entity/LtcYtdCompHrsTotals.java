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
@Table(name = "LTCFIN_YTD_COMP_HRS_TOTALS")
public class LtcYtdCompHrsTotals extends BaseEntity {

	@Id
	@Column(name = "LTCFYCHT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "COMP_HRS_TOTAL_TYPE")
	private String compHrsTotalType;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "TOTAL_COMP_HRS_STAFF_YTD")
	private BigDecimal totalCompHrsStaffYTD;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "TOTAL_COMP_HRS_CON_SER_YTD")
	private BigDecimal totalCompHrsContractServicesYTD;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "TOTAL_COMP_TOT_WRK_HRS_YTD")
	private BigDecimal totalCompTotalWorkedHrsYTD;
	
		
}
