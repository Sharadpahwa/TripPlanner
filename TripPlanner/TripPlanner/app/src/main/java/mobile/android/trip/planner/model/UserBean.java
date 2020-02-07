package mobile.android.trip.planner.model;

public class UserBean {
    String country;
    String emailId;
    String location;
    String name;
    String password;
    String phone;
    String state;
    String username;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserBean(String country, String emailId, String location, String name, String password, String phone, String state, String username) {
        this.country = country;
        this.emailId = emailId;
        this.location = location;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.state = state;
        this.username = username;
    }
}
