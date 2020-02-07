package com.filereader.service.filereader;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilereaderApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(FilereaderApplication.class, args);
		
	}

}
