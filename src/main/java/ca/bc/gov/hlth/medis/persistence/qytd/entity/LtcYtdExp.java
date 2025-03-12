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
@Table(name = "LTCFIN_YTD_EXP")
public class LtcYtdExp extends BaseEntity {

	@Id
	@Column(name = "LTCFYE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "EXP_TYPE")
	private String expType;

	@CsvBindByPosition(position = 2)
	@Column(name = "EXP_NAME")
	private String expName;

	@CsvBindByPosition(position = 3)
	@Column(name = "EXP_YTD")
	private BigDecimal expYtd;

	@CsvBindByPosition(position = 4)
	@Column(name = "EXP_NOTES")
	private String expNotes;

}