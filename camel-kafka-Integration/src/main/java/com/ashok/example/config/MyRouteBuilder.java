package com.ashok.example.config;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.stereotype.Component;
@Component
public class MyRouteBuilder extends RouteBuilder{

	/*
	 * @Override public void configure() throws Exception { // Kafka Producer using
	 * Message key from(
	 * "file:D:\\sourcecode\\java\\Exercising-Apache-Camel\\camel-kafka-Integration\\src\\data?noop=true")
	 * .process(new Processor() { public void process(Exchange exchange) throws
	 * Exception { System.out.println("Message Body : " +
	 * exchange.getIn().getBody()); } }) .setHeader(KafkaConstants.KEY,
	 * constant("Camel")) .to("kafka:kafkalearning?brokers=localhost:9092");
	 * 
	 * // Kafka Consumer from("kafka:kafkalearning?brokers=localhost:9092")
	 * .log("Message received from Kafka : ${body}")
	 * .log("    on the topic ${headers[kafka.TOPIC]}")
	 * .log("    on the partition ${headers[kafka.PARTITION]}")
	 * .log("    with the offset ${headers[kafka.OFFSET]}")
	 * .log("    with the key ${headers[kafka.KEY]}"); }
	 */

	/*
	 * @Override public void configure() throws Exception {
	 * 
	 * from(
	 * "kafka:{{kafka.topic}}?brokers={{kafka.server}}:{{kafka.port}}&groupId={{kafka.channel}}&autoOffsetReset=earliest")
	 * .process(new Processor() { public void process(Exchange exchange) throws
	 * Exception { System.out.println("Message Body : " +
	 * exchange.getIn().getBody()); } });
	 * 
	 * }
	 */
	 @Override
	     public void configure() throws Exception {
	         from("file:files/input")
	                 .to("kafka:kafkalearning");
	     }
}
