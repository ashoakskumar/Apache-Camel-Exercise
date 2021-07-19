package com.ashok.example.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.ashok.example.model.EmployeeCsv;
import com.ashok.example.processor.EmployeeCsvProcessor;

public class EmployeeCsvRouter extends RouteBuilder{

		@Override
	public void configure() throws Exception {
		final DataFormat bindy = new BindyCsvDataFormat(EmployeeCsv.class);	
		from("file:CsvFolder").unmarshal(bindy).process(new EmployeeCsvProcessor());
//		.marshal(defination).to("file:XmlFolder?fileName=output.xml");
	}
	
}
