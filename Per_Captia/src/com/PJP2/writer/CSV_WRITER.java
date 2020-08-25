package com.PJP2.writer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class CSV_WRITER implements Writer{

	@Override
	public Map<String, BigDecimal> write(Map<String, BigDecimal> countryOrCityMapToGender, String writePath) {
			BufferedWriter bw = null;
			
			try {
				bw = new BufferedWriter(new FileWriter(writePath));
				String message="City/Country Gender Average Income(in USD)";
				bw.write(message);
				bw.newLine();
				for(Map.Entry<String,BigDecimal> map:countryOrCityMapToGender.entrySet())
				   {
					writeToFile(bw, map,",");
				   }
				
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: File not found " );
			}
			catch ( IOException e) {			
				e.printStackTrace();
				try {
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return countryOrCityMapToGender;
	}

	private static void writeToFile(BufferedWriter bw,
			Map.Entry<String, BigDecimal> map,String fileType) throws IOException {
		
		String key=map.getKey();
		BigDecimal value=map.getValue();
		String countryGen[]=key.split(",");
		String recard=countryGen[0]+" "+countryGen[1]+" "+value;
		
		System.out.println(recard);
		
		if(fileType.equals(","))
		{
			bw.write(key+","+value);	

		}
		else{
			bw.write(recard);
		}
		bw.newLine();
	}
}

