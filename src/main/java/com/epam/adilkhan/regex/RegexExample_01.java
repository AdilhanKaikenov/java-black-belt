package com.epam.adilkhan.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample_01 {
    public static void main(String[] args) {
        String str = "ABCD ABCE ABCF ABNGABCDTRS";
        // Classes Pattern and Matcher are two classes that help to efficiently, very quickly cope with our task.
        // Writing a regular expression is a rule that must match the desired value
        Pattern pattern = Pattern.compile("ABC");

        Matcher matcher = pattern.matcher(str);
        // If some match was found, it returns true, and if there are several matches, then it will return true several times
        while (matcher.find()) {
            System.out.println("Posotion: " + matcher.start() + "  " +matcher.group());
        }
    }
}
