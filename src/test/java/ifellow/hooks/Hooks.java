package ifellow.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.PageLoadStrategy;

public class Hooks {

    @Before
    public void setConfiguration() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 10000;
    }

    @After
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}
