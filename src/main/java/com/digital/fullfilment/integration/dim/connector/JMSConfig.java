package com.digital.fullfilment.integration.dim.connector;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.BeanFactoryDestinationResolver;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

/**
 * TODO add jndi templates to connect to jboss jms.
 * 
 * @author georgi_terziev
 *
 */
@EnableJms
@Configuration
public class JMSConfig implements BeanFactoryAware {
	private BeanFactory springContextBeanFactory;

	public void setBeanFactory(final BeanFactory springContextBeanFactory) throws BeansException {
		this.springContextBeanFactory = springContextBeanFactory;
	}

	@Bean
	public DefaultJmsListenerContainerFactory containerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setDestinationResolver(new BeanFactoryDestinationResolver(springContextBeanFactory));
		factory.setConcurrency("3-10");
		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) throws JMSException {
		return new JmsTemplate(connectionFactory);
	}

//	// Serialize message content to json using TextMessage
//	@Bean
//	public MessageConverter jacksonJmsMessageConverter() {
//		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//		converter.setTargetType(MessageType.TEXT);
//		converter.setTypeIdPropertyName("_type");
//		return converter;
//	}

}

// @Bean
// public JndiTemplate jndiTemplate(){
// JndiTemplate jndiTemplate = new JndiTemplate();
//
// Properties environment = new Properties();
// jndiTemplate.setEnvironment(environment );
// return jndiTemplate;
// }
//
// <bean id="jndiTemplate" class="org.springframework.jndi.JndiTemplate">
// <property name="environment">
// <props>
// <prop
// key="java.naming.factory.initial">org.jboss.naming.remote.client.InitialContextFactory</prop>
// <prop key="java.naming.provider.url">remote://localhost:4447</prop>
// <prop key="java.naming.security.principal">myuser</prop>
// <prop key="java.naming.security.credentials">mypassword</prop>
// </props>
// </property>
// </bean>
// <bean id="destination"
// class="org.springframework.jndi.JndiObjectFactoryBean">
// <property name="jndiTemplate" ref="jndiTemplate"></property>
// <property name="jndiName" value="jms/queue/test"></property>
// </bean>
// <bean id="connectionFactory"
// class="org.springframework.jndi.JndiObjectFactoryBean">
// <property name="jndiTemplate" ref="jndiTemplate"></property>
// <property name="jndiName" value="jms/RemoteConnectionFactory"></property>
// </bean>
// <bean id="queueConnectionFactory"
// class="org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter">
// <property name="targetConnectionFactory" ref="connectionFactory"></property>
// <property name="username" value="myuser"></property>
// <property name="password" value="mypassword"></property>
// </bean>
// <bean id="jmsTemplate" class="org.springframework.jms.core.JmsTemplate">
// <property name="connectionFactory" ref="queueConnectionFactory"></property>
// </bean>