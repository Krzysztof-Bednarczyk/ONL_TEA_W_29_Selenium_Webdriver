package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataFaker {

    static Faker faker = new Faker();

    public static String createRandomEmail(){
        Random r = new Random();
        int randomNumber = r.nextInt(0, 10001);
        return String.format("test@test%s.com", randomNumber);
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

    public static String createRandomAddress(){
        return faker.address().fullAddress();
    }

    public static String createRandomZip(){
        return faker.address().zipCode();
    }

    public static String createRandomCity(){
        return faker.address().cityName();
    }

    public static String createRandomPhoneNumnber(){
        return faker.phoneNumber().phoneNumber();
    }

}
