package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class Hooks {



    @Before
    public  void setupScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicit.wait"))));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After
    public  void tearDownScenario(){
        Driver.quitDriver();
    }

}
