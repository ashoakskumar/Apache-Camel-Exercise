package com.ashok.example.processor;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.ashok.example.model.EmployeeCsv;

public class EmployeeCsvProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		@SuppressWarnings("unchecked")
		EmployeeCsv object = (EmployeeCsv) exchange.getIn().getBody();
		System.out.println("CSV: " + object.getEmpId()+", "+ object.getEmpName());
	//	 ArrayList<HashMap<String, Object>> rowList = (ArrayList<HashMap<String, Object>>) object;
//		List<Map<String,Object>> rowList= (List<Map<String, Object>>) exchange.getIn().getBody();
			/*
			 * for (HashMap<String, Object> map :rowList) { for (String key : map.keySet())
			 * { System.out.println("key : " + key); EmployeeCsv csv = (EmployeeCsv)
			 * map.get(key); System.out.println("value : " + csv); } }
			 */
	}

}
