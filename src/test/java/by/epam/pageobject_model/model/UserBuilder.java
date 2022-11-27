package by.epam.pageobject_model.model;

public class UserBuilder {
    private String username;
    private String password;

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User createUser() {
        return new User(username, password);
    }
}