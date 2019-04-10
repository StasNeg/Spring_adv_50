package beans.web.soap;

import beans.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xml.models.beans.user_web.Event;
import xml.models.beans.user_web.GetEventRequest;
import xml.models.beans.user_web.GetEventResponse;

import java.util.List;

import static beans.web.soap.Converter.toEvent;
import static beans.web.soap.UserEndpoint.NAMESPACE_URI;

@Endpoint
public class EventEndpoint {

    private EventService eventService;

    @Autowired
    public EventEndpoint(@Qualifier("eventServiceImpl") EventService eventService) {
        this.eventService = eventService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEventRequest")
    @ResponsePayload
    public GetEventResponse getEventResponse(@RequestPayload GetEventRequest request) {
        GetEventResponse response = new GetEventResponse();
        List<Event> events = response.getEvents();
        List<beans.models.Event> fromApi = eventService.getByName(request.getEventName());
        fromApi.forEach(x -> {
            events.add(toEvent(x));
        });
        return response;
    }
}
