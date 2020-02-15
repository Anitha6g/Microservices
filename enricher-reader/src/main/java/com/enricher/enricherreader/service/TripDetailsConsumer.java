package com.enricher.enricherreader.service;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.enricher.enricherreader.dto.LocationDTO;
import com.enricher.enricherreader.dto.TripDataDTO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
@EnableJms
public class TripDetailsConsumer {

	static final Logger logger = Logger.getLogger(TripDetailsConsumer.class);

	public static List<LocationDTO> alpha;

	@JmsListener(destination = "trip-queue",concurrency = "1-50")
	public void tripListener(String message) {
		logger.info("Message received"+message);
		String[] tripfile = message.split(","); 
		TripDataDTO trip = new TripDataDTO();
		trip.setVedorId(Integer.parseInt(tripfile[0]));
		trip.setTpepPickupDatetime(tripfile[1]);
		trip.setTpepDropoffDatetime(tripfile[2]);
		trip.setPassengerCount(Integer.parseInt(tripfile[3]));
		trip.setTripDistance(Double.parseDouble(tripfile[4]));
		trip.setRatecodeID(Integer.parseInt(tripfile[5]));
		trip.setStoreFwdFlag(tripfile[6]);
		trip.setPuLocationID(Integer.parseInt(tripfile[7]));
		trip.setDoLocationID(Integer.parseInt(tripfile[8]));
		trip.setPaymentType(Integer.parseInt(tripfile[9]));
		trip.setFareAmount(Double.parseDouble(tripfile[10]));
		trip.setExtra(Double.parseDouble(tripfile[11]));
		trip.setMtaTax(Double.parseDouble(tripfile[12]));
		trip.setTipAmount(Double.parseDouble(tripfile[13]));
		trip.setTollsAmount(Double.parseDouble(tripfile[14]));
		trip.setImprovementSurcharge(Double.parseDouble(tripfile[15]));
		trip.setTotalAmount(Double.parseDouble(tripfile[16]));
	for(LocationDTO locationDTO: alpha) {
		if(locationDTO.getLocationID() == trip.getDoLocationID()) {
			trip.setBorough(locationDTO.getBorough());
			trip.setZone(locationDTO.getZone());
			
		}
	} 	
	}

	@PostConstruct
	@Cacheable
	public void locationLookup(){
		alpha = new ArrayList<LocationDTO>();
		File file = new File("C:/Users/data/locationlookup.csv");
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
