package com.ashok.example;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashok.example.router.ProducerConsumerRouter;

@SpringBootApplication
public class CamelProducerConsumerApplication implements CommandLineRunner{
	@Autowired
	ProducerConsumerRouter builder;
	public static void main(String[] args) {
		SpringApplication.run(CamelProducerConsumerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.start();
		camelContext.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				 restConfiguration().host("//localhost").port(9090);
				from("timer:rest-client?period=10s")
				                .to("rest:get:/getOrders")
				                .log("${body}");
			}
				
		});
		
	}

//	@Override
//	public void run(String... args) throws Exception {
//		CamelContext camelContext = new DefaultCamelContext();
//		camelContext.addRoutes(builder);
//		camelContext.start();
//		ProducerTemplate template = camelContext.createProducerTemplate();
//		template.sendBody("direct:start","Hello EveryOne");
//		
//		ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate();
//		String msg = consumerTemplate.receiveBody("seda:end",String.class);
//		System.out.println("MSG:" + msg);
//		camelContext.close();
//	}
	/*
	 * @Override public void run(String... args) throws Exception { CamelContext
	 * camelContext = new DefaultCamelContext(); camelContext.addRoutes(new
	 * RouteBuilder() {
	 * 
	 * @Override public void configure() throws Exception { from("direct:start").to(
	 * "class:com.ashok.example.service.MyService?method=doSomething"); } });
	 * camelContext.start(); ProducerTemplate producerTemplate =
	 * camelContext.createProducerTemplate();
	 * producerTemplate.sendBody("direct:start","Hello"); camelContext.close();
	 * 
	 * }
	 */
	
}
