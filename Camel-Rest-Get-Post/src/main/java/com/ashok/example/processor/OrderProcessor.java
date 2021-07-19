package com.ashok.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashok.example.dto.Order;
import com.ashok.example.service.OrderService;
@Component
public class OrderProcessor implements Processor{

	@Autowired
	OrderService service;
	@Override
	public void process(Exchange exchange) throws Exception {
		service.addOrder(exchange.getIn().getBody(Order.class));
	}

}
