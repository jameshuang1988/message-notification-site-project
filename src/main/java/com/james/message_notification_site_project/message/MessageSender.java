package com.james.message_notification_site_project.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    @Value("${myqueue.queue.name}")
    private String queueName;

    @Autowired
    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message){
        rabbitTemplate.convertAndSend(queueName, message);
    }
}

