package ca.bc.gov.hlth.medis.persistence.qytd.entity;

import com.opencsv.bean.CsvBindByPosition;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LTCFIN_YTD_DIRECT_CARE_HRS")
public class LtcYtdDirectCareHrs extends BaseEntity {

	@Id
	@Column(name = "LTCFYDCH_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "DIR_CARE_TYPE")
	private String dirCareType;

	@CsvBindByPosition(position = 2)
	@Column(name = "DIR_CARE_NAME")
	private String dirCareName;

	@CsvBindByPosition(position = 3)
	@Column(name = "DIR_CARE_OTHER_VALUE")
	private String dirCareOtherValue;

	@CsvBindByPosition(position = 4)
	@Column(name = "DIR_CARE_PROD_HRS_REG_YTD")
	private String dirCareProdHrsRegYtd;

	@CsvBindByPosition(position = 5)
	@Column(name = "DIR_CARE_PROD_HRS_OT_YTD")
	private String dirCareProdHrsOtYtd;

	@CsvBindByPosition(position = 6)
	@Column(name = "DIR_CARE_PROD_HRS_ORI_YTD")
	private String dirCareProdHrsOrientationYtd;

	@CsvBindByPosition(position = 7)
	@Column(name = "DIR_CARE_PROD_HRS_CON_YTD")
	private String dirCareProdHrsContractedYtd;

	@CsvBindByPosition(position = 8)
	@Column(name = "DIR_CARE_PROD_HRS_ASU_YTD")
	private String dirCareProdHrsSubtotalYtd;

	@CsvBindByPosition(position = 9)
	@Column(name = "DIR_CARE_NON_PROD_HRS_VAC_YTD")
	private String dirCareProdHrsTotalYtd;

	@CsvBindByPosition(position = 10)
	@Column(name = "DIR_CARE_PROD_HRS_SUB_YTD")
	private String dirCareNonProdHrsVacYtd;

	@CsvBindByPosition(position = 11)
	@Column(name = "DIR_CARE_NON_PROD_HRS_SICK_YTD")
	private String dirCareNonProdHrsSickYtd;

	@CsvBindByPosition(position = 12)
	@Column(name = "DIR_CARE_PROD_HRS_TOT_YTD")
	private String dirCareNonProdHrsOtherYtd;

	@CsvBindByPosition(position = 13)
	@Column(name = "DIR_CARE_NPROD_HRS_OTH_YTD")
	private String dirCareNonProdHrsTotalYtd;

	@CsvBindByPosition(position = 14)
	@Column(name = "DIR_CARE_NPROD_HRS_TOT_YTD")
	private String dirCareTotalHrsPaidYtd;

	@CsvBindByPosition(position = 15)
	@Column(name = "DIR_CARE_TOTAL_HRS_PAID_YTD")
	private String dirCareProdHrsAgencyStuffUtilYtd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getDirCareType() {
		return dirCareType;
	}

	public void setDirCareType(String dirCareType) {
		this.dirCareType = dirCareType;
	}

	public String getDirCareName() {
		return dirCareName;
	}

	public void setDirCareName(String dirCareName) {
		this.dirCareName = dirCareName;
	}

	public String getDirCareOtherValue() {
		return dirCareOtherValue;
	}

	public void setDirCareOtherValue(String dirCareOtherValue) {
		this.dirCareOtherValue = dirCareOtherValue;
	}

	public String getDirCareProdHrsRegYtd() {
		return dirCareProdHrsRegYtd;
	}

	public void setDirCareProdHrsRegYtd(String dirCareProdHrsRegYtd) {
		this.dirCareProdHrsRegYtd = dirCareProdHrsRegYtd;
	}

	public String getDirCareProdHrsOtYtd() {
		return dirCareProdHrsOtYtd;
	}

	public void setDirCareProdHrsOtYtd(String dirCareProdHrsOtYtd) {
		this.dirCareProdHrsOtYtd = dirCareProdHrsOtYtd;
	}

	public String getDirCareProdHrsOrientationYtd() {
		return dirCareProdHrsOrientationYtd;
	}

	public void setDirCareProdHrsOrientationYtd(String dirCareProdHrsOrientationYtd) {
		this.dirCareProdHrsOrientationYtd = dirCareProdHrsOrientationYtd;
	}

	public String getDirCareProdHrsContractedYtd() {
		return dirCareProdHrsContractedYtd;
	}

	public void setDirCareProdHrsContractedYtd(String dirCareProdHrsContractedYtd) {
		this.dirCareProdHrsContractedYtd = dirCareProdHrsContractedYtd;
	}

	public String getDirCareProdHrsSubtotalYtd() {
		return dirCareProdHrsSubtotalYtd;
	}

	public void setDirCareProdHrsSubtotalYtd(String dirCareProdHrsSubtotalYtd) {
		this.dirCareProdHrsSubtotalYtd = dirCareProdHrsSubtotalYtd;
	}

	public String getDirCareProdHrsTotalYtd() {
		return dirCareProdHrsTotalYtd;
	}

	public void setDirCareProdHrsTotalYtd(String dirCareProdHrsTotalYtd) {
		this.dirCareProdHrsTotalYtd = dirCareProdHrsTotalYtd;
	}

	public String getDirCareNonProdHrsVacYtd() {
		return dirCareNonProdHrsVacYtd;
	}

	public void setDirCareNonProdHrsVacYtd(String dirCareNonProdHrsVacYtd) {
		this.dirCareNonProdHrsVacYtd = dirCareNonProdHrsVacYtd;
	}

	public String getDirCareNonProdHrsSickYtd() {
		return dirCareNonProdHrsSickYtd;
	}

	public void setDirCareNonProdHrsSickYtd(String dirCareNonProdHrsSickYtd) {
		this.dirCareNonProdHrsSickYtd = dirCareNonProdHrsSickYtd;
	}

	public String getDirCareNonProdHrsOtherYtd() {
		return dirCareNonProdHrsOtherYtd;
	}

	public void setDirCareNonProdHrsOtherYtd(String dirCareNonProdHrsOtherYtd) {
		this.dirCareNonProdHrsOtherYtd = dirCareNonProdHrsOtherYtd;
	}

	public String getDirCareNonProdHrsTotalYtd() {
		return dirCareNonProdHrsTotalYtd;
	}

	public void setDirCareNonProdHrsTotalYtd(String dirCareNonProdHrsTotalYtd) {
		this.dirCareNonProdHrsTotalYtd = dirCareNonProdHrsTotalYtd;
	}

	public String getDirCareTotalHrsPaidYtd() {
		return dirCareTotalHrsPaidYtd;
	}

	public void setDirCareTotalHrsPaidYtd(String dirCareTotalHrsPaidYtd) {
		this.dirCareTotalHrsPaidYtd = dirCareTotalHrsPaidYtd;
	}

	public String getDirCareProdHrsAgencyStuffUtilYtd() {
		return dirCareProdHrsAgencyStuffUtilYtd;
	}

	public void setDirCareProdHrsAgencyStuffUtilYtd(String dirCareProdHrsAgencyStuffUtilYtd) {
		this.dirCareProdHrsAgencyStuffUtilYtd = dirCareProdHrsAgencyStuffUtilYtd;
	}

	@Override
	public String toString() {
		return "LtcYtdDirectCareHrs [id=" + id + ", confirmationId=" + confirmationId + ", dirCareType=" + dirCareType + ", dirCareName=" + dirCareName + ", dirCareOtherValue=" + dirCareOtherValue
				+ ", dirCareProdHrsRegYtd=" + dirCareProdHrsRegYtd + ", dirCareProdHrsOtYtd=" + dirCareProdHrsOtYtd + ", dirCareProdHrsOrientationYtd=" + dirCareProdHrsOrientationYtd
				+ ", dirCareProdHrsContractedYtd=" + dirCareProdHrsContractedYtd + ", dirCareProdHrsSubtotalYtd=" + dirCareProdHrsSubtotalYtd + ", dirCareProdHrsTotalYtd=" + dirCareProdHrsTotalYtd
				+ ", dirCareNonProdHrsVacYtd=" + dirCareNonProdHrsVacYtd + ", dirCareNonProdHrsSickYtd=" + dirCareNonProdHrsSickYtd + ", dirCareNonProdHrsOtherYtd=" + dirCareNonProdHrsOtherYtd
				+ ", dirCareNonProdHrsTotalYtd=" + dirCareNonProdHrsTotalYtd + ", dirCareTotalHrsPaidYtd=" + dirCareTotalHrsPaidYtd + ", dirCareProdHrsAgencyStuffUtilYtd="
				+ dirCareProdHrsAgencyStuffUtilYtd + "]";
	}

}
