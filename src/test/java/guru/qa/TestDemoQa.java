package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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
        String firstName = "Aren";
        String lastName = "Karapetyan";
        String email = "romashka@mail.ru";
        String tel = "8800200060";
        String subjectsInput = "Hindi";
        String gender = "Male";
        String hobby = "Reading";
        String currentAddress = "Eto to4no Java?";
        String state = "Uttar Pradesh";
        String city = "Merrut";


        open("/automation-practice-form");
       /// Selenide.zoom(0.65);
       // executeJavaScript("document.querySelector(\"footer\").hidden = 'true';document.querySelector(\"#fixedban\").hidden = 'true'");   -удаление футера

        // executeJavaScript("$('footer').remove()");
        //        executeJavaScript("$('#fixedban').remove()");  - еще вариант убрать фуддер и баннер рекламы

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(tel);
        $("#dateOfBirthInput").click();
        //$(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#genterWrapper").$(byText(gender)).click();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/123.jpg"));
        //  $("#uploadPicture").uploadFromClasspath(imgPath);  альтернатива,
        //  задать переменную String imgPath = "img/Pushkin.jpg";
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text(firstName+" "+lastName),
                text (email),
                text (gender),
                text (tel),
                text ("04 May,1991"),
                text (subjectsInput),
                text (hobby),
                text ("123.jpg"),
                text (currentAddress),
                text (state+" "+city)
        );
     //   $("#closeLargeModal").click();

    }

}


///// Проверки корректности внесённых данных
//        $(".table-responsive").shouldHave(text("Student Name	" + name + " Zyryanov"),
//                text("Mobile 8982145978"), text("Picture	1.PNG"), text("Student Email Zyryanovvm@rambler.ru"),
//                text("Gender Female"), text("Date of Birth 15 January,1995"), text("Subjects English"),
//                text("Hobbies Music"), text("Address Lenina street 11"), text("State and City NCR Delhi"));