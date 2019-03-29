package beans.web.dto;

import beans.models.User;

public class BookingPriceResponse {
    private final double price;
    private final User user;

    public BookingPriceResponse(double price, User user) {
        this.price = price;
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }
}
