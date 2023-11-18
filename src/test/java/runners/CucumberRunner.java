package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions (

        tags = "@temp",
        features = "src/test/resources/features", // path where feature files are located
        glue = "stepDefinitions" // path where step definitions are located
//        ,dryRun = true // to generate step definition snippets without actually running the code


)
@RunWith(Cucumber.class)
public class CucumberRunner {
}
