package com.ashok.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.ashok.example.Exception.CustomException;

public class MyErrorProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("Exception thrown");
		throw new CustomException();
	}

	
}
