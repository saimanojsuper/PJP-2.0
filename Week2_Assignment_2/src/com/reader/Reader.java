package com.reader;

import java.util.List;

import com.POJO.TransactionPOJO;

public interface Reader {
	
	public List<TransactionPOJO> read(String filePath);

}
