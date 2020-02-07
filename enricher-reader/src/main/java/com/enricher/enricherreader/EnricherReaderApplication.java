package com.enricher.enricherreader;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EnricherReaderApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(EnricherReaderApplication.class, args);
	}

}
