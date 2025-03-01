package ca.bc.gov.hlth.medis.persistence.qytd.entity;

import java.util.Date;

import com.opencsv.bean.CsvBindByPosition;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity {
	
	@CsvBindByPosition(position = 0)
	@Column(name = "CONFIRMATION_ID")
	protected String confirmationId;
	
	@Column(name = "CREATE_USER")
	protected String createUser = "medis-data-loader";

	@Column(name = "CREATE_DATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createDateTime = new Date();

}
