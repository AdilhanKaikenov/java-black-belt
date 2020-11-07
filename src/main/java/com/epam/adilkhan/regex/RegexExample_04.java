package com.epam.adilkhan.regex;

import java.util.regex.Pattern;

public class RegexExample_04 {

    private void checkIP(String ip) {
        String regex = "((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}(25[0-5]|2[0-4]\\d |[01]?\\d?\\d)";
        // 25[0-5]      |       2[0-4]\d        |       [01]?\d?\d     (\.)
        // 250-255      OR      200-249         OR      0-199           .

        System.out.println("IP is OK? " + Pattern.matches(regex, ip));
    }

    public static void main(String[] args) {
        String ip1 = "255.38.192.99";
        String ip2 = "182.262.91.05";

        RegexExample_04 example = new RegexExample_04();
        example.checkIP(ip1);
        example.checkIP(ip2);
    }
}
