package com;

import com.user_web.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

public class UserEventClient extends WebServiceGatewaySupport {
    public GetUserResponse getUserByName(String studentId) {
        GetUserRequest request = new GetUserRequest();
        request.setUserEmail(studentId);
        GetUserResponse response = (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/getUserResponse"));
        return response;
    }

    public GetEventResponse getEventByName(String eventName) {
        GetEventRequest request = new GetEventRequest();
        request.setEventName(eventName);
        GetEventResponse response = (GetEventResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/getEventResponses"));
        return response;
    }
}
