package com.ashok.example.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //generates an event/constant message every 60 seconds
        from("timer:active-mq-timer?period=60000")
                .transform().constant("Hello Message from Apache Camel - TechGeekNext")
                .log("${body}")
                //send this message to ActiveMQ queue
                .to("activemq:my-activemq-queue");
    }
}
