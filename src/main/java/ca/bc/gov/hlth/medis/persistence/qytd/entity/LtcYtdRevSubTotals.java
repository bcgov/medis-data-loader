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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getRevType() {
		return revType;
	}

	public void setRevType(String revType) {
		this.revType = revType;
	}

	public BigDecimal getSubTotalRevYtd() {
		return subTotalRevYtd;
	}

	public void setSubTotalRevYtd(BigDecimal subTotalRevYtd) {
		this.subTotalRevYtd = subTotalRevYtd;
	}

	public String getSubTotalRevNotes() {
		return subTotalRevNotes;
	}

	public void setSubTotalRevNotes(String subTotalRevNotes) {
		this.subTotalRevNotes = subTotalRevNotes;
	}

	@Override
	public String toString() {
		return "LtcYtdRevSubTotals [id=" + id + ", confirmationId=" + confirmationId + ", revType=" + revType + ", subTotalRevYtd=" + subTotalRevYtd + ", subTotalRevNotes="
				+ subTotalRevNotes + "]";
	}

}
