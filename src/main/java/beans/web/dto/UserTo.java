package beans.web.dto;

import beans.models.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static util.PasswordUtil.encode;

public class UserTo {

    private long id;
    private String name;
    private String email;
    private String password;
    private String roles;
    private String birthDay;

    public UserTo() {
    }

    public UserTo(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserTo(long id, String name, String email, String password, String roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UserTo(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.roles = user.getRoles();
        this.birthDay = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(user.getBirthday());
    }

    public static User fromTo(UserTo userTo) {
        return new User(userTo.getId(), userTo.getEmail(), userTo.getName(),
                LocalDate.parse(userTo.getBirthDay(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                userTo.getRoles(), userTo.getPassword());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = encode(password);
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
