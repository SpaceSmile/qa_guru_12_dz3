package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import io.qameta.allure.Step;

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
            cityInput = $("#city"),
            submitInput = $("#submit"),
            tableResultInput = $(".table-responsive");

    @Step("Открываем страницу регистрации")
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Вводим в поле рандомное имя")
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Вводим в поле рандомную фамилию")
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Вводим в поле рандомную почту")
    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step("Отмечаем рандомный пол")
    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    @Step("Вводим в поле рандомный номер")
    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Выбираем дату рождения в календаре")
    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    @Step("Выбираем в поле предметы")
    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Отмечаем в чек-боксе хобби")
    public RegistrationFormPage setHobbies(String value) {
        hobbiesWrapperInput.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем в форму картинку")
    public RegistrationFormPage setPicture(String patch) {
        uploadPicture.uploadFromClasspath(patch);

        return this;
    }

    @Step("Вводим в поле рандомный адрес")
    public RegistrationFormPage setCurrentAddress(String value) {
        CurrentAddress.setValue(value);

        return this;
    }

    @Step("Выбираем из списка штат")
    public RegistrationFormPage setState(String state) {
        stateInput.scrollIntoView(true).click();
        $(byText(state)).click();
        return this;
    }

    @Step("Выбираем из списка город")
    public RegistrationFormPage setCity(String city) {
        cityInput.click();
        $(byText(city)).click();

        return this;
    }

    @Step("Отправляем форму регистрации через кнопку submit")
    public RegistrationFormPage setSubmit() {
        submitInput.click();

        return this;
    }

    @Step("Проверяем результативную форму регистрации на правильность вывода наших значений")
    public RegistrationFormPage checkResult(String resName, String value) {
        tableResultInput.$(byText(resName))
                .parent().shouldHave(text(value));

        return this;
    }
}
