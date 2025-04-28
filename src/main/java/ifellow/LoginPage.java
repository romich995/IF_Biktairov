package ifellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BaseAfterLoginPage {
    private final SelenideElement loginInput = $x("//*[@id='login-form-username']");
    private final SelenideElement passwordInput = $x("//*[@id='login-form-password']");
    private final SelenideElement entryButton = $x("//*[@id='login']");
    private final SelenideElement recordAfterLogin = $x("//*[@id='gadget-10002-title']");
    private final SelenideElement testProjectItem = $x("//a[@href='https://edujira.ifellow.ru/browse/TEST']");
    private final SelenideElement openTasksButton = $x("//span[@title='Задачи']/parent::a");

    public LoginPage login(String login, String password) {
        loginInput.shouldBe(Condition.visible)
                .sendKeys(login);
        passwordInput.shouldBe(Condition.visible)
                .sendKeys(password);
        entryButton.shouldBe(Condition.visible)
                .click();
        return this;
    }

    public LoginPage checkLogin(String expectedText) {
        recordAfterLogin.shouldBe(Condition.exist)
                .shouldHave(Condition.text(expectedText));
        return this;
    }

    public ProjectPage openTestProject() {
        searchInput.shouldBe(Condition.visible)
                .click();
        testProjectItem.shouldBe(Condition.visible)
                .click();
        openTasksButton.shouldBe(Condition.visible)
                .click();
        ProjectPage testProjectPage = Selenide.page(ProjectPage.class);
        return testProjectPage;
    }



}
