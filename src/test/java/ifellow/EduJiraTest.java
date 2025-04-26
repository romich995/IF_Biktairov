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


}
