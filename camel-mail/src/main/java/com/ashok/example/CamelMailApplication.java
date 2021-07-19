package com.ashok.example;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashok.example.route.MailRoutConfig;

@SpringBootApplication
public class CamelMailApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CamelMailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new MailRoutConfig());
		context.start();
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put("To", "mail2ashokid@gmail.com");
		headers.put("From", "ashok.glitz@gmail.com");
		headers.put("Subject", "Its therel");
		ProducerTemplate template = context.createProducerTemplate();
		template.sendBodyAndHeaders("direct:start", "Test mail to many user of Apache", headers);

		// stop the CamelContext
		
		context.stop();
	}
	
}
