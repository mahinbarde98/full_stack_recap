package com.stackroute.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Indicates this as a configuration class
 */
@Configuration
public class RabbitMQConfig {
    /**
     * To get the property values
     */
    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;



    /**
     * creating queue
     * durable queue survives a server restart.
     */

    /**
     * creating an Exchange
     * Direct Exchange routes messages to single queues by a matching of a routing key
     */

    /**
     * binding() method binds queue and Exchanges
     */

    /**
     * Creating connections to rabbitMq broker
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        /**
         * We want connection to be stable,
         * so that we needn't close or open connection
         */
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        /*
         * Jackson2JsonMessageConverter to send the message in a JSON format.
         */
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
