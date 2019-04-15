package com;

import com.model.User;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.time.LocalDateTime;

@EnableWebMvc
public class RestClient {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = context.getBean(UserService.class);
        System.out.println(service.getAllPerson());
        System.out.println(service.getByName("Dmytro Babichev"));
        String email = "newEmail"+ LocalDateTime.now().toString();
        System.out.println(service.addPerson(new User(-1,"Stas",email,"password","ROLES_UNDEFINED","1975-11-22")));
        System.out.println(service.getByEmail(email));
        System.out.println(service.addPerson(new User(-1,"Stas",email,"password","ROLES_UNDEFINED","1975-11-22")));

    }
}
