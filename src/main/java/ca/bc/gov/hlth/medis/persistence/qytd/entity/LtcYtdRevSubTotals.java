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
@Table(name = "LTCFIN_YTD_REV_SUBTOTALS")
public class LtcYtdRevSubTotals extends BaseEntity {

	@Id
	@Column(name = "LTCFYRST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CsvBindByPosition(position = 1)
	@Column(name = "REV_TYPE")
	private String revType;

	@CsvBindByPosition(position = 2)
	@Column(name = "SUB_TOTAL_REV_YTD")
	private BigDecimal subTotalRevYtd;

	@CsvBindByPosition(position = 3)
	@Column(name = "SUB_TOTAL_REV_NOTES")
	private String subTotalRevNotes;

}