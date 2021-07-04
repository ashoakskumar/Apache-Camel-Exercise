package com.ashok.example.router;

import org.apache.camel.builder.RouteBuilder;

public class MyDataRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:D:\\resources\\src").to("file:D:\\resources\\dest");
	}

	

}
