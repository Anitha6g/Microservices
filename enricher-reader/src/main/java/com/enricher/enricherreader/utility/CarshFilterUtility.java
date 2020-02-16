package com.enricher.enricherreader.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.MappingStrategy;

@Component
public class CarshFilterUtility implements CsvToBeanFilter{

	@Override
	public boolean allowLine(String[] arg0) {
		// TODO Auto-generated method stub
		return false;
	}
//
//	 	
//	@Override
//	public boolean allowLine(String[] line){
//		Date date = null;
//		Date startDate = null;
//		Date endDate = null;
//		try {
//			date = new SimpleDateFormat("mm/dd/yyyy").parse(line[0]);
//			startDate = new Date("31/12/2017");
//			endDate = new Date("1/2/2018");
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		 return date.after(startDate) && date.before(endDate);
//	}
//	
//	
//	}

}
