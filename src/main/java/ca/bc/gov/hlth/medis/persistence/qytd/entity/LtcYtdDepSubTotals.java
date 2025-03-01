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
@Table(name = "LTCFIN_YTD_DEP_SUBTOTALS")
public class LtcYtdDepSubTotals extends BaseEntity {

	@Id
	@Column(name = "LTCFYDST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "SUB_TOTAL_DEP_YTD")
	private BigDecimal subTotalDepYtd;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "SUB_TOTAL_DEP_NOTES")
	private String subTotalDepNotes;
	}
