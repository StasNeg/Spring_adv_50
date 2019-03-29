package beans.web.dto;

import beans.models.Auditorium;
import beans.models.Event;
import beans.models.Rate;
import beans.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.MapperUtil.MAPPER;

public class ObjectMapperTest {



    private String jsonTest;

    @Before
    public void createJson() throws JsonProcessingException {
        String[] emails = {"stanislav.nizhnyi@gmail.com", "stanislav1.nizhnyi@gmail.com"};
        String name = "Stanislav";
        String eventName = "My birthday";
        String auditoriumName = "Down hall";
        List<User> users = new ArrayList<>();
        for (String email : emails) {
            users.add(new User(email, name, LocalDate.of(1985,04,21)));
        }
        List<Event> events = new ArrayList<>();
//        Auditorium myAuditorium = new Auditorium("Grand Plaza", 1000, Arrays.asList(27,28,29,30,31,32,33));
//        String name, Rate rate, double basePrice, LocalDateTime dateTime, Auditorium auditorium
        Event event1 = new Event(eventName, Rate.HIGH, 200,LocalDateTime.of(2019,11,05,19,45),null);
        Event event2 = new Event(eventName, Rate.LOW, 300,LocalDateTime.of(2019,12,05,20,00),null);
        JsonModel model = new JsonModel(users,Arrays.asList(event1,event2));
        jsonTest = MAPPER.writeValueAsString(model);
        System.out.println(jsonTest);
    }

    @Test
    public void test() throws IOException {

        JsonModel model = MAPPER.readValue(jsonTest, JsonModel.class);
        Assert.assertEquals("Stanislav", model.getUsers().get(0).getName());
        Assert.assertEquals("stanislav.nizhnyi@gmail.com", model.getUsers().get(0).getEmail());
        Assert.assertEquals(LocalDate.of(1985,04,21), model.getUsers().get(0).getBirthday());
    }

}
