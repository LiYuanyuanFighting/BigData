package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.Function;

public class preProcessing implements Function<String, Boolean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Boolean call(String line) throws Exception {
		
		if (line.startsWith("s"))
			return false;
		else {
			String[] fields = line.split("\\t");
			int usedNum = Integer.parseInt(fields[2]);
			int freeNum = Integer.parseInt(fields[3]);
			if (usedNum==0 && freeNum==0)
				return false;
			return true;
		}
	}

}
