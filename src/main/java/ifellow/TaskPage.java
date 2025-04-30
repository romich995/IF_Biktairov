package ifellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class TaskPage extends BaseAfterLoginPage {


    private final SelenideElement statusValue = $x("//span[@id='status-val']/span").as("Значение статуса");
    private final SelenideElement versionValue = $x("//span[@id='fixVersions-field']/a").as("Значение версии");
    private final SelenideElement statusInWorkButton = $x("//*[@id='action_id_21']").as("Кнопка перевода задчи в статус В работе");
    private final SelenideElement closeButtonOfUpdateAlert = $x("//div[@id='aui-flag-container']/descendant::button").as("Кнопка закрытия алерта");
    private final SelenideElement businessProcessButton = $x("//*[@id='opsbar-transitions_more']").as("Кнопка Бизнес-процессы");
    private final SelenideElement statusDoneButton = $x("//*[@id='action_id_31']/a").as("Кнопка Выполненно");

    public TaskPage checkStatus(String expectedText) {
        statusValue.shouldBe(Condition.visible)
                .shouldHave(Condition.text(expectedText));
        return this;
    }

    public TaskPage checkVersion(String expectedText) {
        versionValue.shouldBe(Condition.visible)
                .shouldHave(Condition.text(expectedText));
        return this;
    }

    public void setStatusInWork() {
        statusInWorkButton.shouldBe(Condition.visible)
                .click();
        closeButtonOfUpdateAlert.shouldBe(Condition.visible)
                .click();
    }

    public void setStatusDone() {
        businessProcessButton.shouldBe(Condition.visible)
                .click();
        statusDoneButton.shouldBe(Condition.visible)
                .click();
    }
}
