package com.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    final String ROOT_URI = "http://localhost:8080/spring-course-1.0-SNAPSHOT/rest/user";
    final String APPLICATION_TYPE = "?mediaType=json";

    public List<User> getAllPerson() {
        ResponseEntity<User[]> response = restTemplate.getForEntity(ROOT_URI + APPLICATION_TYPE, User[].class);
        return Arrays.asList(response.getBody());

    }

    public List<User> getByName(String name) {
        ResponseEntity<User[]> response = restTemplate.getForEntity(ROOT_URI + "/name/" + name + APPLICATION_TYPE, User[].class);
        return Arrays.asList(response.getBody());
    }

    public User getByEmail(String email) {
        email = "&email=" + email;
        ResponseEntity<User> response = restTemplate.getForEntity(ROOT_URI + "/email" + APPLICATION_TYPE + email, User.class);
        return response.getBody();
    }

    public Object addPerson(User person) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity(person, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(ROOT_URI + APPLICATION_TYPE, request, String.class);
        Object result = null;
        if (response.getHeaders().get("Content-Type").contains("json")) {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(response.getBody(), User.class);
        } else result = response.getBody();

        return result;
    }


    public void deletePerson(Long id) {
        restTemplate.delete(ROOT_URI + id + APPLICATION_TYPE);
    }
}