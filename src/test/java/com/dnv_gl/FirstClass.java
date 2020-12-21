package com.dnv_gl;

import com.github.javafaker.Faker;
import org.testng.annotations.Factory;

public class FirstClass {

    public static void main(String[] args) {

        System.out.println("Hello DNV-GL");

        Faker faker = new Faker();

        System.out.println(faker.name().fullName());
        System.out.println(faker.harryPotter().character());
        System.out.println(faker.overwatch().hero());
    }
}
