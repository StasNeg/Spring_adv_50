package beans.web;

import beans.models.Ticket;
import beans.services.BookingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static util.MapperUtil.MAPPER;

@Controller
@RequestMapping(value = "/booking")
public class BookingController {

    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");


    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {

        this.bookingService = bookingService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String getUserByEmail(Model model) throws JsonProcessingException {
        String date = "2016-02-05T21:18";
        String auditorium = "Yellow hall";
        String event = "The revenant";
        List<Ticket> current = bookingService.getTicketsForEvent(event, auditorium, LocalDateTime.parse(date, FORMATTER));
        model.addAttribute("request", MAPPER.writeValueAsString(current));
        return "booking";
    }


}
