package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientAppConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.user_web");
		return marshaller;
	}
	@Bean
	public UserEventClient studentClient(Jaxb2Marshaller marshaller) {
		UserEventClient client = new UserEventClient();
		client.setDefaultUri("http://localhost:8080/soapws/event.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
