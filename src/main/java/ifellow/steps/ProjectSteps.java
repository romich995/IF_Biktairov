package ifellow.steps;

import ifellow.pages.ProjectPage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class ProjectSteps {

    private final ProjectPage projectPage = new ProjectPage();

    private int countTasks;

    @Когда("^создал задачу")
    public void getCountTasksAndCreateTask() {
        countTasks = projectPage.getCountTasksAndCreateTask();
    }

    @Тогда("^счетчик задач увеличился на 1")
    public void checkCounter() {
        projectPage.checkCounter(countTasks);
    }

    @Когда("^нашел и открыл задачу '(.*)'")
    public void searchAndOpenTask(String taskName) {
        projectPage.searchAndOpenTask(taskName);
    }


}
