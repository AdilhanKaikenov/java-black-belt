package com.epam.adilkhan.annotation;

import java.lang.annotation.*;

public class CustomAnnotationExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> xiaomiClass = Class.forName("com.epam.adilkhan.annotation.Xiaomi");
        Annotation annotation1 = xiaomiClass.getAnnotation(SmartPhone.class);
        SmartPhone sm1 = (SmartPhone) annotation1;
        System.out.println("Annotation info for Xiaomi: " + sm1.OS() + ", " + sm1.yearOfCompanyCreation());

        Class<?> iphoneClass = Class.forName("com.epam.adilkhan.annotation.IPhone");
        Annotation annotation2 = iphoneClass.getAnnotation(SmartPhone.class);
        SmartPhone sm2 = (SmartPhone) annotation2;
        System.out.println("Annotation info for IPhone: " + sm2.OS() + ", " + sm2.yearOfCompanyCreation());
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    // Reference data types cannot be used
    String OS() default "Android";

    int yearOfCompanyCreation();
}

@SmartPhone(yearOfCompanyCreation = 2010)
class Xiaomi {
    String model;
    double price;
}

@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1976)
class IPhone {
    String model;
    double price;
}