package com.registronacional.util.configuration;
  
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder; 
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue; 
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfig {
	
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
	    @Value("${spring.rabbitmq.port}")
	    private int port;
	    @Value("${spring.rabbitmq.cachesize}")
	    private int cachesize;
	    
	    
   
	    @Bean
	    Queue queue() {
	        return new Queue(queue, true);
	    }
	    @Bean
	    Exchange myExchange() {
	        return ExchangeBuilder.directExchange(exchange).durable(true).build();
	    }
	    @Bean
	    Binding binding() {
	        return BindingBuilder
	                .bind(queue())
	                .to(myExchange())
	                .with(routingKey)
	                .noargs();
	    }
	    @Bean
	    public ConnectionFactory connectionFactorySigmon() {
	        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
	        cachingConnectionFactory.setUsername(username);
	        cachingConnectionFactory.setPassword(password);
	        cachingConnectionFactory.setHost(host);
	        cachingConnectionFactory.setPort(port);
	        cachingConnectionFactory.setChannelCacheSize(cachesize);
	        return cachingConnectionFactory;
	    }
	    @Bean
	    public MessageConverter jsonMessageConverter() {
	        return new Jackson2JsonMessageConverter();
	    }
	    @Bean
	    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
	        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(jsonMessageConverter());
	        return rabbitTemplate;
	    }
	    
	    
	    
	    
	    

}
