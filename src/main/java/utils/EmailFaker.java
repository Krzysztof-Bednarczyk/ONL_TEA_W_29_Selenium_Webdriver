package utils;

import java.util.Random;

public class EmailFaker {

    public static String createRandomEmail(){
        Random r = new Random();
        int randomNumber = r.nextInt(0, 1001);
        String randomEmail = String.format("test@test%s.com", randomNumber);
        return randomEmail;
    }

}
