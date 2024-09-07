package helpers;

import com.github.javafaker.Faker;

public class FakeUsersData {
    static Faker faker = new Faker();
    static final String EMAIL = faker.internet().emailAddress();
    static final String PASSWORD = faker.phoneNumber().phoneNumber();
    static final String WRONG_EMAIL = faker.internet().password();
    static final String CORRECT_PASSWORD = "test";
    static final String CORRECT_EMAIL = "test@protei.ru";
    static final String NAME = faker.name().name();

    public static String getPassword() {
        return PASSWORD;
    }
    public static String getEmail() {
        return EMAIL;
    }
    public static String getWrongEmail() {
        return WRONG_EMAIL;
    }
    public static String getCorrectPassword() {
        return CORRECT_PASSWORD;
    }
    public static String getCorrectEmail() {
        return CORRECT_EMAIL;
    }
    public static String getName() {
        return NAME;
    }

}
