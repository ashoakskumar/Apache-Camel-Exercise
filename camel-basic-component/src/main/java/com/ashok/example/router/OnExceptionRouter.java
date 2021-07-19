package com.ashok.example.router;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.ashok.example.Exception.CustomException;
import com.ashok.example.processor.MyErrorProcessor;

public class OnExceptionRouter extends RouteBuilder{
	


	@Override
	public void configure() throws Exception {
		onException(CustomException.class).process(new Processor() {

	        public void process(Exchange exchange) throws Exception {
	            System.out.println("handling ex");
	        }
	    }).log("Received body ").handled(true);
		from("file:inputFolder?noop=true").process(new MyErrorProcessor()).to("file:outputFolder");
	}}
