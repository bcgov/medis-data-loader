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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	public BigDecimal getSubTotalExpYtd() {
		return subTotalExpYtd;
	}

	public void setSubTotalExpYtd(BigDecimal subTotalExpYtd) {
		this.subTotalExpYtd = subTotalExpYtd;
	}

	public String getSubTotalExpNotes() {
		return subTotalExpNotes;
	}

	public void setSubTotalExpNotes(String subTotalExpNotes) {
		this.subTotalExpNotes = subTotalExpNotes;
	}

	@Override
	public String toString() {
		return "LtcYtdExpSubTotals [id=" + id + ", confirmationId=" + confirmationId + ", expType=" + expType + ", subTotalExpYtd=" + subTotalExpYtd + ", subTotalExpNotes=" + subTotalExpNotes + "]";
	}

	
	
}
