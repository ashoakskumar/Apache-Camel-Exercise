package com.ashok.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.model.User;

@SpringBootApplication
@RestController
public class KafkaPublisherEx1Application {

	@Autowired
	private KafkaTemplate<String, Object> template;
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherEx1Application.class, args);
	}
	
	@GetMapping("/publish/{name}")
	public String publishMsg(@PathVariable String name) {
		template.send("kafkalearning","Hi "+name+" Welcome to Kafka learning");
		return "Data published to topics - kafkalearning";
	}
	
	@GetMapping("/publishJson")
	public String publishMsg() {
		template.send("kafkalearning", new User(2222, "Ashok User", new String[] {"Chennai","TN","600032"}));
		return "Json data published";
	}
}
