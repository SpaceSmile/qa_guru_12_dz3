package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.Keys.*;

public class tests_automation_practice_form {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
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
        String currentAddress = "Krasnodar, ul. mire, 43-3";

        open("/automation-practice-form");
        Selenide.executeJavaScript("document.querySelector(\"footer\").hidden = 'true';" +
                "document.querySelector(\"#fixedban\").hidden = 'true'");
        zoom(0.7);
        $("#subjectsInput").pressEnter();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2002");
        $(byText("22")).click();
        $("#subjectsInput").shouldBe(enabled).setValue(subjects);
        $("#subjectsInput").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("jpeg/11.jpeg");
        $("#currentAddress").setValue(currentAddress);
        $(".css-1wa3eu0-placeholder").click();
        $(byText("NCR")).click();
        $(".css-1wa3eu0-placeholder").click();
        $(byText("Noida")).click();
        $("#submit").click();
        $(".modal-body").shouldHave(
                text("Ivan Ivanov"),
                text(email),
                text("Male"),
                text(userNumber),
                text(userNumber),
                text("22 May,2002"),
                text(subjects),
                text("Sports"),
                text("11.jpeg"),
                text(currentAddress),
                text("NCR Noida"));
        $("#closeLargeModal").click();
    }

//
//        $("[id=permanentAddress]").shouldHave(text("Permananet Address :Another street 2")); // wrong
//        $("[id=permanentAddress]", 1).shouldHave(text("Permananet Address :Another street 2"));
//        $("p[id=permanentAddress]").shouldHave(text("Permananet Address :Another street 2"));
//
//        String expectedPermanentAddress = "Another street 2";
//        String actualPermanentAddress = $("p[id=permanentAddress]").text();
//        assertEquals(expectedPermanentAddress, actualPermanentAddress);
}