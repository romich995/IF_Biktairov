package ifellow;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BaseAfterLoginPage {
    final SelenideElement searchInput = $x("//*[@id='quickSearchInput']").as("Поле ввода для поискка");
    final SelenideElement createTaskButton = $x("//*[@id='create_link']").as("Кнопка создания задачи");
    final SelenideElement themeInput = $x("//*[@id='summary']").as("Поле ввода темы");
    final SelenideElement submitTaskButton = $x("//*[@id='create-issue-submit']").as("Кнопка сабмита задачи");
    final SelenideElement createdTaskAlert = $x("//a[contains(@class,'issue-created-key')]");
    final String TaskItemXPathTemplate = "//span[text()='%s']";

    public void createTask(String theme){
        createTaskButton.shouldBe(Condition.visible)
                .click();
        themeInput.shouldBe(Condition.visible)
                .sendKeys(theme);
        submitTaskButton.shouldBe(Condition.visible)
                .click();
        createdTaskAlert.shouldBe(Condition.exist);
        Selenide.refresh();
    }

    private String getTaskItemXPath(String task_Name){
        return TaskItemXPathTemplate.formatted(task_Name);
    }


    public TaskPage searchAndOpenTask(String taskName){
        searchInput.shouldBe(Condition.visible)
                .sendKeys(taskName);
        SelenideElement taskItem = $x(getTaskItemXPath(taskName));
        taskItem.shouldBe(Condition.visible)
                .click();

        TaskPage taskPage = Selenide.page(TaskPage.class);
        taskPage.setName(taskName);
        return taskPage;
    }

}
