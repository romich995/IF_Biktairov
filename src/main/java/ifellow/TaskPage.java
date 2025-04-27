package ifellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;

import static com.codeborne.selenide.Selenide.*;


public class TaskPage extends BaseAfterLoginPage {

    @Getter
    @Setter
    private String name;

    private final SelenideElement statusValue = $x("//span[@id='status-val']/span");
    private final SelenideElement versionValue = $x("//span[@id='fixVersions-field']/a");
    private final SelenideElement statusInWorkButton = $x("//*[@id='action_id_21']");
    private final SelenideElement closeButtonOfUpdateAlert = $x("//div[@id='aui-flag-container']/descendant::button");
    private final SelenideElement businessProcessButton = $x("//*[@id='opsbar-transitions_more']");
    private final SelenideElement statusDoneButton = $x("//*[@id='action_id_31']/a");

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
