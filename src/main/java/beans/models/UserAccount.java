package beans.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/1/2016
 * Time: 7:37 PM
 */
public class UserAccount {
    @JsonIgnore
    private long id;
    private User user;
    private Double amount;

    public UserAccount() {
    }

    public UserAccount(User user, double amount) {
        this(-1, user, amount);
    }


    public UserAccount(long id, User user, Double amount) {
        this.id = id;
        this.user = user;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount)) return false;
        UserAccount that = (UserAccount) o;
        return id == that.id &&
                Objects.equals(user, that.user) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, amount);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", user=" + user +
                ", amount=" + amount +
                '}';
    }

    public UserAccount withId(Long ticketId) {
        return new UserAccount(ticketId, user, amount);
    }
}
