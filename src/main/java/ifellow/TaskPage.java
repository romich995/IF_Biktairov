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
}
