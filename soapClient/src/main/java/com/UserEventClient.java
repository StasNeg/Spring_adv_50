package com;

import com.user_web.GetEventRequest;
import com.user_web.GetEventResponse;
import com.user_web.GetUserRequest;
import com.user_web.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UserEventClient extends WebServiceGatewaySupport {

    private EndPoint endPoint;

    @Autowired
    public UserEventClient(EndPoint endPoint) {
        this.endPoint = endPoint;
    }

    public GetUserResponse getUserByName(String studentId) {

        GetUserRequest request = new GetUserRequest();
        request.setUserEmail(studentId);
        GetUserResponse response = (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback(endPoint.getEND_POINT() + "/getUserResponse"));
        return response;
    }

    public GetEventResponse getEventByName(String eventName) {
        GetEventRequest request = new GetEventRequest();
        request.setEventName(eventName);
        GetEventResponse response = (GetEventResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback(endPoint.getEND_POINT() + "/getEventResponses"));
        return response;
    }
}
