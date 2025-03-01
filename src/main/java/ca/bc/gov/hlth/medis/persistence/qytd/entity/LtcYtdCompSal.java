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
@Table(name = "LTCFIN_YTD_COMP_SAL")
public class LtcYtdCompSal extends BaseEntity {

	@Id
	@Column(name = "LTCFYCS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "COMP_SAL_TYPE")
	private String compSalType;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "COMP_SAL_NAME")
	private String compSalName;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "COMP_SAL_STAFF_YTD")
	private BigDecimal compSalStaffYtd;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "COMP_SAL_CONTRACT_SERVICES_YTD")
	private BigDecimal compSalContractServicesYtd;
	
	@CsvBindByPosition(position = 5)
	@Column(name = "COMP_SAL_TOTAL_COST_YTD")
	private BigDecimal compSalTotalCostYtd;
	
	@CsvBindByPosition(position = 6)
	@Column(name = "COMP_SAL_OTHER_NAME")
	private String compSalOtherName;
}
