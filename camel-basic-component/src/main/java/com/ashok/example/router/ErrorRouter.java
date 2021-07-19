package com.ashok.example.router;

import org.apache.camel.builder.RouteBuilder;

import com.ashok.example.processor.MyErrorProcessor;

public class ErrorRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:inputFolder?noop=true").process(new MyErrorProcessor()).to("file:outputFolder");
	}

}
