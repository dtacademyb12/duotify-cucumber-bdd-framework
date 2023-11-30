package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions (


        features = "src/test/resources/features/parallel",
        glue = "stepDefinitions", // path where step definitions are located
        publish = true, // generates a cloud based html temporary report with a shareable link directly on the console
        plugin = {
                "pretty", // adds more detailed info and logs on the console
                "html:target/cucumber-report/report.html" // generates and stores a local html report file in a given path
        }
//        ,stepNotifications = true // shows individual step results
//        ,dryRun = true // to generate step definition snippets without actually running the code


)
@RunWith(Cucumber.class)
public class CucumberParallelRunner {
}
