package com.ashok.example;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashok.example.router.DoTryRouter;
import com.ashok.example.router.OnExceptionRouter;

@SpringBootApplication
public class CamelBasicComponentApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CamelBasicComponentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Direct & seda
		/*
		 * CamelContext context = new DefaultCamelContext(); context.addRoutes(new
		 * RouteBuilder() {
		 * 
		 * @Override public void configure() throws Exception {
		 * from("direct:start").to("seda:end"); } }); context.start(); ProducerTemplate
		 * pTemp = context.createProducerTemplate();
		 * pTemp.sendBody("direct:start","Hello Camel"); ConsumerTemplate cTemp =
		 * context.createConsumerTemplate(); String msg =
		 * cTemp.receiveBody("seda:end",String.class); System.out.println("Msg:" +msg);
		 * context.stop();
		 */
		
		//CLass
		/*
		 * CamelContext classContext = new DefaultCamelContext();
		 * classContext.addRoutes(new RouteBuilder() {
		 * 
		 * @Override public void configure() throws Exception { from("direct:start").to(
		 * "class:com.ashok.example.service.MyService?method=setMessage"); } });
		 * classContext.start(); ProducerTemplate pTemp =
		 * classContext.createProducerTemplate();
		 * pTemp.sendBody("direct:start","Hello Camel from class"); classContext.stop();
		 */
		
		//Bean
		/*
		 * MyService service = new MyService(); DefaultRegistry simpleRegistry = new
		 * DefaultRegistry(); simpleRegistry.bind("service", service);
		 * 
		 * CamelContext context = new DefaultCamelContext(simpleRegistry);
		 * context.addRoutes(new RouteBuilder() {
		 * 
		 * @Override public void configure() throws Exception {
		 * from("direct:start").to("bean:service?method=setMessage").to("mock:out"); }
		 * }); context.start(); ProducerTemplate pTemp =
		 * context.createProducerTemplate(); MockEndpoint resultEndpoint =
		 * context.getEndpoint("mock:out", MockEndpoint.class);
		 * resultEndpoint.expectedMessageCount(1);
		 * resultEndpoint.expectedBodiesReceived("Hello Camel		 from Bean");
		 * pTemp.sendBody("direct:start","Hello Camel from Bean");
		 * System.out.println("Message received: " +
		 * resultEndpoint.getExchanges().get(0).getIn().getBody());
		 * resultEndpoint.assertIsSatisfied(); context.close();
		 */
		
		//UnMarshalling
		CamelContext context = new DefaultCamelContext();
	//	context.addRoutes(new EmployeeRouter());
	//	context.addRoutes(new EmployeeJsonToXmlRouter());
	//	context.addRoutes(new EmployeeCsvRouter());
	//	context.addRoutes(new SchemaValidationRouter());
//		context.addRoutes(new ErrorRouter());
		//context.addRoutes(new DoTryRouter());
		context.addRoutes(new OnExceptionRouter());
		context.start();
           Thread.sleep(5 * 60 * 1000);
           context.stop();
	}

}
