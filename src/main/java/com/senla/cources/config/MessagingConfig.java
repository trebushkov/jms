package com.senla.cources.config;

import com.senla.cources.service.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.ErrorHandler;

import javax.jms.ConnectionFactory;

@Configuration
@EnableScheduling
public class MessagingConfig {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private ErrorHandler sampleJmsErrorHandler;

    @Value("${myqueue}")
    private String queue;

    @Bean
    public DefaultMessageListenerContainer messageListener() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(this.connectionFactory);
        container.setErrorHandler(sampleJmsErrorHandler);
        container.setDestinationName(queue);
        container.setMessageListener(new Consumer());
        return container;
    }

}
