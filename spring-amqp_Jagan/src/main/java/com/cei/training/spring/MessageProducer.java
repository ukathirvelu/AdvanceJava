package com.cei.training.spring;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
	
	@Value("${spring.rabbitmq.queue}")
	private String myQueue;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Scheduled(fixedDelay = 20000L)
	public void run() throws Exception {
		System.out.println("Sending message @ " + LocalDateTime.now());
		rabbitTemplate.convertAndSend(myQueue, "message--" + new Random().nextInt(10));
	}

}
