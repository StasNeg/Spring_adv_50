package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        StringHttpMessageConverter converter = new StringHttpMessageConverter();
        converter.setWriteAcceptCharset(false);
        List<MediaType> supported = new ArrayList<>(converter.getSupportedMediaTypes());
        supported.add(new MediaType("text", "html", Charset.forName("ISO-8859-1")));
        restTemplate.getMessageConverters().add(converter);
        converter.setSupportedMediaTypes(supported);
        return restTemplate;
    }
}