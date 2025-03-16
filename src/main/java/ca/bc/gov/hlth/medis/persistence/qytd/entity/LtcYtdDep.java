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
@Table(name = "LTCFIN_YTD_DEP")
public class LtcYtdDep extends BaseEntity {

	@Id
	@Column(name = "LTCFYD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "DEP_NAME")
	private String depName;

	@CsvBindByPosition(position = 2)
	@Column(name = "DEP_YTD")
	private BigDecimal depYtd;

	@CsvBindByPosition(position = 3)
	@Column(name = "DEP_NOTES")
	private String depNotes;
}