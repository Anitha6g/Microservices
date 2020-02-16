package com.filereader.service.filereader.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.jms.Queue;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.filereader.service.filereader.serviceinterface.IFileReaderService;

@Component
public class FileReaderService implements IFileReaderService {

	@Autowired
	private Queue queue;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendTripMessage(String fileName) {
//		File file = new File("src/main/resources/" + fileName);
//		InputStream inputStream;
//		BufferedReader bufferedReader;
		try {
//			inputStream = new FileInputStream(file);
//			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//			String line = bufferedReader.readLine();
			File file = new File("C:\\Users\\data\\taxitrip.csv");
			LineIterator line = FileUtils.lineIterator(file);
			
			while (line.hasNext()) {
				convertAndSend(line.nextLine());
				//logger.info(line.nextLine());
				//jmsTemplate.convertAndSend(queue, line.nextLine());
				// line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Async
	private void convertAndSend(String input) {
		jmsTemplate.convertAndSend(queue, input);
	}

}
