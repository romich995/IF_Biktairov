package ifellow;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EduJiraTest extends WebHook {

    private final String login = "AT4";
    private final String password = "Qwerty123";

    @Test
    @DisplayName("Тестирование входа на сайт")
    public void loginTest() {
        BeforeLoginPage beforeLoginPage = Selenide.page(BeforeLoginPage.class);
        beforeLoginPage.login(login, password)
                .checkLogin();
    }

    @Test
    @DisplayName("Тестирование перехода на проект 'Test'")
    public void openTestProjectTest() {
        BeforeLoginPage beforeLoginPage = Selenide.page(BeforeLoginPage.class);
        beforeLoginPage.login(login, password)
                .checkLogin()
                .openTestProject()
                .checkProjectName("Test");

    }

    @Test
    @DisplayName("Тестирование счетчика")
    public void tasksCounterTest() {
        BeforeLoginPage beforeLoginPage = Selenide.page(BeforeLoginPage.class);
        ProjectPage testProjectPage = beforeLoginPage.login(login, password)
                .checkLogin()
                .openTestProject()
                .checkProjectName("Test");

        testProjectPage.checkCounter();
    }

    @Test
    @DisplayName("Тестирование значений версии и статуса задачи TestSeleniumATHomework")
    public void testSeleniumATHomeworkTaskInfoTest() {

        BeforeLoginPage beforeLoginPage = Selenide.page(BeforeLoginPage.class);
        ProjectPage testProjectPage = beforeLoginPage.login(login, password)
                .checkLogin()
                .openTestProject()
                .checkProjectName("Test");

        testProjectPage.checkCounter();

        testProjectPage.searchAndOpenTask("TestSeleniumATHomework")
                .checkVersion("Version 2.0")
                .checkStatus("Сделать");

    }

    @Test
    @DisplayName("Тестирование создания задачи")
    public void createTaskTest() {
        BeforeLoginPage beforeLoginPage = Selenide.page(BeforeLoginPage.class);
        ProjectPage testProjectPage = beforeLoginPage.login(login, password)
                .checkLogin()
                .openTestProject()
                .checkProjectName("Test");

        testProjectPage.checkCounter();

        testProjectPage.searchAndOpenTask("TestSeleniumATHomework")
                .checkVersion("Version 2.0")
                .checkStatus("Сделать");

        testProjectPage.openCreateTaskForm();
        testProjectPage.checkVisualDescriptionButton();
        testProjectPage.checkVisualEnvironmentButton();
        testProjectPage.setTheme("Test theme");
        testProjectPage.setDescription("Test description");
        testProjectPage.setFixVersion("\n                    Version 2.0\n                ");
        testProjectPage.setLabel("testLabel");
        testProjectPage.setEnvironment("Test environment");
        testProjectPage.setAffectedVersion("\n                    Version 2.0\n                ");
        testProjectPage.setLinkedTask();
        testProjectPage.setLinkOnEpic();
        testProjectPage.setSprint();
        testProjectPage.createTask();
        TaskPage testTaskPage = testProjectPage.goToTask();
        testTaskPage.setStatusInWork();
        testTaskPage.setStatusDone();
    }


}
