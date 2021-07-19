package com.ashok.example.router;

import org.apache.camel.builder.RouteBuilder;

public class SchemaValidationRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:JsonFolder").convertBodyTo(String.class).log("${body}").to("json-validator:classpath:myschema.json")
        .to("seda:end");
	}

}
