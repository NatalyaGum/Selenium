package by.epam.pageobject_model.service;

import by.epam.pageobject_model.model.User;
import by.epam.pageobject_model.model.UserBuilder;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    public static User withCredentialsFromProperty(){
        return new UserBuilder().setUsername(TestDataReader.getTestData(TESTDATA_USER_NAME)).setPassword(TestDataReader.getTestData(TESTDATA_USER_PASSWORD)).createUser();
    }

    public static User withEmptyUsername(){
        return new UserBuilder().setUsername("").setPassword(TestDataReader.getTestData(TESTDATA_USER_PASSWORD)).createUser();
    }

    public static User withEmptyPassword(){
        return new UserBuilder().setUsername(TestDataReader.getTestData(TESTDATA_USER_NAME)).setPassword("").createUser();
    }
}