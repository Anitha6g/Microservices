package com.enricher.enricherreader.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.DateValidator;
import org.apache.commons.validator.GenericValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.enricher.enricherreader.dto.CollisionDTO;
import com.enricher.enricherreader.dto.LocationDTO;
import com.enricher.enricherreader.dto.TripDataDTO;
import com.enricher.enricherreader.utility.CarshFilterUtility;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

@Component
@EnableJms
public class TripDetailsConsumer {
	
	static final Logger logger = Logger.getLogger(TripDetailsConsumer.class);

	public static List<LocationDTO> alpha;
	public static List<CollisionDTO> collision;

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

//	@PostConstruct
//	public void crashLookup() throws IOException{
//		File file = new File("C:/Users/data/collision.csv");
//		InputStream inputStream = new FileInputStream(file);
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));;
////		String line;
////		collision = new ArrayList<CollisionDTO>();
////		int itr = 0;
////		CollisionDTO collsioDto = new CollisionDTO();
////		DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
////		while ((line = bufferedReader.readLine()) != null) {
////			if(itr != 0) {
////			String[] collisionData = line.toString().split(",");
////			if(GenericValidator.isDate(collisionData[0], "MM/dd/yyyy", false)) {
////			collsioDto.setCrashDate(LocalDate.parse((collisionData[0]), df));
////			collsioDto.setCrashTime(collisionData[1]);
////			collsioDto.setBorough(collisionData[2]);
////			collsioDto.setLocation(collisionData[6]);
////			collsioDto.setStreetName(collisionData[7]);
////
////
////			collision.add(collsioDto);
////			}
////			}
////			itr++;
////		}
////logger.info(collision);
////		bufferedReader.close();
//		List<CollisionDTO> collisionList = new ArrayList<CollisionDTO>();
//		collisionList = bufferedReader.lines().skip(1).map(line ->{
//			String[] collisionData = line.split(",");
//			CollisionDTO collsioDto = new CollisionDTO();
//			if(GenericValidator.isDate(collisionData[0], "MM/dd/yyyy", false)) {
//				
//				DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//				collsioDto.setCrashDate(LocalDate.parse((collisionData[0]), df));
//				collsioDto.setCrashTime(collisionData[1]);
//				collsioDto.setBorough(collisionData[2]);
//				collsioDto.setLocation(collisionData[6]);
//				collsioDto.setStreetName(collisionData[7]);
//			}
//			return collsioDto;
//		}
//		
//				).collect(Collectors.toList());
//		logger.info(collisionList);
//	}
}
