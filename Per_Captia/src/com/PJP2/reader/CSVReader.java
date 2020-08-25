package com.PJP2.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CSVReader implements Reader {

	@Override
	public  Map<String,BigDecimal> read(String filePath)  {
		Map<String,BigDecimal> countryOrCityMapToGender=new HashMap<String,BigDecimal>();
		BufferedReader br;
		
		
		
		 try {
			br = new BufferedReader(new FileReader(filePath));
			System.out.println(br.readLine());
			String data="";
			while((data=br.readLine()) != null){
				String[] s = data.split(",");
				String city=s[0];
				String country=s[1];
				String gender=s[2];
				String currency=s[3];
				
				BigDecimal convertedAverageIncome =averageIncome(currency,new BigDecimal(s[4]));
				
				
				if(country.equals(" "))
				{
                  if(countryOrCityMapToGender.containsKey(city+","+gender))
			    	  {
			    		BigDecimal avg=countryOrCityMapToGender.get(city+","+gender);
			    		avg=avg.add(convertedAverageIncome);
			    		countryOrCityMapToGender.put(city+","+gender,avg);
			    	  }
			    	else{
			    		countryOrCityMapToGender.put(city+","+gender,convertedAverageIncome);
			    	 }
				}
			    else{
			    	if(countryOrCityMapToGender.containsKey(country+","+gender))
			    	  {
			    		BigDecimal avg=countryOrCityMapToGender.get(country+","+gender);
			    		avg=avg.add(convertedAverageIncome);
			    		countryOrCityMapToGender.put(country+","+gender,avg);
			    	  }
			    	else{
			    		countryOrCityMapToGender.put(country+","+gender,convertedAverageIncome);
			    	 }
				
			}
		
		}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
        return countryOrCityMapToGender;
	}
	
	public static BigDecimal averageIncome(String currency,
			BigDecimal averageIncome) {
		 switch (currency) 
	        { 
	        case "INR": 
	        	averageIncome= averageIncome.divide(new BigDecimal(66),2, RoundingMode.HALF_UP); 
	        	return averageIncome;
	        case "GBP": 
	        	averageIncome= averageIncome.divide(new BigDecimal(0.67),2, RoundingMode.HALF_UP); 
	        	return averageIncome;
	        case "SGP": 
	        	averageIncome= averageIncome.divide(new BigDecimal(1.5),2, RoundingMode.HALF_UP); 
	        	return averageIncome;
	        case "HKD": 
	        	averageIncome= averageIncome.divide(new BigDecimal(8),2, RoundingMode.HALF_UP); 
	        	return averageIncome;
	        default: 
	            return averageIncome;
	            
	        } 
		
	}
	

}
