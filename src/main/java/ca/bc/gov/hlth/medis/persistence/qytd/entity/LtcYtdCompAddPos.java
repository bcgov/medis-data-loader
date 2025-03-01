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
@Table(name = "LTCFIN_YTD_COMP_ADD_POS")
public class LtcYtdCompAddPos extends BaseEntity {

	@Id
	@Column(name = "LTCFYCAP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@CsvBindByPosition(position = 1)
	@Column(name = "ADD_POS_TYPE")
	private String addPosType;
	
	@CsvBindByPosition(position = 2)
	@Column(name = "ADD_POS_NAME")
	private String addPosName;
	
	@CsvBindByPosition(position = 3)
	@Column(name = "ADD_POS_CONTRACTED_OUT_YTD")
	private String addPosContractedOutYtd;
	
	@CsvBindByPosition(position = 4)
	@Column(name = "ADD_POS_LGL_NM_CON_SRV_YTD")
	private String addPosLegalNameContractServiceYtd;
	
	@CsvBindByPosition(position = 5)
	@Column(name = "ADD_POS_PCT_SRV_CON_OUT_YTD")
	private BigDecimal addPosPercentServiceContractOutYtd;
	
	@CsvBindByPosition(position = 6)
	@Column(name = "ADD_POS_OTHER_NAME")
	private String addPosAnotherName;
		
}
