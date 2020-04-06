package com.cei.training.spring;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void receiveMessage(String message) {
		System.out.println("Message Received : " + message);
	}

}
