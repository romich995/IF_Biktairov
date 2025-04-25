package ifellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement loginInput = $x("//*[@id='login-form-username']");
    private final SelenideElement passwordInput = $x("//*[@id='login-form-password']");
    private final SelenideElement entryButton = $x("//*[@id='login']");
    private final SelenideElement recordAfterLogin = $x("//*[@id='gadget-10002-title']");

    public LoginPage login(String login, String password) {
        loginInput.shouldBe(Condition.visible)
                .sendKeys(login);
        passwordInput.shouldBe(Condition.visible)
                .sendKeys(password);
        entryButton.shouldBe(Condition.visible)
                .click();
        return this;
    }

    public void checkLogin(){
        recordAfterLogin.shouldBe(Condition.exist);
    }








}
