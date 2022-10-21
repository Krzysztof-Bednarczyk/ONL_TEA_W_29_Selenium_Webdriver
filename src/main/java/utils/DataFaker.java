package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataFaker {

    static Faker faker = new Faker();

    public static String createRandomEmail(){
        Random r = new Random();
        int randomNumber = r.nextInt(0, 1001);
        String randomEmail = String.format("test@test%s.com", randomNumber);
        return randomEmail;
    }

    public static String createRandomFirstName(){
        return faker.funnyName().name();
    }

    public static String createRandomLastName(){
        return faker.name().lastName();
    }

    public static String createRandomPassword(){
        Random r = new Random();
        int randomNumber = r.nextInt(0, 1001);
        return String.format("PAss%s%s", faker.dragonBall().character(), randomNumber);
    }

}
