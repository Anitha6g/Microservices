package com.enricher.enricherreader.service;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.enricher.enricherreader.dto.LocationDTO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
@EnableJms
public class TripDetailsConsumer {

	static final Logger logger = Logger.getLogger(TripDetailsConsumer.class);

	public static List<LocationDTO> alpha;

	@JmsListener(destination = "trip-queue")
	public void tripListener(String message) {
		logger.info("Message received"+message);
	}

	@PostConstruct
	@Cacheable
	public void test() {
		alpha = new ArrayList<LocationDTO>();
		File file = new File("C:/Users/data/locatiolookup.csv");
		String absolutePath = file.getAbsolutePath();
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get(absolutePath));
			CsvToBean<LocationDTO> tripDataToBean = new CsvToBeanBuilder<LocationDTO>(reader)
					.withType(LocationDTO.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			alpha = tripDataToBean.parse();
			logger.info(alpha);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
