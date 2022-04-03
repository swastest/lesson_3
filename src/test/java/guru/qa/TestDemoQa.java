package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestDemoQa {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void  Test1 () {
        open("/automation-practice-form");
       // executeJavaScript("document.querySelector(\"footer\").hidden = 'true';document.querySelector(\"#fixedban\").hidden = 'true'");   -удаление футера

        // executeJavaScript("$('footer').remove()");
        //        executeJavaScript("$('#fixedban').remove()");  - еще вариант убрать фуддер и баннер рекламы

        $("#firstName").setValue("Aren");
        $("#lastName").setValue("Karapetyan");
        $("#userEmail").setValue("romashka@mail.ru");
        $("#userNumber").setValue("8800200060");
        $("#dateOfBirthInput").click();
        //$(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#genterWrapper").$(byText("Male")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#currentAddress").setValue("Eto to4no Java?");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Merrut").pressEnter();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/123.jpg"));
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Aren Karapetyan"), text ("romashka@mail.ru"),
                text ("Male"), text ("8800200060"), text ("04 May,1991"), text ("Hindi"), text ("Reading"),
                text ("123.jpg"), text ("Eto to4no Java?"), text ("Uttar Pradesh Merrut"));
        $("#closeLargeModal").click();

    }

}


///// Проверки корректности внесённых данных
//        $(".table-responsive").shouldHave(text("Student Name	" + name + " Zyryanov"),
//                text("Mobile 8982145978"), text("Picture	1.PNG"), text("Student Email Zyryanovvm@rambler.ru"),
//                text("Gender Female"), text("Date of Birth 15 January,1995"), text("Subjects English"),
//                text("Hobbies Music"), text("Address Lenina street 11"), text("State and City NCR Delhi"));