package ca.bc.gov.hlth.medis.persistence.qytd.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "LTCFIN_YTD_SUBMISSION")
public class LtcYtdSubmission extends BaseEntity {

	@Id
	@Column(name = "LTCFYS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CsvBindByPosition(position = 1)
	@Column(name = "IS_DELETED")
	protected String isDeleted;

	@CsvBindByPosition(position = 2)
	@CsvDate(value = "yyyyMMddHHmmss")
	@Column(name = "SUBMISSION_DATE")
	@Temporal(TemporalType.DATE)
	protected Date submissionDate;

	@CsvBindByPosition(position = 3)
	@Column(name = "SUBMITTED_BY")
	protected String submittedBy;

	@CsvBindByPosition(position = 4)
	@Column(name = "SUBMISSION_STATUS")
	protected String submissionStatus;

	@CsvBindByPosition(position = 5)
	@Column(name = "CCIMS_ID")
	private String CCIMSID;

	@CsvBindByPosition(position = 6)
	@Column(name = "SUBMISSION_TYPE")
	private String submissionType;

	@CsvBindByPosition(position = 7)
	@Column(name = "PERIOD")
	private String period;

	@CsvBindByPosition(position = 8)
	@Column(name = "SUBMISSION_FY")
	private String submissionFy;

	@CsvBindByPosition(position = 9)
	@Column(name = "NB_TOTAL_BEDS")
	private BigDecimal nbTotalBeds;

	@CsvBindByPosition(position = 10)
	@Column(name = "NB_IN_SCOPE_BEDS")
	private BigDecimal nbInScopeBeds;

	@CsvBindByPosition(position = 11)
	@Column(name = "OCC_RATE_THRESHOLD")
	private BigDecimal occRateThreshold;

	@CsvBindByPosition(position = 12)
	@Column(name = "TOTAL_SALARIES_WAGES")
	private BigDecimal totalSalariesWages;

	@CsvBindByPosition(position = 13)
	@Column(name = "TOTAL_BENEFITS")
	private BigDecimal totalBenefits;

	@CsvBindByPosition(position = 14)
	@Column(name = "BENEFITS_PERCENT")
	private BigDecimal benefitsPercent;

	@CsvBindByPosition(position = 15)
	@Column(name = "TOTAL_VACANCIES")
	private BigDecimal totalVacancies;

	@CsvBindByPosition(position = 16)
	@Column(name = "NB_OUT_OF_SCOPE_BEDS")
	private BigDecimal nbOutOfScopeBeds;

	@CsvBindByPosition(position = 17)
	@Column(name = "NB_PRIVATE_BEDS")
	private BigDecimal nbPrivateBeds;

	@CsvBindByPosition(position = 18)
	@Column(name = "NB_TOT_BEDS_INCL_OUT_OF_SCOPE")
	private BigDecimal nbTotalBedsInclOutOfScope;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getSubmissionStatus() {
		return submissionStatus;
	}

	public void setSubmissionStatus(String submissionStatus) {
		this.submissionStatus = submissionStatus;
	}

	public String getCCIMSID() {
		return CCIMSID;
	}

	public void setCCIMSID(String cCIMSID) {
		CCIMSID = cCIMSID;
	}

	public String getSubmissionType() {
		return submissionType;
	}

	public void setSubmissionType(String submissionType) {
		this.submissionType = submissionType;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getSubmissionFy() {
		return submissionFy;
	}

	public void setSubmissionFy(String submissionFy) {
		this.submissionFy = submissionFy;
	}

	public BigDecimal getNbTotalBeds() {
		return nbTotalBeds;
	}

	public void setNbTotalBeds(BigDecimal nbTotalBeds) {
		this.nbTotalBeds = nbTotalBeds;
	}

	public BigDecimal getNbInScopeBeds() {
		return nbInScopeBeds;
	}

	public void setNbInScopeBeds(BigDecimal nbInScopeBeds) {
		this.nbInScopeBeds = nbInScopeBeds;
	}

	public BigDecimal getOccRateThreshold() {
		return occRateThreshold;
	}

	public void setOccRateThreshold(BigDecimal occRateThreshold) {
		this.occRateThreshold = occRateThreshold;
	}

	public BigDecimal getTotalSalariesWages() {
		return totalSalariesWages;
	}

	public void setTotalSalariesWages(BigDecimal totalSalariesWages) {
		this.totalSalariesWages = totalSalariesWages;
	}

	public BigDecimal getTotalBenefits() {
		return totalBenefits;
	}

	public void setTotalBenefits(BigDecimal totalBenefits) {
		this.totalBenefits = totalBenefits;
	}

	public BigDecimal getBenefitsPercent() {
		return benefitsPercent;
	}

	public void setBenefitsPercent(BigDecimal benefitsPercent) {
		this.benefitsPercent = benefitsPercent;
	}

	public BigDecimal getTotalVacancies() {
		return totalVacancies;
	}

	public void setTotalVacancies(BigDecimal totalVacancies) {
		this.totalVacancies = totalVacancies;
	}

	public BigDecimal getNbOutOfScopeBeds() {
		return nbOutOfScopeBeds;
	}

	public void setNbOutOfScopeBeds(BigDecimal nbOutOfScopeBeds) {
		this.nbOutOfScopeBeds = nbOutOfScopeBeds;
	}

	public BigDecimal getNbPrivateBeds() {
		return nbPrivateBeds;
	}

	public void setNbPrivateBeds(BigDecimal nbPrivateBeds) {
		this.nbPrivateBeds = nbPrivateBeds;
	}

	public BigDecimal getNbTotalBedsInclOutOfScope() {
		return nbTotalBedsInclOutOfScope;
	}

	public void setNbTotalBedsInclOutOfScope(BigDecimal nbTotalBedsInclOutOfScope) {
		this.nbTotalBedsInclOutOfScope = nbTotalBedsInclOutOfScope;
	}

	@Override
	public String toString() {
		return "LtcYtdSubmission [id=" + id + ", CCIMSID=" + CCIMSID + ", submissionType=" + submissionType + ", period=" + period + ", submissionFy=" + submissionFy + ", nbTotalBeds="
				+ nbTotalBeds + ", nbInScopeBeds=" + nbInScopeBeds + ", occRateThreshold=" + occRateThreshold + ", totalSalariesWages=" + totalSalariesWages + ", totalBenefits=" + totalBenefits
				+ ", benefitsPercent=" + benefitsPercent + ", totalVacancies=" + totalVacancies + ", nbOutOfScopeBeds=" + nbOutOfScopeBeds + ", nbPrivateBeds=" + nbPrivateBeds
				+ ", nbTotalBedsInclOutOfScope=" + nbTotalBedsInclOutOfScope + ", confirmationId=" + confirmationId + ", isDeleted=" + isDeleted + ", submissionDate=" + submissionDate
				+ ", submittedBy=" + submittedBy + ", submissionStatus=" + submissionStatus + "]";
	}

}
