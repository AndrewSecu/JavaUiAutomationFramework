package online.tekwillacademy.managers;

import com.github.javafaker.Faker;

public class DataGeneratorManager {

    private static Faker faker= new Faker();

    public static String getRandomEmail(){
        return faker.internet().emailAddress();
    }

    public static String getRandomName(){
        return faker.name().name();
    }

    public static String getRandomPassword(int min, int max){
        return faker.internet().password(min, max);
    }
}
