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
@Table(name = "LTCFIN_YTD_EXP_SUBTOTALS")
public class LtcYtdExpSubTotals extends BaseEntity {

	@Id
	@Column(name = "LTCFYEST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "EXP_TYPE")
	private String expType;

	@CsvBindByPosition(position = 2)
	@Column(name = "SUB_TOTAL_EXP_YTD")
	private BigDecimal subTotalExpYtd;

	@CsvBindByPosition(position = 3)
	@Column(name = "SUB_TOTAL_EXP_NOTES")
	private String subTotalExpNotes;

}