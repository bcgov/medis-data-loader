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
@Table(name = "LTCFIN_YTD_COMP_HRS_SUBTOTALS")
public class LtcYtdCompHrsSubtotals extends BaseEntity {

	@Id
	@Column(name = "LTCFYCHS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "COMP_HRS_TYPE")
	private String compHrsType;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "SUB_TOT_COMP_HRS_STAFF_YTD")
	private BigDecimal subTotalCompHrsStaffYTD;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "SUB_TOT_COMP_HRS_CON_SER_YTD")
	private BigDecimal subTotalCompHrsContractServicesYTD;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "SUB_TOT_COMP_TOT_WRK_HRS_YTD")
	private BigDecimal subTotalCompTotalWorkedHrsYTD;
}
