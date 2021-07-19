package com.ashok.example.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class MailRoutConfig extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		/*from("file:inputFolder?noop=true").doTry().setHeader("subject", simple("JavaInUse Invitation111"))
		.setHeader("to", simple("mail2ashokid@gmail.com"))*/
		from("direct:start")
		.to("smtps://smtp.gmail.com:465?username=ashok.glitz@gmail.com&password=superstar");
	}

}
