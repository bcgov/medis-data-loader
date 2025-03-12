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

}