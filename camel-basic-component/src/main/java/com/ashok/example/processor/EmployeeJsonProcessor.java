package com.ashok.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.ashok.example.model.EmployeeJson;
@Component
public class EmployeeJsonProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		EmployeeJson employee = exchange.getIn().getBody(EmployeeJson.class);
		employee.setEmpName("Ashok Json Rocks");
		exchange.getIn().setBody(employee);
	}

}
