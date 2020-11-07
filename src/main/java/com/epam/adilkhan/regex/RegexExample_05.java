package com.epam.adilkhan.regex;

public class RegexExample_05 {
    public static void main(String[] args) {
        String str = "Privet,       moy drug !    Kak idet izuchenie          Java           ?";
        System.out.println(str);
//        str = str.replace("Java", "SQL");
        str = str.replaceAll(" {2,}", " ");
        System.out.println(str);
    }
}
