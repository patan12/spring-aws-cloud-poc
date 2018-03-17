package com.example.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Processor.class)
@RestController
public class AwsApplication {

	@Autowired
	Processor processor;

	public static void main(String[] args) {
		SpringApplication.run(AwsApplication.class, args);
	}

	@StreamListener(Processor.INPUT)
	public void receive(Message<String> message) {
		System.out.println("Message recieved: " + message);
		System.out.println("Message Payload: " + message.getPayload());
	}

}
