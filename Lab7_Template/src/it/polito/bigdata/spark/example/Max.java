package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.Function2;

public class Max implements Function2<timeDateCri, timeDateCri, timeDateCri> {

	@Override
	public timeDateCri call(timeDateCri arg0, timeDateCri arg1) throws Exception {
		
		if (arg0.getCri() > arg1.getCri() || 
			 (arg0.getCri() == arg1.getCri() && arg0.getTime() < arg1.getTime())||
			 (arg0.getCri() == arg1.getCri() && arg0.getTime() == arg1.getTime() &&
			  arg0.getDate().compareTo( arg0.getDate() ) < 0) )
			return new timeDateCri(arg0.getTime(), arg0.getDate(), arg0.getCri());
		return new timeDateCri(arg1.getTime(), arg1.getDate(), arg1.getCri());
	}

}
