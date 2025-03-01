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
@Table(name = "LTCFIN_YTD_DIR_CARE_HRS_SUBS")
public class LtcYtdDirectCareHrsSubTotals extends BaseEntity {

	@Id
	@Column(name = "LTCFYDCS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "DIR_CARE_TYPE")
	private String dirCareType;

	@CsvBindByPosition(position = 2)
	@Column(name = "SUB_DRC_PROD_HRS_REG_YTD")
	private BigDecimal subTotalDirCareProdHrsRegularYTD;

	@CsvBindByPosition(position = 3)
	@Column(name = "SUB_DRC_PROD_HRS_OT_YTD")
	private BigDecimal subTotalDirCareProdHrsOTYTD;

	@CsvBindByPosition(position = 4)
	@Column(name = "SUB_DRC_PROD_HRS_ORI_YTD")
	private BigDecimal subTotalDirCareProdHrsOrientationYTD;

	@CsvBindByPosition(position = 5)
	@Column(name = "SUB_DRC_PROD_HRS_SUB_YTD")
	private BigDecimal subTotalDirCareProdHrsSubtotalYTD;

	@CsvBindByPosition(position = 6)
	@Column(name = "SUB_DRC_PROD_HRS_CON_YTD")
	private BigDecimal subTotalDirCareProdHrsContServYTD;

	@CsvBindByPosition(position = 7)
	@Column(name = "SUB_DRC_PROD_HRS_ASU_YTD")
	private BigDecimal subTotalDirCareProdHrsAgencyStaffUtil;

	@CsvBindByPosition(position = 8)
	@Column(name = "SUB_DRC_PROD_HRS_TOT_YTD")
	private BigDecimal subTotalDirCareProdHrsTotalYTD;

	@CsvBindByPosition(position = 9)
	@Column(name = "SUB_DRC_NPROD_HRS_VAC_YTD")
	private BigDecimal subTotalDirCareNonProdHrsVacYTD;

	@CsvBindByPosition(position = 10)
	@Column(name = "SUB_DRC_NPROD_HRS_SICK_YTD")
	private BigDecimal subTotalDirCareNonProdHrsSickYTD;

	@CsvBindByPosition(position = 11)
	@Column(name = "SUB_DRC_NPROD_HRS_OTH_YTD")
	private BigDecimal subTotalDirCareNonProdHrsOtherServYTD;

	@CsvBindByPosition(position = 12)
	@Column(name = "SUB_DRC_NPROD_HRS_TOT_YTD")
	private BigDecimal subTotalDirCareNonProdHrsTotalYTD;

	@CsvBindByPosition(position = 13)
	@Column(name = "SUB_DRC_TOTAL_HRS_PAID_YTD")
	private BigDecimal subTotalDirCareTotalHrsPaidYTD;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDirCareType() {
		return dirCareType;
	}

	public void setDirCareType(String dirCareType) {
		this.dirCareType = dirCareType;
	}

	public BigDecimal getSubTotalDirCareProdHrsRegularYTD() {
		return subTotalDirCareProdHrsRegularYTD;
	}

	public void setSubTotalDirCareProdHrsRegularYTD(BigDecimal subTotalDirCareProdHrsRegularYTD) {
		this.subTotalDirCareProdHrsRegularYTD = subTotalDirCareProdHrsRegularYTD;
	}

	public BigDecimal getSubTotalDirCareProdHrsOTYTD() {
		return subTotalDirCareProdHrsOTYTD;
	}

	public void setSubTotalDirCareProdHrsOTYTD(BigDecimal subTotalDirCareProdHrsOTYTD) {
		this.subTotalDirCareProdHrsOTYTD = subTotalDirCareProdHrsOTYTD;
	}

	public BigDecimal getSubTotalDirCareProdHrsOrientationYTD() {
		return subTotalDirCareProdHrsOrientationYTD;
	}

	public void setSubTotalDirCareProdHrsOrientationYTD(BigDecimal subTotalDirCareProdHrsOrientationYTD) {
		this.subTotalDirCareProdHrsOrientationYTD = subTotalDirCareProdHrsOrientationYTD;
	}

	public BigDecimal getSubTotalDirCareProdHrsSubtotalYTD() {
		return subTotalDirCareProdHrsSubtotalYTD;
	}

	public void setSubTotalDirCareProdHrsSubtotalYTD(BigDecimal subTotalDirCareProdHrsSubtotalYTD) {
		this.subTotalDirCareProdHrsSubtotalYTD = subTotalDirCareProdHrsSubtotalYTD;
	}

	public BigDecimal getSubTotalDirCareProdHrsContServYTD() {
		return subTotalDirCareProdHrsContServYTD;
	}

	public void setSubTotalDirCareProdHrsContServYTD(BigDecimal subTotalDirCareProdHrsContServYTD) {
		this.subTotalDirCareProdHrsContServYTD = subTotalDirCareProdHrsContServYTD;
	}

	public BigDecimal getSubTotalDirCareProdHrsAgencyStaffUtil() {
		return subTotalDirCareProdHrsAgencyStaffUtil;
	}

	public void setSubTotalDirCareProdHrsAgencyStaffUtil(BigDecimal subTotalDirCareProdHrsAgencyStaffUtil) {
		this.subTotalDirCareProdHrsAgencyStaffUtil = subTotalDirCareProdHrsAgencyStaffUtil;
	}

	public BigDecimal getSubTotalDirCareProdHrsTotalYTD() {
		return subTotalDirCareProdHrsTotalYTD;
	}

	public void setSubTotalDirCareProdHrsTotalYTD(BigDecimal subTotalDirCareProdHrsTotalYTD) {
		this.subTotalDirCareProdHrsTotalYTD = subTotalDirCareProdHrsTotalYTD;
	}

	public BigDecimal getSubTotalDirCareNonProdHrsVacYTD() {
		return subTotalDirCareNonProdHrsVacYTD;
	}

	public void setSubTotalDirCareNonProdHrsVacYTD(BigDecimal subTotalDirCareNonProdHrsVacYTD) {
		this.subTotalDirCareNonProdHrsVacYTD = subTotalDirCareNonProdHrsVacYTD;
	}

	public BigDecimal getSubTotalDirCareNonProdHrsSickYTD() {
		return subTotalDirCareNonProdHrsSickYTD;
	}

	public void setSubTotalDirCareNonProdHrsSickYTD(BigDecimal subTotalDirCareNonProdHrsSickYTD) {
		this.subTotalDirCareNonProdHrsSickYTD = subTotalDirCareNonProdHrsSickYTD;
	}

	public BigDecimal getSubTotalDirCareNonProdHrsOtherServYTD() {
		return subTotalDirCareNonProdHrsOtherServYTD;
	}

	public void setSubTotalDirCareNonProdHrsOtherServYTD(BigDecimal subTotalDirCareNonProdHrsOtherServYTD) {
		this.subTotalDirCareNonProdHrsOtherServYTD = subTotalDirCareNonProdHrsOtherServYTD;
	}

	public BigDecimal getSubTotalDirCareNonProdHrsTotalYTD() {
		return subTotalDirCareNonProdHrsTotalYTD;
	}

	public void setSubTotalDirCareNonProdHrsTotalYTD(BigDecimal subTotalDirCareNonProdHrsTotalYTD) {
		this.subTotalDirCareNonProdHrsTotalYTD = subTotalDirCareNonProdHrsTotalYTD;
	}

	public BigDecimal getSubTotalDirCareTotalHrsPaidYTD() {
		return subTotalDirCareTotalHrsPaidYTD;
	}

	public void setSubTotalDirCareTotalHrsPaidYTD(BigDecimal subTotalDirCareTotalHrsPaidYTD) {
		this.subTotalDirCareTotalHrsPaidYTD = subTotalDirCareTotalHrsPaidYTD;
	}

	@Override
	public String toString() {
		return "LtcYtdDirectCareHrsSubTotals [id=" + id + ", confirmationID=" + confirmationId + ", dirCareType=" + dirCareType + ", subTotalDirCareProdHrsRegularYTD="
				+ subTotalDirCareProdHrsRegularYTD + ", subTotalDirCareProdHrsOTYTD=" + subTotalDirCareProdHrsOTYTD + ", subTotalDirCareProdHrsOrientationYTD=" + subTotalDirCareProdHrsOrientationYTD
				+ ", subTotalDirCareProdHrsSubtotalYTD=" + subTotalDirCareProdHrsSubtotalYTD + ", subTotalDirCareProdHrsContServYTD=" + subTotalDirCareProdHrsContServYTD
				+ ", subTotalDirCareProdHrsAgencyStaffUtil=" + subTotalDirCareProdHrsAgencyStaffUtil + ", subTotalDirCareProdHrsTotalYTD=" + subTotalDirCareProdHrsTotalYTD
				+ ", subTotalDirCareNonProdHrsVacYTD=" + subTotalDirCareNonProdHrsVacYTD + ", subTotalDirCareNonProdHrsSickYTD=" + subTotalDirCareNonProdHrsSickYTD
				+ ", subTotalDirCareNonProdHrsOtherServYTD=" + subTotalDirCareNonProdHrsOtherServYTD + ", subTotalDirCareNonProdHrsTotalYTD=" + subTotalDirCareNonProdHrsTotalYTD
				+ ", subTotalDirCareTotalHrsPaidYTD=" + subTotalDirCareTotalHrsPaidYTD + "]";
	}

}
