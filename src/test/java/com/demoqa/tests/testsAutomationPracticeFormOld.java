package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class testsAutomationPracticeFormOld {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void automationPracticeForm() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String email = "ivan.ivanov@gmail.com";
        String userNumber = "9991234567";
        String subjects = "Arts";
        String currentAddress = "Krasnodar, ul. mira, 43-3";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        //$("#genter-radio3").parent().click(); - второй способ
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__day--028:not(react-datepicker__day)--outside-month").click();
        //$(byText("22")).click(); - дата второй способ
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        //$("#hobbies-checkbox-1").parent().click(); - второй способ
        $("#uploadPicture").uploadFromClasspath("jpeg/11.jpeg");
        //$("#uploadPicture").uploadFile(new File("src/test/resources/jpeg/11.jpeg")); второй способ картинки
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(".stateCity-wrapper").$(byText("NCR")).click();
        //$(byText("NCR")).click(); - второй способ
        $("#city").click();
        $(".stateCity-wrapper").$(byText("Noida")).click();
        //$(byText("Noida")).click(); - второй способ
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text("Ivan Ivanov"),
                text(email),
                text("Male"),
                text(userNumber),
                text(userNumber),
                text("28 May,2002"),
                text(subjects),
                text("Sports"),
                text("11.jpeg"),
                text(currentAddress),
                text("NCR Noida"));
    }
}