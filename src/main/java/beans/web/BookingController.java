package beans.web;

import beans.daos.UserDAO;
import beans.web.dto.BookingPriceResponse;
import beans.models.Ticket;
import beans.models.User;
import beans.services.BookingService;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import util.CsvUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(value = "/booking")
public class BookingController {

    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    private UserService userService;
    private BookingService bookingService;

    @Autowired
    public BookingController(UserService userService, BookingService bookingService) {
        this.userService = userService;
        this.bookingService = bookingService;
    }

    //      curl -X GET \
    //      'http://localhost:8080/booking/1?event=The%20revenant&auditorium=Blue%20hall&date=2016-02-05T09:00&seats=27,28,29' \

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<BookingPriceResponse> getTicketPriceByUserEventDateAuditoriumAndSeats(@RequestParam("event") String event, @RequestParam("auditorium") String auditorium,
                                                                                         @RequestParam("date") String dateTime,
                                                                                         @RequestParam("seats") String seats, @PathVariable String userId) {
        User current = userService.getById(Long.parseLong(userId));
        UserDAO.validateUser(current);
        double price = bookingService.getTicketPrice(event, auditorium, LocalDateTime.parse(dateTime, FORMATTER),
                CsvUtil.fromCsvToList(seats, Integer::parseInt), current);
        return new ResponseEntity<>(new BookingPriceResponse(price, current), HttpStatus.OK);
    }

//    curl -X GET \
//  'http://localhost:8080/booking/tickets?event=The%20revenant&auditorium=Yellow%20hall&date=2016-02-05T21:18' \

    @RequestMapping(value = "/tickets", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<List<Ticket>> getTicketsForEvent(@RequestParam("event") String event, @RequestParam("auditorium") String auditorium, @RequestParam("date")String date) {
        return new ResponseEntity<>(bookingService.getTicketsForEvent(event, auditorium,LocalDateTime.parse(date, FORMATTER)), HttpStatus.OK);
    }


}
