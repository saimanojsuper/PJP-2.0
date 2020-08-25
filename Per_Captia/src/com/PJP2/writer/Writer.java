package com.PJP2.writer;

import java.math.BigDecimal;
import java.util.Map;

public interface Writer {
	

	public Map<String, BigDecimal> write(Map<String, BigDecimal> countryOrCityMapToGender,String writePath);

}

