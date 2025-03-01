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
@Table(name = "LTCFIN_YTD_COMP_HRS")
public class LtcYtdCompHrs extends BaseEntity {
	
	@Id
	@Column(name = "LTCFYCH_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "COMP_HRS_TYPE")
	private String compHrsType;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "COMP_HRS_NAME")
	private String compHrsName;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "COMP_HRS_STAFF_YTD")
	private BigDecimal compHrsStaffYtd;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "COMP_HRS_CONTRACT_SERVICES_YTD")
	private BigDecimal compHrsContractServicesYtd;
	
	@CsvBindByPosition(position = 5)
	@Column(name = "COMP_TOTAL_WORKED_HRS_YTD")
	private BigDecimal compTotalWorkedHrsYtd;
	
	@CsvBindByPosition(position = 6)
	@Column(name = "COMP_HRS_OTHER_NAME")
	private String compHrsOtherName;
		
}
