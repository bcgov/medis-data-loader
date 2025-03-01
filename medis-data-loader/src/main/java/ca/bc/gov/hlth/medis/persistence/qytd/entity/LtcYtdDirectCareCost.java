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
@Table(name = "LTCFIN_YTD_DIRECT_CARE_COST")
public class LtcYtdDirectCareCost extends BaseEntity {
	
	@Id
	@Column(name = "LTCFYDCC_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "DIR_CARE_COST_TYPE")
	private String dirCareCostType;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "DIR_CARE_COST_NAME")
	private String dirCareCostName;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "DIR_CARE_OTHER_VALUE")
	private String dirCareOtherValue;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "DIR_CARE_COST_PROD_HRS_REG_YTD")
	private BigDecimal dirCareCostProdHrsRegYtd;
	
	@CsvBindByPosition(position = 5)
	@Column(name = "DIR_CARE_COST_PROD_HRS_OT_YTD")
	private BigDecimal dirCareCostProdHrsOtYtd;
	
	@CsvBindByPosition(position = 6)
	@Column(name = "DIR_CARE_COST_PROD_HRS_ORI_YTD")
	private BigDecimal dirCareCostProdHrsOrientationYtd;
	
	@CsvBindByPosition(position = 7)
	@Column(name = "DIR_CARE_CST_PROD_HRS_CON_YTD")
	private BigDecimal dirCareCostProdHrsContractedYtd;
	
	@CsvBindByPosition(position = 8)
	@Column(name = "DIR_CARE_CST_PROD_HRS_ASU_YTD")
	private BigDecimal dirCareCostProdHrsAgencyStaffUtil;
	
	@CsvBindByPosition(position = 9)
	@Column(name = "DIR_CARE_COST_PROD_HRS_SUB_YTD")
	private BigDecimal dirCareCostProdHrsSubtotalYtd;
	
	@CsvBindByPosition(position = 10)
	@Column(name = "DIR_CARE_CST_NPROD_HRS_VAC_YTD")
	private BigDecimal dirCareCostNonProdHrsVacYtd;
	
	@CsvBindByPosition(position = 11)
	@Column(name = "DIR_CARE_COST_PROD_HRS_TOT_YTD")
	private BigDecimal dirCareCostProdHrsTotalYtd;
	
	@CsvBindByPosition(position = 12)
	@Column(name = "DRC_CST_NPROD_HRS_SICK_YTD")
	private BigDecimal dirCareCostNonProdHrsSickYtd;
	
	@CsvBindByPosition(position = 13)
	@Column(name = "DIR_CARE_CST_NPROD_HRS_OTH_YTD")
	private BigDecimal dirCareCostNonProdHrsOtherYtd;
	
	@CsvBindByPosition(position = 14)
	@Column(name = "DIR_CARE_CST_NPROD_HRS_TOT_YTD")
	private BigDecimal dirCareCostNonProdHrsTotalYtd;
	
	@CsvBindByPosition(position = 15)
	@Column(name = "DIR_CARE_CST_TOT_HRS_PAID_YTD")
	private BigDecimal dirCareCostTotalHrsPaidYtd;
	
	@CsvBindByPosition(position = 16)
	@Column(name = "DIR_CARE_CST_HRLY_RT_STAFF_YTD")
	private BigDecimal dirCareCostHourlyRateStaffYtd;
	
	@CsvBindByPosition(position = 17)
	@Column(name = "DIR_CARE_CST_HRLY_RT_CON_YTD")
	private BigDecimal dirCareCostHourlyRateContractedYtd;

		
}
