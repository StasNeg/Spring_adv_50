package beans.web;

import beans.models.Event;
import beans.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/event")
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    ModelAndView getEventByName(@RequestParam("name") String name) {
        String header = "Get events by name: " + name;
        List<Event> events = eventService.getByName(name);
        return new ModelAndView("PDFEventPage", "modelEvent", getStringObjectMap(events, header));
    }

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView getEvents() {
        String header = "Get all events";
        List<Event> events = eventService.getAll();
        return new ModelAndView("PDFEventPage", "modelEvent", getStringObjectMap(events, header));
    }


    private Map<String, Object> getStringObjectMap(List<Event> events, String header) {
        Map<String, Object> modelEvent = new HashMap<>();
        modelEvent.put("header", header);
        if (events.isEmpty()) throw new RuntimeException("Didn't find any events");
        modelEvent.put("event", events);
        return modelEvent;
    }

}

