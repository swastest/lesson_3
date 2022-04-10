package pages;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class TestDemoQaFormWithFakerPageObjects {
    RegistrationFromPage registrationFromPage = new RegistrationFromPage();


    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            tel = faker.numerify("##########"),
            subjectsInput = "Hindi",
            gender = "Male",
    // gender = StringUtils.capitalize(faker.dog().gender());
    hobby = "Reading",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            file = "123.jpg",
            city = "Merrut",
            responseHeder = "Thanks for submitting the form";
    //birthDay = faker.date().birthday().toString().
    String expectedFullName = format("%s %s", firstName, lastName);
    String fullStateCity = format("%s %s", state, city);

    // String dataBirth

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void Test1() {

        registrationFromPage.openPage()
                .setFirstname(firstName)
                .setLastname(lastName)
                .setEmail(email)
                .setPhoneNumber(tel)
                .setCurrentAddress(currentAddress)
                .setBirthDate("04", "May", "1991")
                .setSubjects(subjectsInput)
                .setGender(gender)
                .setCheckbox(hobby)
                .setState(state)
                .setCity(city)
                .setFile(file)
                .submitKlik()
                .checkTableHeaderResponse(responseHeder)
                .checkTableContent("Student Name", expectedFullName)
                .checkTableContent("Student Email", email)
                .checkTableContent("Gender", gender)
                .checkTableContent("Mobile", tel)
                .checkTableContent("Date of Birth", "04 May,1991")
                .checkTableContent("Subjects", subjectsInput)
                .checkTableContent("Hobbies", hobby)
                .checkTableContent("Picture", file)
                .checkTableContent("Address", currentAddress)
                .checkTableContent("State and City", fullStateCity);

    }
}