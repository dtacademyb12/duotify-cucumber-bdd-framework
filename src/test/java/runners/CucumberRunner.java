package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions (

//        tags = "@smoke", // all scenarios tagged with @temp
//        tags = "@SMOKE and @REGRESSION", // scenarios that contain BOTH tags
//        tags = "@SMOKE or @REGRESSION or @temp", // scenarios that contain any of the  tags
//        tags = "(@SMOKE and @REGRESSION) or @temp", // scenarios that contain either first combo or second one
//        tags = "not @signUp", // scenarios that DO NOT contain @signUp
        features = "src/test/resources/features", // path where feature files are located
        glue = "stepDefinitions", // path where step definitions are located
        publish = true, // generates a cloud based html temporary report with a shareable link directly on the console
        plugin = {
                "pretty", // adds more detailed info and logs on the console
                "html:target/cucumber-report/report.html" // generates and stores a local html report file in a given path
        }
        ,stepNotifications = true // shows individual step results
//        ,dryRun = true // to generate step definition snippets without actually running the code


)
@RunWith(Cucumber.class)
public class CucumberRunner {
}
