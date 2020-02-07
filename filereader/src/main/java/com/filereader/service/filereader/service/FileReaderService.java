package com.filereader.service.filereader.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.jms.Queue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.filereader.service.filereader.serviceinterface.IFileReaderService;

@Component
public class FileReaderService implements IFileReaderService{
	
	static final Logger logger = Logger.getLogger(IFileReaderService.class);
	
	@Autowired
	private Queue queue;
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendTripMessage(String fileName) {
		File file = new File("src/main/resources/"+fileName);
		InputStream inputStream;
		BufferedReader bufferedReader;
		try {
			inputStream = new FileInputStream(file);
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line = bufferedReader.readLine();
			while(line != null) {
				logger.info(line);
				jmsTemplate.convertAndSend(queue, line);
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		
	}
	
}
