package ca.bc.gov.hlth.medis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MedisDataLoaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedisDataLoaderApplication.class, args);
	}

}
