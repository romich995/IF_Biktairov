package ifellow;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class EduJiraTest extends WebHook {

    private final String login = System.getenv("JIRA_LOGIN");
    private final String password = System.getenv("JIRA_PASSWORD");

    @Test
    public void loginTest() {
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.login(login, password)
                .checkLogin("Назначенные мне");
    }

    @Test
    public void openTestProjectTest(){
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.login(login, password)
                .checkLogin("Назначенные мне")
                .openTestProject()
                .checkProjectName("Test");

    }

    @Test
    public void tasksCounterTest() {
        LoginPage loginPage = Selenide.page(LoginPage.class);
        ProjectPage testProjectPage = loginPage.login(login, password)
                .checkLogin("Назначенные мне")
                .openTestProject()
                .checkProjectName("Test");

        testProjectPage.checkCounter();
    }

    @Test
    public void testSeleniumATHomeworkTaskInfoTest() {

        LoginPage loginPage = Selenide.page(LoginPage.class);
        ProjectPage testProjectPage = loginPage.login(login, password)
                .checkLogin("Назначенные мне")
                .openTestProject()
                .checkProjectName("Test");

        testProjectPage.checkCounter();

        testProjectPage.searchAndOpenTask("TestSeleniumATHomework")
                .checkVersion("Version 2.0")
                .checkStatus("Сделать");

    }

    @Test
    public void createTaskTest(){
        LoginPage loginPage = Selenide.page(LoginPage.class);
        ProjectPage testProjectPage = loginPage.login(login, password)
                .checkLogin("Назначенные мне")
                .openTestProject()
                .checkProjectName("Test");

        //testProjectPage.checkCounter();

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
        testProjectPage.setFile("/home/t1/IdeaProjects/IF_Biktairov/src/test/resources/test.txt");
        testProjectPage.setAffectedVersion("\n                    Version 2.0\n                ");
        testProjectPage.setLinkedTask();
        //testProjectPage.setLinkOnEpic();
        //testProjectPage.setSprint();
        testProjectPage.createTask();
        TaskPage testTaskPage = testProjectPage.goToTask();
        testTaskPage.setStatusInWork();
        testTaskPage.setStatusDone();
    }


}
