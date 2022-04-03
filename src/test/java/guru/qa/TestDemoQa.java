package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
        $("#firstName").setValue("Aren");
        $("#lastName").setValue("Karapetyan");
        $("#userEmail").setValue("romashka@mail.ru");
        $("#userNumber").setValue("8800200060");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $x("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[7]").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#genterWrapper").$(byText("Female")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#currentAddress").setValue("Eto to4no Java?");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Merrut").pressEnter();





    }


}
