package ifellow.pages;

import com.codeborne.selenide.*;
import java.io.File;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BaseAfterLoginPage {
    final SelenideElement searchInput = $x("//*[@id='quickSearchInput']").as("Поле ввода для поискка");
    final SelenideElement createTaskButton = $x("//*[@id='create_link']").as("Кнопка создания задачи");
    final SelenideElement themeInput = $x("//*[@id='summary']").as("Поле ввода темы");
    final SelenideElement submitTaskButton = $x("//*[@id='create-issue-submit']").as("Кнопка сабмита задачи");
    final SelenideElement createdTaskAlert = $x("//a[contains(@class,'issue-created-key')]").as("Cсылка на задачу в алерте");
    final String TaskItemXPathTemplate = "//span[text()='%s']";

    final SelenideElement descriptionIFrame = $x("//label[@for='description']/parent::div/descendant::iframe[@class='tox-edit-area__iframe']").as("Айфрайм описания");
    final SelenideElement environmentIFrame = $x("//label[@for='environment']/parent::div/descendant::iframe[@class='tox-edit-area__iframe']").as("Айфрайм окружения");
    final SelenideElement visualDescriptionButton = $x("//label[@for='description']/parent::div/descendant::button[text()='Визуальный']").as("Кнопка Визуальный в описании");
    final SelenideElement visualEnvironmentButton = $x("//label[@for='environment']/parent::div/descendant::button[text()='Визуальный']").as("Кнопка Визуальный в окружении");
    final String fixVersionXPathTemplate = "//*[@id='fixVersions']/descendant::option[text()='%s']";
    final SelenideElement descriptionInput = $x("//body[@id='tinymce']/p").as("Поле ввода описания");
    final SelenideElement environmentInput = $x("//body[@id='tinymce']/p").as("Поле ввода окружения");
    final SelenideElement labelInput = $x("//*[@id='labels-textarea']").as("Поле ввода метки");
    final SelenideElement fileInput = $x("//span[text()='Вложение']/parent::legend/parent::fieldset/descendant::input[@type='file']").as("Поле загрузки файла");
    final String affectedVersionXPathTemplate = "//*[@id='versions']/descendant::option[text()='%s']";
    final SelenideElement linkedTaskDropDownButton = $x("//div[@id='issuelinks-issues-multi-select']/span").as("Кнопка раскрытия выпадающего спика связанных задач");
    final SelenideElement firstLinkedTaskDropDown = $x("//ul[@id='поиск-по-истории']/li[1]").as("Первая связанная таска");
    final SelenideElement linkOnEpicDropDownButton = $x("//div[@id='customfield_10100-single-select']/span").as("Кнопка раскрытия выпадающего списка ссылки на эпик");
    final SelenideElement firstLinkOnEpicDropDown = $x("//*[@id='customfield_10100-suggestions']/descendant::a[@class='aui-list-item-link'][1]").as("Первая ссылка на эпик");
    final SelenideElement sprintDropDownButton = $x("//div[@id='customfield_10104-single-select']/span").as("Кнопка раскрытия выпадающего списка спринтов");
    final SelenideElement firstSprintDropDown = $x("//*[@id='customfield_10104-suggestions']/descendant::a[@class='aui-list-item-link'][1]").as("Первая ссылка на спринт");
    final SelenideElement alertCloseButton = $x("//div[@id='aui-flag-container']//button").as("Кнопка закрытия алерта");


    private void openCreateTaskForm() {
        createTaskButton.shouldBe(Condition.visible)
                .click();
    }

    public TaskPage createAndOpenTestTask() {
        openCreateTaskForm();
        checkVisualDescriptionButton();
        checkVisualEnvironmentButton();
        setTheme("Test theme");
        setDescription("Test description");
        setFixVersion("\n                    Version 2.0\n                ");
        setLabel("testLabel");
        setEnvironment("Test environment");
        setAffectedVersion("\n                    Version 2.0\n                ");
        setLinkedTask();
        setLinkOnEpic();
        setSprint();
        submitTask();
        return goToTask();
    }

    private void submitTask() {
        submitTaskButton.shouldBe(Condition.visible)
                .click();
    }

    private TaskPage goToTask() {
        createdTaskAlert.shouldBe(Condition.visible)
                .click();
        TaskPage testTaskPage = Selenide.page(TaskPage.class);
        return testTaskPage;
    }

    public void createTask(String theme) {
        createTaskButton.shouldBe(Condition.visible)
                .click();
        themeInput.shouldBe(Condition.visible)
                .sendKeys(theme);
        submitTaskButton.shouldBe(Condition.visible)
                .click();
        createdTaskAlert.shouldBe(Condition.exist);
        Selenide.refresh();
    }

    private void checkVisualDescriptionButton() {
        if (!visualDescriptionButton.getAttribute("aria-pressed").equals("true")) {
            visualDescriptionButton.click();
        }
    }

    private void checkVisualEnvironmentButton() {
        if (!visualEnvironmentButton.getAttribute("aria-pressed").equals("true")) {
            visualEnvironmentButton.click();
        }
    }

    private void setTheme(String theme) {
        themeInput.shouldBe(Condition.visible)
                .sendKeys(theme);
    }

    private void setDescription(String description) {
        Selenide.switchTo().frame(descriptionIFrame);
        descriptionInput.shouldBe(Condition.enabled)
                .sendKeys(description);
        Selenide.switchTo().defaultContent();
    }

    private void setFixVersion(String fixVersion) {
        SelenideElement fixVersionOption = $x(fixVersionXPathTemplate.formatted(fixVersion));
        fixVersionOption.shouldBe(Condition.visible)
                .click();
    }

    private void setAffectedVersion(String version) {
        SelenideElement affectedVersionOption = $x(affectedVersionXPathTemplate.formatted(version));
        affectedVersionOption.shouldBe(Condition.visible)
                .click();
    }

    private void setLabel(String label) {
        labelInput.shouldBe(Condition.exist)
                .sendKeys(label);
    }

    private void setEnvironment(String environment) {
        Selenide.switchTo().frame(environmentIFrame);
        environmentInput.shouldBe(Condition.enabled)
                .sendKeys(environment);
        Selenide.switchTo().defaultContent();
    }

    private void setFile(String filePath) {
        fileInput.uploadFile(new File(filePath));
        alertCloseButton.shouldBe(Condition.visible)
                .click();
    }

    private void setLinkedTask() {
        linkedTaskDropDownButton.shouldBe(Condition.visible)
                .click();
        firstLinkedTaskDropDown.shouldBe(Condition.visible)
                .click();
    }

    private void setLinkOnEpic() {
        linkOnEpicDropDownButton.shouldBe(Condition.visible)
                .click();
        firstLinkOnEpicDropDown.shouldBe(Condition.visible)
                .click();
    }

    private void setSprint() {
        sprintDropDownButton.shouldBe(Condition.visible)
                .click();
        firstSprintDropDown.shouldBe(Condition.visible)
                .click();
    }

    private String getTaskItemXPath(String task_Name) {
        return TaskItemXPathTemplate.formatted(task_Name);
    }


    public TaskPage searchAndOpenTask(String taskName) {
        searchInput.shouldBe(Condition.visible)
                .sendKeys(taskName);
        SelenideElement taskItem = $x(getTaskItemXPath(taskName));
        taskItem.shouldBe(Condition.visible)
                .click();

        TaskPage taskPage = Selenide.page(TaskPage.class);
        return taskPage;
    }

}
