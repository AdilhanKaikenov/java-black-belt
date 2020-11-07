package com.epam.adilkhan.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample_06 {
    public static void main(String[] args) {

        // 12345678912345670325987
        // 03/25 1234 5678 9123 4567 (987)
        String cards = "12345678912345670325987;\n" +
                "98765432165498750921657;\n" +
                "85274196345612381122333.";

        //                                    1       2       3       4       5       6       7
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = pattern.matcher(cards);

        //                                                   03/25 1234 5678 9123 4567 (987)
        String newCardsFormat = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
        System.out.println(newCardsFormat);
    }
}
