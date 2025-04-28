package ifellow;

import com.codeborne.selenide.*;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BaseAfterLoginPage {
    final SelenideElement searchInput = $x("//*[@id='quickSearchInput']").as("Поле ввода для поискка");
    final SelenideElement createTaskButton = $x("//*[@id='create_link']").as("Кнопка создания задачи");
    final SelenideElement themeInput = $x("//*[@id='summary']").as("Поле ввода темы");
    final SelenideElement submitTaskButton = $x("//*[@id='create-issue-submit']").as("Кнопка сабмита задачи");
    final SelenideElement createdTaskAlert = $x("//a[contains(@class,'issue-created-key')]");
    final String TaskItemXPathTemplate = "//span[text()='%s']";

    final SelenideElement descriptionIFrame = $x("//label[@for='description']/parent::div/descendant::iframe[@class='tox-edit-area__iframe']");
    final SelenideElement environmentIFrame = $x("//label[@for='environment']/parent::div/descendant::iframe[@class='tox-edit-area__iframe']");
    final SelenideElement visualDescriptionButton = $x("//label[@for='description']/parent::div/descendant::button[text()='Визуальный']");
    final SelenideElement visualEnvironmentButton = $x("//label[@for='environment']/parent::div/descendant::button[text()='Визуальный']");
    final String fixVersionXPathTemplate = "//*[@id='fixVersions']/descendant::option[text()='%s']";
    final SelenideElement descriptionInput = $x("//body[@id='tinymce']/p");
    final SelenideElement environmentInput = $x("//body[@id='tinymce']/p");
    final SelenideElement labelInput = $x("//*[@id='labels-textarea']");
    final SelenideElement fileInput = $x("//span[text()='Вложение']/parent::legend/parent::fieldset/descendant::input[@type='file']");
    final String affectedVersionXPathTemplate = "//*[@id='versions']/descendant::option[text()='%s']";
    final SelenideElement linkedTaskDropDownButton = $x("//div[@id='issuelinks-issues-multi-select']/span");
    final SelenideElement firstLinkedTaskDropDown = $x("//ul[@id='поиск-по-истории']/li[1]");
    final SelenideElement linkOnEpicDropDownButton = $x("//div[@id='customfield_10100-single-select']/span");
    final SelenideElement firstLinkOnEpicDropDown = $x("//ul[@id='предложения']/li[1]");
    final SelenideElement sprintDropDownButton = $x("//div[@id='customfield_10104-single-select']/span");
    final SelenideElement firstSprintDropDown = $x("//ul[@id='предложения']/li[1]");



    public void openCreateTaskForm() {
        createTaskButton.shouldBe(Condition.visible)
                .click();
    }

    public void createTask(){
        submitTaskButton.shouldBe(Condition.visible)
                .click();
    }

    public TaskPage goToTask(){
        createdTaskAlert.shouldBe(Condition.visible)
                .click();
        TaskPage testTaskPage =  Selenide.page(TaskPage.class);
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

    public void checkVisualDescriptionButton() {
        if (!visualDescriptionButton.getAttribute("aria-pressed").equals("true")) {
            visualDescriptionButton.click();
        }
    }

    public void checkVisualEnvironmentButton() {
        if (!visualEnvironmentButton.getAttribute("aria-pressed").equals("true")) {
            visualEnvironmentButton.click();
        }
    }

    public void setTheme(String theme) {
        themeInput.shouldBe(Condition.visible)
                .sendKeys(theme);
    }

    public void setDescription(String description) {
        Selenide.switchTo().frame(descriptionIFrame);
        descriptionInput.shouldBe(Condition.enabled)
                .sendKeys(description);
        Selenide.switchTo().defaultContent();
    }

    public void setFixVersion(String fixVersion) {
        SelenideElement fixVersionOption = $x(fixVersionXPathTemplate.formatted(fixVersion));
        fixVersionOption.shouldBe(Condition.visible)
                .click();
    }

    public void setAffectedVersion(String version) {
        SelenideElement affectedVersionOption = $x(affectedVersionXPathTemplate.formatted(version));
        affectedVersionOption.shouldBe(Condition.visible)
                .click();
    }

    public void setLabel(String label) {
        labelInput.shouldBe(Condition.exist)
                .sendKeys(label);
    }

    public void setEnvironment(String environment) {
        Selenide.switchTo().frame(environmentIFrame);
        environmentInput.shouldBe(Condition.enabled)
                .sendKeys(environment);
        Selenide.switchTo().defaultContent();
    }

    public void setFile(String filePath){
        fileInput.uploadFile(new File(filePath));
    }

    public void setLinkedTask(){
        linkedTaskDropDownButton.shouldBe(Condition.visible)
                .click();
        firstLinkedTaskDropDown.shouldBe(Condition.visible)
                .click();
    }

    public void setLinkOnEpic(){
        linkOnEpicDropDownButton.shouldBe(Condition.visible)
                .click();
        Selenide.sleep(1000);
        $x("//ul[@id='предложения']/li[1]").shouldBe(Condition.visible)
                .click();
    }

    public void setSprint(){
        sprintDropDownButton.shouldBe(Condition.visible)
                .click();
        $x("//ul[@id='предложения']/li[@id='доска-спринт-1-304']").shouldBe(Condition.visible)
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
