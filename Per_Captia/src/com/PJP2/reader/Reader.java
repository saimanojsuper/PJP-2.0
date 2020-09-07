package com.PJP2.reader;

import java.math.BigDecimal;
import java.util.Map;

public interface Reader {
	
	public Map<String,BigDecimal> read(String filePath) ;

}
