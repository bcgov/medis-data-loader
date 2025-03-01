package ca.bc.gov.hlth.medis.batch;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfiguration {
	
	@BatchDataSource
	@Bean
	@ConfigurationProperties("h2.datasource")
	public DataSource H2Datasource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase = builder
				// .addScript("classpath:org/springframework/batch/core/schema-drop h2.sql")
				// .addScript("classpath:org/springframework/batch/core/schema-h2.sql")
				.setType(EmbeddedDatabaseType.H2).build();
		return embeddedDatabase;
	}

	@Bean(name = "oracleDataSourceProperties")
	//@ConfigurationProperties(prefix = "spring.datasource")
	public DataSourceProperties oracleDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	//@ConfigurationProperties("datasource")
	@Primary
	public DataSource oraclDataSource(DataSourceProperties oracleDataSourceProperties) {
		return oracleDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();

	}

}
