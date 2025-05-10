package ifellow.steps;

import com.codeborne.selenide.Selenide;
import ifellow.pages.AfterLoginPage;
import ifellow.pages.BeforeLoginPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class EduJiraAuthSteps {
    private final BeforeLoginPage beforeLoginPage = new BeforeLoginPage();
    private final AfterLoginPage afterLoginPage = new AfterLoginPage();

    @Дано("^находимся на странице аутентификации")
    public void openAuthPage() {
        Selenide.open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }

    @Когда("^ввожу логин '(.*)' и пароль '(.*)' и далее сабмичу форму")
    public void login(String login, String password) {
        beforeLoginPage.login(login, password);
    }

    @Тогда("^меня переводит на страницу пользователя")
    public void checkLogin() {
        afterLoginPage.checkLogin();
    }


}
