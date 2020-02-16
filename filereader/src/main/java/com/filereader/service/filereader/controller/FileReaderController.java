package com.filereader.service.filereader.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filereader.service.filereader.serviceinterface.IFileReaderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fileRead")
@Slf4j
public class FileReaderController {

	@Autowired
	private IFileReaderService fileReaderService;

	@GetMapping("/tripData")
	public ResponseEntity<String> publishTripData() throws IOException {
		fileReaderService.sendTripMessage("yellow_tripdata_2018-01.csv");
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
