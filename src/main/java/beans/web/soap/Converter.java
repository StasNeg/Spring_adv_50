package beans.web.soap;

import util.CsvUtil;
import xml.models.beans.user_web.Auditorium;
import xml.models.beans.user_web.Event;
import xml.models.beans.user_web.Rate;
import xml.models.beans.user_web.User;

import java.time.format.DateTimeFormatter;

public interface Converter {
    static public Auditorium toAuditorium(beans.models.Auditorium auditorium) {
        Auditorium result = new Auditorium();
        result.setId(auditorium.getId());
        result.setName(auditorium.getName());
        result.setSeatsNumber(auditorium.getSeatsNumber());
        result.setVipSeats(CsvUtil.fromListToCsv(auditorium.getVipSeatsList()));
        return result;
    }

    static public Event toEvent(beans.models.Event event) {
        Event result = new Event();
        result.setAuditorium(toAuditorium(event.getAuditorium()));
        result.setDateTime(event.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        result.setBasePrice(event.getBasePrice());
        result.setId(event.getId());
        result.setName(event.getName());
        result.setRate(toRate(event.getRate()));
        return result;

    }

    static Rate toRate(beans.models.Rate rate) {

        return Rate.valueOf(rate.name());
    }

    static User toUser(beans.models.User user) {
        User result = new User();
        result.setBirthday(user.getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        result.setName(user.getName());
        result.setEmail(user.getEmail());
        result.setId(user.getId());
        result.setRoles(user.getRoles());
        return result;
    }

}
