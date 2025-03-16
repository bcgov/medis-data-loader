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
@Table(name = "LTCFIN_YTD_COMP_BENEFITS")
public class LtcYtdCompBenefits extends BaseEntity {

	@Id
	@Column(name = "LTCFYCB_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "BENEFITS_TYPE")
	private String benefitsType;

	@CsvBindByPosition(position = 2)
	@Column(name = "BENEFITS_AMOUNT_YTD")
	private BigDecimal benefitsAmountYtd;

	@CsvBindByPosition(position = 3)
	@Column(name = "BENEFITS_PERCENTAGE_ALLOC")
	private BigDecimal benefitsPercentageAlloc;

}
