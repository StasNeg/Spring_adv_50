package beans.xml;

import beans.models.Event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "auditorium")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreatedForXsd {
    private List<Event> events;

    public CreatedForXsd() {
    }

    public CreatedForXsd(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
