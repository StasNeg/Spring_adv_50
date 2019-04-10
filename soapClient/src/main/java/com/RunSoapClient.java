package com;


import com.user_web.Event;
import com.user_web.GetEventResponse;
import com.user_web.GetUserResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class RunSoapClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ClientAppConfig.class);
        ctx.refresh();
        UserEventClient userClient = ctx.getBean(UserEventClient.class);
        System.out.println("For Student Email: dmitriy.vbabichev@gmail.com");
        GetUserResponse response = userClient.getUserByName("dmitriy.vbabichev@gmail.com");
        System.out.println("Email:" + response.getUser().getEmail());
        System.out.println("Date:" + response.getUser().getBirthday());
        System.out.println("Id:" + response.getUser().getId());

        GetEventResponse responseEvent = userClient.getEventByName("The revenant");
        for (Event resp : responseEvent.getEvents()) {
            System.out.println("Event auditorium name:" + resp.getAuditorium().getName());
            System.out.println("Event ID:" + resp.getId());
            System.out.println("Event ID:" + resp.getId());

        }
    }
}
