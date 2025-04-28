package ifellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;

public class ProjectPage extends BaseAfterLoginPage{

    private final SelenideElement projectName = $x("//*[@id='project-name-val']");
    private final SelenideElement counter = $x("//div[@class='pager']/div[@class='showing']/span") ;

    public ProjectPage checkProjectName(String expectedText) {
        projectName.shouldBe(Condition.visible)
                .shouldHave(Condition.text(expectedText));
        return this;
    }

    private int getCountTasks() {
        return Integer.parseInt(counter.shouldBe(Condition.visible).text().split(" ")[2]);
    }

    public void checkCounter(){
        int previousCount = getCountTasks();
        createTask("Проверка счетчика");
        int currentCount = getCountTasks();
        Assertions.assertEquals(previousCount + 1 , currentCount);
    }

}
