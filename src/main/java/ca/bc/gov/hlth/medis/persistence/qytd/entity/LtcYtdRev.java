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
public class LtcYtdRev extends BaseEntity{

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

	public String getRevType() {
		return revType;
	}

	public void setRevType(String revType) {
		this.revType = revType;
	}

	public String getRevName() {
		return revName;
	}

	public void setRevName(String revName) {
		this.revName = revName;
	}

	public BigDecimal getRevYTD() {
		return revYTD;
	}

	public void setRevYTD(BigDecimal revYTD) {
		this.revYTD = revYTD;
	}

	public String getRevNotes() {
		return revNotes;
	}

	public void setRevNotes(String revNotes) {
		this.revNotes = revNotes;
	}

	@Override
	public String toString() {
		return "LtcYtdRev [id=" + id + ", confirmationId=" + confirmationId + ", revType=" + revType + ", revName=" + revName + ", revYTD=" + revYTD + ", revNotes=" + revNotes + "]";
	}

}
