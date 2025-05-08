package ifellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AfterLoginPage extends BaseAfterLoginPage {
    private final SelenideElement recordAfterLogin = $x("//*[@id='gadget-10002-title']").as("Запись на странице после аутентификации");
    private final SelenideElement testProjectItem = $x("//a[@href='https://edujira.ifellow.ru/browse/TEST']").as("Ссылка на проект TEST");
    private final SelenideElement openTasksButton = $x("//span[@title='Задачи']/parent::a").as("Кнопка 'открытые задачи'");


    public AfterLoginPage checkLogin() {
        recordAfterLogin.shouldBe(Condition.exist)
                .shouldHave(Condition.text("Назначенные мне"));
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
