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
@Table(name = "LTCFIN_YTD_SUM_TOTALS")
public class LtcYtdSumTotals extends BaseEntity {

	@Id
	@Column(name = "LTCFYST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CsvBindByPosition(position = 1)
	@Column(name = "TOT_NAME")
	private String totName;

	@CsvBindByPosition(position = 2)
	@Column(name = "SUM_YTD")
	private BigDecimal sumYTD;

	@CsvBindByPosition(position = 3)
	@Column(name = "TOT_NOTES")
	private String totNotes;

}