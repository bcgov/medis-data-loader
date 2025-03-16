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
@Table(name = "LTCFIN_YTD_COMP_SAL_SUBTOTALS")
public class LtcYtdCompSalSubtotals extends BaseEntity {

	@Id
	@Column(name = "LTCFYCSS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "COMP_SAL_TYPE")
	private String compSalType;

	@CsvBindByPosition(position = 2)
	@Column(name = "SUB_TOT_COMP_SAL_STAFF_YTD")
	private BigDecimal subTotalCompSalStaffYTD;

	@CsvBindByPosition(position = 3)
	@Column(name = "SUB_TOT_COMP_SAL_CON_SER_YTD")
	private BigDecimal subTotalCompSalContractServicesYTD;

	@CsvBindByPosition(position = 4)
	@Column(name = "SUB_TOT_COMP_SAL_TOT_COST_YTD")
	private BigDecimal subTotalCompSalTotalCostYTD;
}
