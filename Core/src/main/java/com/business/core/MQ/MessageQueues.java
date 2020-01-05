package com.business.core.MQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueues {
    @Bean
    public TopicExchange getBusinessTireTopic() {
        return new TopicExchange("com.business.business-tire");
    }

    @Bean
    public Queue getBusinessTireQueue() {
        return new Queue("com.business.business-tire");
    }

    @Bean
    public Binding getBusinessTireBinding() {
        return BindingBuilder.bind(getBusinessTireQueue()).to(getBusinessTireTopic()).with("com.business.business-tire");
    }

}
