package com.filereader.service.filereader.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.filereader.service.filereader.dto.TripDataDTO;

public class CommonUtility {

	public static List<TripDataDTO> readCsvbyRow(String fileName){

		File file = new File("src/main/resources/"+fileName);
		//		String absolutePath = file.getAbsolutePath();
		//		Reader reader = Files.newBufferedReader(Paths.get(absolutePath));
		//		
		//		CsvToBean<TripDataDTO> tripDataToBean = new CsvToBeanBuilder<TripDataDTO>(reader)
		//				.withType(TripDataDTO.class)
		//				.withIgnoreLeadingWhiteSpace(true)
		//				.build();
		//		List<TripDataDTO> tripList = tripDataToBean.parse();
		//		return tripList;

		List<TripDataDTO> tripList = null;
		try {
			tripList = new ArrayList<TripDataDTO>();
			InputStream inputStream = new FileInputStream(file);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			tripList = bufferedReader.lines().skip(2).map(x -> {
				String[] p = x.split(",");
				TripDataDTO tripDataDTO = new TripDataDTO();
				tripDataDTO.setVendorID(Integer.parseInt(p[0]));
				tripDataDTO.setTpep_pickup_datetime(p[1]);
				tripDataDTO.setTpep_dropoff_datetime(p[2]);
				tripDataDTO.setPassenger_count(Integer.parseInt(p[3]));
				tripDataDTO.setTrip_distance(Double.parseDouble(p[4]));
				tripDataDTO.setRatecodeID(Integer.parseInt(p[5]));
				tripDataDTO.setStore_and_fwd_flag(p[6]);
				tripDataDTO.setPULocationID(Integer.parseInt(p[7]));
				tripDataDTO.setDOLocationID(Integer.parseInt(p[8]));
				tripDataDTO.setPayment_type(Integer.parseInt(p[9]));
				tripDataDTO.setFare_amount(Double.parseDouble(p[10]));
				tripDataDTO.setExtra(Double.parseDouble(p[11]));
				tripDataDTO.setMta_tax(Double.parseDouble(p[12]));
				tripDataDTO.setTip_amount(Double.parseDouble(p[13]));
				tripDataDTO.setTolls_amount(Double.parseDouble(p[14]));
				tripDataDTO.setImprovement_surcharge(Double.parseDouble(p[15]));
				tripDataDTO.setTotal_amount(Double.parseDouble(p[16]));
				System.out.println(tripDataDTO);
				return tripDataDTO;
			}).collect(Collectors.toList());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return tripList;



	}


	public static TripDataDTO tripDTOGenerator(String tripDetails) {

		String[] p = tripDetails.split(",");
		TripDataDTO tripDataDTO = new TripDataDTO();
		tripDataDTO.setVendorID(Integer.parseInt(p[0]));
		tripDataDTO.setTpep_pickup_datetime(p[1]);
		tripDataDTO.setTpep_dropoff_datetime(p[2]);
		tripDataDTO.setPassenger_count(Integer.parseInt(p[3]));
		tripDataDTO.setTrip_distance(Double.parseDouble(p[4]));
		tripDataDTO.setRatecodeID(Integer.parseInt(p[5]));
		tripDataDTO.setStore_and_fwd_flag(p[6]);
		tripDataDTO.setPULocationID(Integer.parseInt(p[7]));
		tripDataDTO.setDOLocationID(Integer.parseInt(p[8]));
		tripDataDTO.setPayment_type(Integer.parseInt(p[9]));
		tripDataDTO.setFare_amount(Double.parseDouble(p[10]));
		tripDataDTO.setExtra(Double.parseDouble(p[11]));
		tripDataDTO.setMta_tax(Double.parseDouble(p[12]));
		tripDataDTO.setTip_amount(Double.parseDouble(p[13]));
		tripDataDTO.setTolls_amount(Double.parseDouble(p[14]));
		tripDataDTO.setImprovement_surcharge(Double.parseDouble(p[15]));
		tripDataDTO.setTotal_amount(Double.parseDouble(p[16]));
		System.out.println(tripDataDTO);

		return tripDataDTO;

	}

}
