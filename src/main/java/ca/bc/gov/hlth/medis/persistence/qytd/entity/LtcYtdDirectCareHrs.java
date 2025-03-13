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
	private String dirCareProdHrsAgencyStuffUtilYtd;

	@CsvBindByPosition(position = 9)
	@Column(name = "DIR_CARE_PROD_HRS_SUB_YTD")
	private String dirCareProdHrsSubtotalYtd;

	@CsvBindByPosition(position = 10)
	@Column(name = "DIR_CARE_PROD_HRS_TOT_YTD")
	private String dirCareProdHrsTotalYtd;

	@CsvBindByPosition(position = 11)
	@Column(name = "DIR_CARE_NON_PROD_HRS_VAC_YTD")
	private String dirCareNonProdHrsVacYtd;

	@CsvBindByPosition(position = 12)
	@Column(name = "DIR_CARE_NON_PROD_HRS_SICK_YTD")
	private String dirCareNonProdHrsSickYtd;

	@CsvBindByPosition(position = 13)
	@Column(name = "DIR_CARE_NPROD_HRS_OTH_YTD")
	private String dirCareNonProdHrsOtherYtd;

	@CsvBindByPosition(position = 14)
	@Column(name = "DIR_CARE_NPROD_HRS_TOT_YTD")
	private String dirCareNonProdHrsTotalYtd;

	@CsvBindByPosition(position = 15)
	@Column(name = "DIR_CARE_TOTAL_HRS_PAID_YTD")
	private String dirCareTotalHrsPaidYtd;

}