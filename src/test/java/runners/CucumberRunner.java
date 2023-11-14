package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions (

        tags = "@redirect",
        features = "src/test/resources", // path where feature files are located
        glue = "stepDefinitions" // path where step definitions are located


)
@RunWith(Cucumber.class)
public class CucumberRunner {

}
