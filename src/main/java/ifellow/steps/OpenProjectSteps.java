package ifellow.steps;

import ifellow.pages.AfterLoginPage;
import ifellow.pages.ProjectPage;
import io.cucumber.java.After;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class OpenProjectSteps {

    private final AfterLoginPage afterLoginPage = new AfterLoginPage();
    private final ProjectPage projectPage = new ProjectPage();

    @Когда("^открываю проект 'Test'")
    public void openProjectTest() {
        afterLoginPage.openTestProject();
    }

    @Тогда("^на странице присутствует наименование задачи 'Test'")
    public void checkProjectNameOnThePage() {
        projectPage.checkProjectName("Test");
    }
}
