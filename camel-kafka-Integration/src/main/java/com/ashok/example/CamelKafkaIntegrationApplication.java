package com.ashok.example;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashok.example.config.MyRouteBuilder;

@SpringBootApplication
public class CamelKafkaIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelKafkaIntegrationApplication.class, args);
	}

	public void run(String... args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new MyRouteBuilder());
		context.start();
	}

}
