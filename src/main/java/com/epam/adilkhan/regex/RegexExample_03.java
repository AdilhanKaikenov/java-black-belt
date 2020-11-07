package com.epam.adilkhan.regex;

import java.util.Arrays;

public class RegexExample_03 {
    public static void main(String[] args) {
        String email = "vivanov@mail.ru";

        // We use it when we need to confirm or deny one match
        boolean result = email.matches("\\w+@\\w+\\.(ru|com)");
        System.out.println("Is it email? - " + result);

        String str = "Ivanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48," +
                "email: vivanov@mail.ru, Postcode:AA99, Phone Number:+123456789;" +
                "Petrova Mariya, Ukraine, Kiyev, Lomonosov street, 33, Flat 18, " +
                "email: masha@yandex.ru, Postcode: UKR54, Phone Number: +987654321;" +
                "Chuck Morris, USA, Hollywood, All starts street, 87, Flat 21," +
                "email: chuck@gmail.com, Postcode: USA23, Phone Number: +136478951.";

        // The parameter specifies what will act as a separator
        String[] array = str.split(" ");
        System.out.println(Arrays.toString(array));
    }
}
