package ifellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BeforeLoginPage {
    private final SelenideElement loginInput = $x("//*[@id='login-form-username']").as("Поле ввода логина");
    private final SelenideElement passwordInput = $x("//*[@id='login-form-password']").as("Поле ввода пароля");
    private final SelenideElement entryButton = $x("//*[@id='login']").as("Кнопка входа в аккаунт");


    public AfterLoginPage login(String login, String password) {
        loginInput.shouldBe(Condition.visible)
                .sendKeys(login);
        passwordInput.shouldBe(Condition.visible)
                .sendKeys(password);
        entryButton.shouldBe(Condition.visible)
                .click();
        return Selenide.page(AfterLoginPage.class);
    }
}
