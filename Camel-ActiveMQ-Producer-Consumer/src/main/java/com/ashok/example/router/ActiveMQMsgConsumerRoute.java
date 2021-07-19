package com.ashok.example.router;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class ActiveMQMsgConsumerRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("activemq:my-activemq-queue").to("log:received-message-from-active-mq").process( new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				Message input  = exchange.getIn();
				String data = input.getBody(String.class);
				System.out.println("Processor: "+ data);
			}
		});
	}

}
