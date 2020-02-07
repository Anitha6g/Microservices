package com.filereader.service.filereader.controller;

import java.io.IOException;
import java.util.List;

import javax.jms.Queue;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filereader.service.filereader.dto.TripDataDTO;
import com.filereader.service.filereader.service.FileReaderService;
import com.filereader.service.filereader.serviceinterface.IFileReaderService;
import com.filereader.service.filereader.utility.CommonUtility;
import com.thoughtworks.xstream.XStream;

@RestController
@RequestMapping("/fileRead")
public class FileReaderController {
	
	static final Logger logger = Logger.getLogger(FileReaderController.class);
//	@Autowired
//	private Queue queue;
//	
//	@Autowired
//	private JmsTemplate jmsTemplate;
//	
	@Autowired
	private IFileReaderService fileReaderService; 
	
	@GetMapping("/tripData")
	public ResponseEntity<String> publishTripData() throws IOException{
			//logger.info("Inside Try block");
//		 XStream xstream = new XStream();
//		 List<TripDataDTO> tripList = CommonUtility.readCsvbyRow("yellow_tripdata_2018-01.csv");
//			for(TripDataDTO tripDataDTO : tripList) {
//				String message = xstream.toXML(tripDataDTO);
//				jmsTemplate.convertAndSend(queue, message);
//			System.out.println("Inside Loop");
//			}
		logger.info("Preparing to Read File");
		fileReaderService.sendTripMessage("yellow_tripdata_2018-01.csv");
			return new ResponseEntity<String>("Success", HttpStatus.OK);	
	}

	@GetMapping("/collisionData")
	public ResponseEntity<String> publishCollisionData(){


		return null;

	}

	@GetMapping("/locationData")
	public ResponseEntity<String> publishLocationData(){


		return null;

	}
	
}
