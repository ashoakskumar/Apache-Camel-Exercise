package com.ashok.example;


import org.apache.activemq.ActiveMQConnection;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;

@SpringBootApplication
public class CamelActiveMqApplication{

//	@Autowired
//	private JmsTemplate jmsTemplate;
//	@Autowired
//	private Queue queue;
	public static void main(String[] args) {
		SpringApplication.run(CamelActiveMqApplication.class, args);
	}
	static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	  static String subject = "Test-AMQ";
	public void run(String... args) throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		/*
		 * Object obj = new String("Hello ActiveMQ"); jmsTemplate.convertAndSend(queue,
		 * obj);
		 */
		
		/*
		 * ConnectionFactory connectionFactory = connectionFactory();
		 * camelContext.addComponent("jms",
		 * JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		 */
		CamelContext context = new DefaultCamelContext();
	   // ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
	  //  connectionFactory.createConnection("admin", "admin");
	  //  context.addComponent("jms", JmsComponent.jmsComponentClientAcknowledge(connectionFactory));
	    context.addRoutes(
	        new RouteBuilder() {
	          public void configure() {
	            from("timer:foo?period=1s")
	                .setBody(simple("Message at ${date:now:yyyy-MM-dd HH:mm:ss}"))
	                .to("jms:queue:my_queue");
	          }
	        });
	    context.start();
	    Thread.sleep(10000);
	    context.stop();
		 
		
//		ActiveMQComponent comp = ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false");
//		camelContext.addComponent("jms",comp); 
//		 ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
//	        ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
//		 ActiveMQComponent comp = ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false");
//		 ctx.addComponent("jms",comp); 
//	        try {
//	        	  ctx.addRoutes(new RouteBuilder() {
//	      			
//	      			@Override
//	      			public void configure() throws Exception {
//	      				from("file:D:\\resources\\src?noop=true").to("jms:queue:my_queue");
//	      			}
//	      		});
//	            ctx.start();
//	            Thread.sleep(5 * 60 * 1000);
//	            ctx.stop();
		
	//	  camelContext.start();
		/*  ctx.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file:D:\\resources\\src?noop=true").to("activemq:queue:my_queue");
			}
		});*/
	//	camelContext.close();
//	        }
//	        catch (Exception e) {
//	            e.printStackTrace();
//	        }
	}
	String BROKER_URL = "tcp://localhost:61616"; 
	String BROKER_USERNAME = "admin"; 
	String BROKER_PASSWORD = "admin";
	
	/*
	 * @Bean public ActiveMQConnectionFactory connectionFactory(){
	 * ActiveMQConnectionFactory connectionFactory = new
	 * ActiveMQConnectionFactory(); connectionFactory.setBrokerURL(BROKER_URL);
	 * connectionFactory.setPassword(BROKER_USERNAME);
	 * connectionFactory.setUserName(BROKER_PASSWORD); return connectionFactory; }
	 * 
	 * @Bean public JmsTemplate jmsTemplate(){ JmsTemplate template = new
	 * JmsTemplate(); template.setConnectionFactory(connectionFactory()); return
	 * template; }
	 * 
	 * @Bean public DefaultJmsListenerContainerFactory jmsListenerContainerFactory()
	 * { DefaultJmsListenerContainerFactory factory = new
	 * DefaultJmsListenerContainerFactory();
	 * factory.setConnectionFactory(connectionFactory());
	 * factory.setConcurrency("1-1"); return factory; }
	 */
}
