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
@Table(name = "LTCFIN_YTD_REV")
public class LtcYtdRev extends BaseEntity {

	@Id
	@Column(name = "LTCFYR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "REV_TYPE")
	private String revType;

	@CsvBindByPosition(position = 2)
	@Column(name = "REV_NAME")
	private String revName;

	@CsvBindByPosition(position = 3)
	@Column(name = "REV_YTD")
	private BigDecimal revYTD;

	@CsvBindByPosition(position = 4)
	@Column(name = "REV_NOTES")
	private String revNotes;
}