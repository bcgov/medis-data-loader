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
@Table(name = "LTCFIN_YTD_COMP_SAL_TOTALS")
public class LtcYtdCompSalTotals extends BaseEntity {

	@Id
	@Column(name = "LTCFYCST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "COMP_SAL_TOTAL_TYPE")
	private String compSalType;

	@CsvBindByPosition(position = 2)
	@Column(name = "TOTAL_COMP_SAL_STAFF_YTD")
	private BigDecimal totalCompSalStaffYTD;

	@CsvBindByPosition(position = 3)
	@Column(name = "TOTAL_COMP_SAL_CON_SER_YTD")
	private BigDecimal totalCompSalContractServicesYTD;

	@CsvBindByPosition(position = 4)
	@Column(name = "TOTAL_COMP_SAL_TOT_COST_YTD")
	private BigDecimal totalCompSalTotalCostYTD;
}