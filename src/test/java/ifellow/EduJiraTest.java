package ifellow;

import com.codeborne.selenide.Selenide;
import ifellow.pages.BeforeLoginPage;
import ifellow.pages.ProjectPage;
import ifellow.pages.TaskPage;
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
        int countTasks = testProjectPage.getCountTasksAndCreateTask();
        testProjectPage.checkCounter(countTasks);
    }

    @Test
    @DisplayName("Тестирование значений версии и статуса задачи TestSeleniumATHomework")
    public void testSeleniumATHomeworkTaskInfoTest() {

        BeforeLoginPage beforeLoginPage = Selenide.page(BeforeLoginPage.class);
        ProjectPage testProjectPage = beforeLoginPage.login(login, password)
                .checkLogin()
                .openTestProject()
                .checkProjectName("Test");

        int countTasks = testProjectPage.getCountTasksAndCreateTask();
        testProjectPage.checkCounter(countTasks);

        TaskPage testSeleniumATHomeworkTaskPage = testProjectPage.searchAndOpenTask("TestSeleniumATHomework");
        testSeleniumATHomeworkTaskPage
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

        int countTasks = testProjectPage.getCountTasksAndCreateTask();
        testProjectPage.checkCounter(countTasks);

        TaskPage testSeleniumATHomeworkTaskPage = testProjectPage.searchAndOpenTask("TestSeleniumATHomework");
        testSeleniumATHomeworkTaskPage
                .checkVersion("Version 2.0")
                .checkStatus("Сделать");

        TaskPage testTaskPage = testSeleniumATHomeworkTaskPage.createAndOpenTestTask();
        testTaskPage.setStatusInWork();
        testTaskPage.setStatusDone();
    }

}
