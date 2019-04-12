package beans.web;

import beans.models.Ticket;
import beans.services.BookingService;
import beans.services.UserService;
import beans.web.dto.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(value = "/rest/ticket")
public class TicketController {

    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    private UserService userService;
    private BookingService bookingService;


    @Autowired
    public TicketController(UserService userService, BookingService bookingService) {
        this.userService = userService;
        this.bookingService = bookingService;
    }

//    curl -X GET \
//  'http://localhost:8080/rest/ticket/event?event=The%20revenant&auditorium=Yellow%20hall&date=2016-02-05T21:18' \

    @RequestMapping(value = "/event", method = RequestMethod.GET, produces = {"application/json", "application/pdf"})
    @ResponseBody
    public Tickets getTicketsForEvent(@RequestParam("event") String event, @RequestParam("auditorium") String auditorium, @RequestParam("date") String date, Model model) {
        List<Ticket> tickets = bookingService.getTicketsForEvent(event, auditorium, LocalDateTime.parse(date, FORMATTER));
        return new Tickets(tickets);
    }

}
