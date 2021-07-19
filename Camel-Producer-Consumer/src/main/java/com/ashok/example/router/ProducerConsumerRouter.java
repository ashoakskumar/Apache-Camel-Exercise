package com.ashok.example.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class ProducerConsumerRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:start").to("seda:end");
	}

}
