package ifellow.hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;

public class Hooks {

    @After("@qa")
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}
