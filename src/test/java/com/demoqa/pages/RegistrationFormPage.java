package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            CurrentAddress = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapperInput = $(".stateCity-wrapper"),
            cityInput = $("#city"),
            submitInput = $("#submit"),
            tableResultInput = $(".table-responsive");

    public SelenideElement tableCheck() {
        return $("#example-modal-sizes-title-lg");
    }

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        hobbiesWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setPicture(String patch) {
        uploadPicture.uploadFromClasspath(patch);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        CurrentAddress.setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateInput.click();
        stateCityWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityInput.click();
        stateCityWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setSubmit() {
        submitInput.click();

        return this;
    }

    public static RegistrationFormPage checkTableText(String text) {
        tableCheck().shouldHave(text(text));

        return this;
    }

    public RegistrationFormPage checkResult(String labelName, String value) {
        tableResultInput.$(byText(labelName))
                .parent().shouldHave(text(value));
        return this;
    }
}
