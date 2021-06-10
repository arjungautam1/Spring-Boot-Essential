/**
 * @author Arjun Gautam
 * Project :Spring-Boot-Essential
 * Date : 2021-06-04
 */
package com.thymeleaf.roomwebapp.config;

import com.rabbitmq.client.ConnectionFactory;
import com.thymeleaf.roomwebapp.async.RoomCleanerListener;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

import java.util.Queue;

@Configuration
public class AsyncConfig {
    private static final String QUEUE_NAME="room-cleaner";
    private static final String EXCHANGE_NAME="operations";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME,false);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public BindingResult bindingResult(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("com.arjun.rooms");


    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RoomCleanerListener listener){
        return new MessageListenerAdapter(listener,"receiveMessage");
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,MessageListenerAdapter messageListenerAdapter){
        SimpleMessageListenerContainer container=new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter());
        return container;

    }

}
