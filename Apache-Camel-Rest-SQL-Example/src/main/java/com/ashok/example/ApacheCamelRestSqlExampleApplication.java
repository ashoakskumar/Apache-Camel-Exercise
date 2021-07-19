package com.ashok.example;

import org.apache.camel.opentracing.starter.CamelOpenTracing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@CamelOpenTracing
public class ApacheCamelRestSqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheCamelRestSqlExampleApplication.class, args);
	}

}
