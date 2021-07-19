package com.ashok.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.ashok.example.model.Employee;

public class EmployeeProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		Employee employee = exchange.getIn().getBody(Employee.class);
		employee.setEmpName("Ashok Json Rocks");
		exchange.getIn().setBody(employee);
	}

}
