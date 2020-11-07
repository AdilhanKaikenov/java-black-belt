package com.epam.adilkhan.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample_02 {
    public static void main(String[] args) {
        String str = "Ivanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48," +
                "email: vivanov@mail.ru, Postcode:AA99, Phone Number:+123456789;" +
                "Petrova Mariya, Ukraine, Kiyev, Lomonosov street, 33, Flat 18, " +
                "email: masha@yandex.ru, Postcode: UKR54, Phone Number: +987654321;" +
                "Chuck Morris, USA, Hollywood, All starts street, 87, Flat 21," +
                "email: chuck@gmail.com, Postcode: USA23, Phone Number: +136478951.";

        // All words
        // Pattern pattern = Pattern.compile("\\w+");

        // \b – Matches word or number boundary
        // Pattern pattern = Pattern.compile("\\b\\d{2}\\b");

        // Phone numbers
        // Pattern pattern = Pattern.compile("\\+\\d{9}");

        // Emails
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.(ru|com)");

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("Posotion: " + matcher.start() + "  " +matcher.group());
        }
    }
}
