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
@Table(name = "LTCFIN_YTD_DIR_CARE_VACANCY")
public class LtcYtdDirectCareVacancy extends BaseEntity {

	@Id
	@Column(name = "LTCFYDCV_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "DIR_CARE_VACANCY_TYPE")
	private String directCareVacancyType;

	@CsvBindByPosition(position = 2)
	@Column(name = "DIR_CARE_VACANCY_NAME")
	private String directCareVacancyName;

	@CsvBindByPosition(position = 3)
	@Column(name = "DIR_CARE_VAC_POSITIONS")
	private BigDecimal directCareVacPositions;

	@CsvBindByPosition(position = 4)
	@Column(name = "DIR_CARE_VAC_OTHER_NAME")
	private String directCareVacOtherName;

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

	public String getDirectCareVacancyType() {
		return directCareVacancyType;
	}

	public void setDirectCareVacancyType(String directCareVacancyType) {
		this.directCareVacancyType = directCareVacancyType;
	}

	public String getDirectCareVacancyName() {
		return directCareVacancyName;
	}

	public void setDirectCareVacancyName(String directCareVacancyName) {
		this.directCareVacancyName = directCareVacancyName;
	}

	public BigDecimal getDirectCareVacPositions() {
		return directCareVacPositions;
	}

	public void setDirectCareVacPositions(BigDecimal directCareVacPositions) {
		this.directCareVacPositions = directCareVacPositions;
	}

	public String getDirectCareVacOtherName() {
		return directCareVacOtherName;
	}

	public void setDirectCareVacOtherName(String directCareVacOtherName) {
		this.directCareVacOtherName = directCareVacOtherName;
	}

	@Override
	public String toString() {
		return "LtcYtdDirectCareVacancy [id=" + id + ", confirmationId=" + confirmationId + ", directCareVacancyType=" + directCareVacancyType + ", directCareVacancyName=" + directCareVacancyName
				+ ", directCareVacPositions=" + directCareVacPositions + ", directCareVacOtherName=" + directCareVacOtherName + "]";
	}

}
