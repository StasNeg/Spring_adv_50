package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
@PropertySource("classpath:app.properties")
public class ClientAppConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.user_web");
        return marshaller;
    }

    @Bean
    public UserEventClient userClient(Jaxb2Marshaller marshaller) {
        UserEventClient client = new UserEventClient(endpoint());
        client.setDefaultUri(endpoint().getEND_POINT());
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Autowired
    private Environment env;

    @Bean
    public EndPoint endpoint() {
        return new EndPoint(env.getProperty("wsdl.endpoint"));
    }

}


