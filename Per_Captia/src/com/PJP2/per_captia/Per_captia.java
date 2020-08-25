package com.PJP2.per_captia;



import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import com.PJP2.reader.CSVReader;
import com.PJP2.reader.Reader;

import com.PJP2.writer.CSV_WRITER;
import com.PJP2.writer.Writer;

public class Per_captia {
	
	public static void main(String[] args) throws IOException {
		
		Map<String,BigDecimal> countryOrCityMapToGender;
		
		String filePath ="C:\\Users\\HP\\Desktop\\pjp2.0\\week2\\Assignment\\PJP-2.0-Week2\\Per_Capita_Income\\sampleinput.csv";
		
		Reader reader = new CSVReader();
		countryOrCityMapToGender =reader.read(filePath);
		
		String writePath= "C:\\Users\\HP\\Desktop\\pjp2.0\\week2\\Assignment\\PJP-2.0-Week2\\Per_Capita_Income\\sampleoutput2.csv";
		
		Writer writer = new CSV_WRITER();
		writer.write(countryOrCityMapToGender,writePath);

	}


}
