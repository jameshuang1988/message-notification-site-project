package com.james.message_notification_site_project.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @RabbitListener(queues = "${myqueue.queue.name}")
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}

