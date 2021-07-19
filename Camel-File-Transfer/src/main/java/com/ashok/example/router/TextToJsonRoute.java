package com.ashok.example.router;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TextToJsonRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:D:\\resources\\src?noop=true")
		.process(new Processor () {
			@Override
			public void process(Exchange exchange) throws Exception {
				Message input  = exchange.getIn();
				String data = input.getBody(String.class);
				StringTokenizer str = new StringTokenizer(data,",");
				String eid = str.nextToken();
				String ename = str.nextToken();
				String esal = str.nextToken();
				
				String dataModified = "{eid:"+eid+",ename:"+ename+",esal:"+esal+"}";
				
				Message output= exchange.getMessage();
				output.setBody(dataModified);
			}
		})
		.to("file:D:\\resources\\dest?fileName=emp.json");
		
	}

}
