package config;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public interface ConfigSetup {

    String url = TestProperties.getValue("test.url");

    @BeforeAll
    static void openChrome() {
        WebDriverManager.chromedriver().setup();

        Configuration.browserSize = "1150x750";

        open(url);
    }
}