package com.ashok.example.router;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.ashok.example.Exception.CustomException;
import com.ashok.example.processor.MyErrorProcessor;

public class DoTryRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:inputFolder?noop=true").doTry().process(new MyErrorProcessor())
		.doCatch(CustomException.class).process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        })
		.to("file:outputFolder");
	}

}
