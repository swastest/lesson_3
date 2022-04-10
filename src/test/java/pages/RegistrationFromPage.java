package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFromPage {
    CalendarComponent calendar = new CalendarComponent();
    //locators
SelenideElement firstNameInput = $("#firstName"),
    lastNameInput= $("#lastName"),
    userEmailInput =$("#userEmail"),
    phoneNumberInput = $("#userNumber"),
    currentAddressInput = $("#currentAddress"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput =  $("#subjectsInput"),
             genderRadio = $("#genterWrapper"),
hobbyCheck =  $("#hobbiesWrapper"),
    stateInput = $("#react-select-3-input"),
    cityInput = $("#react-select-4-input"),
    uploadFileInput = $("input#uploadPicture"),
    submitID = $("#submit"),
            headerTableResponse= $("#example-modal-sizes-title-lg"),
    tableContent =$(".table-responsive")
;

    //actions
    public RegistrationFromPage openPage (){
        open("/automation-practice-form");

    return this;
    }

    public RegistrationFromPage setFirstname (String firstName){

        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationFromPage setLastname (String lastName){
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFromPage setEmail (String email) {
        userEmailInput.setValue(email);
        return this;
    }


    public RegistrationFromPage setPhoneNumber (String value) {
       phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationFromPage setCurrentAddress (String currentAddress){

        currentAddressInput.setValue(currentAddress);
        return this;
    }
    public RegistrationFromPage setBirthDate (String day, String month, String year){
        dateOfBirthInput.click();
        calendar.setData(day, month, year);

        return this;
    }
    public RegistrationFromPage setSubjects (String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFromPage setGender (String gender) {
        genderRadio.$(byText(gender)).click();

        return this;
    }

public RegistrationFromPage setCheckbox (String hobby) {
    hobbyCheck.$(byText(hobby)).click();

    return this;
}

public RegistrationFromPage setState (String state) {

    stateInput.setValue(state).pressEnter();
    return this;
}

public RegistrationFromPage setCity (String city) {

        cityInput.setValue(city).pressEnter();
    return this;
}

public RegistrationFromPage setFile (String file) {
    uploadFileInput.uploadFromClasspath(file);
    return this;

}

public RegistrationFromPage submitKlik (){
    submitID.click();
    return this;
}

public RegistrationFromPage checkTableHeaderResponse (String text) {
    headerTableResponse.shouldHave(text("Thanks for submitting the form"));
    return this;

}

public RegistrationFromPage checkTableContent (String key, String value){
    tableContent.$(byText(key)).parent().shouldHave(text(value));
    return this;

}

}

