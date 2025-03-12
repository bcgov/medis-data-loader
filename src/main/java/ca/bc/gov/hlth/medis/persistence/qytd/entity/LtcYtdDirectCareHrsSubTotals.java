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

}
