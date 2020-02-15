package com.filereader.service.filereader.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filereader.service.filereader.serviceinterface.IFileReaderService;

@RestController
@RequestMapping("/fileRead")
public class FileReaderController {

	@Autowired
	private IFileReaderService fileReaderService;
  
	static final Logger log = Logger.getLogger(FileReaderController.class);
	
	@GetMapping("/tripData")
	public ResponseEntity<String> publishTripData() throws IOException {
		log.info("Start of File Load");
		fileReaderService.sendTripMessage("yellow_tripdata_2018-01.csv");
		log.info("End of File Load");
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@GetMapping("/collisionData")
	public ResponseEntity<String> publishCollisionData() {

		return null;
	}

	@GetMapping("/locationData")
	public ResponseEntity<String> publishLocationData() {

		return null;
	}

}
