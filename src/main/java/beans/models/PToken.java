package beans.models;

import java.util.Date;

public class PToken {

//    CREATE TABLE persistent_logins (
//            username varchar(64) not null,
//    series varchar(64) not null,
//    token varchar(64) not null,
//    last_used timestamp not null,
//    PRIMARY KEY (series)
//);
    private String username;
    private String series;
    private String token;
    private Date lastUsed;

    public PToken() {
    }

    public PToken(String username, String series, String token, Date lastUsed) {
        this.username = username;
        this.series = series;
        this.token = token;
        this.lastUsed = lastUsed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }
}
