package com.in28minutes.springboot.studentservices;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class CSVReader {
	private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\anith\\OneDrive\\Desktop\\Semester_2\\Research_topics_in_AI\\yellow_tripdata_2018-01.csv";

	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) throws IOException {
		try (
				Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
				) {
			System.out.println();
			@SuppressWarnings("unchecked")
			CsvToBean<CSVfile> csvToBean = new CsvToBeanBuilder(reader)
			.withType(CSVfile.class)
			.withIgnoreLeadingWhiteSpace(true)
			.build();

//Iterator<CSVfile> csvUserIterator = csvToBean.iterator();
//
//			while (csvUserIterator.hasNext()) {
//				CSVfile csvUser = csvUserIterator.next();
//				System.out.println("VendorID : " + csvUser.getVendorID());
//				System.out.println("trip distance"+ csvUser.getTrip_distance());
//				
//				if(csvUserIterator.equals(" ")) { 
//					break ;
//				}
//			}
			List<CSVfile> readList = csvToBean.parse();
			for(CSVfile csVfile : readList) {
				System.out.println("VendorID : " + csVfile.getVendorID());
				System.out.println("trip distance"+ csVfile.getTrip_distance());
						}
		}

	}
}


