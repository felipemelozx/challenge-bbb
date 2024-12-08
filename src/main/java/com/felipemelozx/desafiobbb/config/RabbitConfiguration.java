package com.felipemelozx.desafiobbb.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

  public static final String EXCHANGE_COMPUTE_VOTE = "compute-vote.ex";
  public static final String QUEUE_COMPUTE_VOTE = "compute-vote.queue";
  public static final String RK_COMPUTE_VOTE = "compute-vote.queue";

  @Bean
  public MessageConverter messageConverter(){
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter){
    RabbitTemplate rabbitTemplate = new RabbitTemplate();
    rabbitTemplate.setMessageConverter(messageConverter);
    rabbitTemplate.setConnectionFactory(connectionFactory);

    return rabbitTemplate;
  }

  @Bean
  public Queue queue(){
    return new Queue(QUEUE_COMPUTE_VOTE, false, false, false);
  }

  @Bean
  public DirectExchange directExchange(){
    return new DirectExchange(EXCHANGE_COMPUTE_VOTE, false, false);
  }
  @Bean
  public Binding binding(){
    return BindingBuilder
        .bind(queue())
        .to(directExchange())
        .with(RK_COMPUTE_VOTE);
  }

}
