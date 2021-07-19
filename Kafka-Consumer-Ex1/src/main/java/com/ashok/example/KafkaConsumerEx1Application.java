package com.ashok.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaConsumerEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerEx1Application.class, args);
	}
	List<String> messages = new ArrayList<>();
	
	@GetMapping("/consumeStringMsg")
	public List<String> consumeMsg() {
		return messages;
	}
	@KafkaListener(groupId = "kafkaLearningGroup-1",  topics = "kafkalearning", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMsgFromTopics(String data){
		messages.add(data);
		return messages;
	}
}
