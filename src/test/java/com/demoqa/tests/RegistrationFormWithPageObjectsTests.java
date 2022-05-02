package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static java.lang.String.format;

public class RegistrationFormWithPageObjectsTests {
    Faker faker = new Faker();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String
        firstName = faker.name().firstName(),
        lastName = faker.name().firstName(),
        fullName = format("%s %s", firstName, lastName),
        email = faker.internet().emailAddress(),
        gender = faker.demographic().sex(),
        userNumber = faker.numerify("##########"),
        day = "11",
        month = "May",
        year = "2000",
        subjects = "Arts",
        hobbies = "Sports",
        picture = "11.jpeg",
        wayPicture = "jpeg/11.jpeg",
        currentAddress = faker.address().fullAddress(),
        state = "NCR",
        city = "Noida",
        addressFull = format("%s %s", state, city);

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void automationPracticeForm() {
        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(wayPicture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmit()
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", addressFull);
    }
}