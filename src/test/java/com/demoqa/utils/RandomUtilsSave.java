package com.demoqa.utils;

import java.util.Random;
// примеры рандомов
public class RandomUtilsSave {
    // буквы + цифры
    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }
    // цифры
    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }
    // почта
    public static String getRandomEmail() {
        String emailDomain = "@gmail.com";

        return getRandomString(10) + emailDomain;
    }
}