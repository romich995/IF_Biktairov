package ifellow;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebHook {

    @BeforeEach
    public void initBrowser() {
        Configuration.browserBinary = "/home/t1/chrome-linux64/chrome";
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;

        Selenide.open("https://edujira.ifellow.ru");
    }

    @AfterEach
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
