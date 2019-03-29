package beans.web.dto;

import beans.models.Event;
import beans.models.User;

import java.util.List;

public class JsonModel {
    private List<User> users;
    private List<Event> events;

    public JsonModel() {
    }

    public JsonModel(List<User> users, List<Event> events) {
        this.users = users;
        this.events = events;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
