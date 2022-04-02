package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;

public class TestsTests {
    @Test
    void assertTest () {
   Selenide.open("https://translate.google.it");

        WebDriverRunner.closeWindow();

}
    @Test
    void assertTest2() {
        Selenide.open("https://translate.google.it");

        WebDriverRunner.closeWindow();
    }

}
