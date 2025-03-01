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
@Table(name = "LTCFIN_YTD_DIR_CARE_COST_SUBS")
public class LtcYtdDirectCareCostSubtotals extends BaseEntity {

	@Id
	@Column(name = "LTCFYCCS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "DIR_CARE_COST_TYPE")
	private String dirCareType;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "SUB_DCR_CST_PRD_HRS_REG_YTD")
	private BigDecimal subTotalDirCareCostProdHrsRegularYTD;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "SUB_DCR_CST_PRD_HRS_OT_YTD")
	private BigDecimal subTotalDirCareCostProdHrsOTYTD;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "SUB_DCR_CST_PRD_HRS_ORI_YTD")
	private BigDecimal subTotalDirCareCostProdHrsOrientationYTD;
	
	@CsvBindByPosition(position = 5)
	@Column(name = "SUB_DCR_CST_PRD_HRS_SUB_YTD")
	private BigDecimal subTotalDirCareCostProdHrsSubtotalYTD;
	
	@CsvBindByPosition(position = 6)
	@Column(name = "SUB_DCR_CST_PRD_HRS_CON_YTD")
	private BigDecimal subTotalDirCareCostProdHrsContServYTD;
	
	@CsvBindByPosition(position = 7)
	@Column(name = "SUB_DCR_CST_PRD_HRS_ASU_YTD")
	private BigDecimal subTotalDirCareCostProdHrsAgencyStaffUtil;
	
	@CsvBindByPosition(position = 8)
	@Column(name = "SUB_DCR_CST_PRD_HRS_TOT_YTD")
	private BigDecimal subTotalDirCareCostProdHrsTotalYTD;
	
	@CsvBindByPosition(position = 9)
	@Column(name = "SUB_DCR_CST_NP_HRS_VAC_YTD")
	private BigDecimal subTotalDirCareCostNonProdHrsVacYTD;
	
	@CsvBindByPosition(position = 10)
	@Column(name = "SUB_DCR_CST_NP_HRS_SICK_YTD")
	private BigDecimal subTotalDirCareCostNonProdHrsSickYTD;
	
	@CsvBindByPosition(position = 11)
	@Column(name = "SUB_DCR_CST_NP_HRS_OTH_YTD")
	private BigDecimal subTotalDirCareCostNonProdHrsOtherServYTD;
	
	@CsvBindByPosition(position = 12)
	@Column(name = "SUB_DCR_CST_NP_HRS_TOT_YTD")
	private BigDecimal subTotalDirCareCostNonProdHrsTotalYTD;
	
	@CsvBindByPosition(position = 13)
	@Column(name = "SUB_DCR_CST_TOT_HRS_PD_YTD")
	private BigDecimal subTotalDirCareCostTotalHrsPaidYTD;
	
	@CsvBindByPosition(position = 14)
	@Column(name = "SUB_DCR_CST_HRLY_RT_STF_YTD")
	private BigDecimal subTotalDirCareCostHourlyRateStaffYTD;
	
	@CsvBindByPosition(position = 15)
	@Column(name = "SUB_DCR_CST_HRLY_RT_CON_YTD")
	private BigDecimal subTotalDirCareCostHourlyRateContractedYTD;

	@Override
	public String toString() {
		return "LtcYtdDirectCareCostSubtotals [id=" + id + ", dirCareType=" + dirCareType + ", subTotalDirCareCostProdHrsRegularYTD=" + subTotalDirCareCostProdHrsRegularYTD
				+ ", subTotalDirCareCostProdHrsOTYTD=" + subTotalDirCareCostProdHrsOTYTD + ", subTotalDirCareCostProdHrsOrientationYTD=" + subTotalDirCareCostProdHrsOrientationYTD
				+ ", subTotalDirCareCostProdHrsSubtotalYTD=" + subTotalDirCareCostProdHrsSubtotalYTD + ", subTotalDirCareCostProdHrsContServYTD=" + subTotalDirCareCostProdHrsContServYTD
				+ ", subTotalDirCareCostProdHrsAgencyStaffUtil=" + subTotalDirCareCostProdHrsAgencyStaffUtil + ", subTotalDirCareCostProdHrsTotalYTD=" + subTotalDirCareCostProdHrsTotalYTD
				+ ", subTotalDirCareCostNonProdHrsVacYTD=" + subTotalDirCareCostNonProdHrsVacYTD + ", subTotalDirCareCostNonProdHrsSickYTD=" + subTotalDirCareCostNonProdHrsSickYTD
				+ ", subTotalDirCareCostNonProdHrsOtherServYTD=" + subTotalDirCareCostNonProdHrsOtherServYTD + ", subTotalDirCareCostNonProdHrsTotalYTD=" + subTotalDirCareCostNonProdHrsTotalYTD
				+ ", subTotalDirCareCostTotalHrsPaidYTD=" + subTotalDirCareCostTotalHrsPaidYTD + ", subTotalDirCareCostHourlyRateStaffYTD=" + subTotalDirCareCostHourlyRateStaffYTD
				+ ", subTotalDirCareCostHourlyRateContractedYTD=" + subTotalDirCareCostHourlyRateContractedYTD + ", confirmationId=" + confirmationId + ", createUser=" + createUser
				+ ", createDateTime=" + createDateTime + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
