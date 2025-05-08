package ifellow.steps;

import ifellow.pages.TaskPage;
import io.cucumber.java.ru.Тогда;

public class TaskSteps {

    private final TaskPage taskPage = new TaskPage();

    @Тогда("^на странице версия задачи '(.*)' и статус задачи '(.*)'")
    public void checkVersionAndStatus(String version, String status) {
        taskPage.checkVersion(version)
                .checkStatus(status);
    }
}
