package lab.mf;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class CucumberRunner implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getExtensions().create("cucumber", CucumberExtension.class);
        CucumberTask cucumber = project.getTasks().create("cucumber", CucumberTask.class, true);
        CucumberTask karate = project.getTasks().create("karate", CucumberTask.class, false);

        project.afterEvaluate((p) -> cucumber.dependsOn(p.getTasks().getByName("testClasses")));
        project.afterEvaluate((p) -> karate.dependsOn(p.getTasks().getByName("testClasses")));
    }
}
