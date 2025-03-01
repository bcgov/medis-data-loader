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

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

	public BigDecimal getExpYtd() {
		return expYtd;
	}

	public void setExpYtd(BigDecimal expYtd) {
		this.expYtd = expYtd;
	}

	public String getExpNotes() {
		return expNotes;
	}

	public void setExpNotes(String expNotes) {
		this.expNotes = expNotes;
	}

	@Override
	public String toString() {
		return "LtcYtdExp [id=" + id + ", confirmationId=" + confirmationId + ", expType=" + expType + ", expName=" + expName + ", expYtd=" + expYtd + ", expNotes=" + expNotes + "]";
	}

}
