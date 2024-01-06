package stepDefinitions;

import io.cucumber.java.*;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.DBUtils;
import utils.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

public class Hooks {



    @Before ("not (@db_only or @api_only)")
    public  void setupScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicit.wait"))));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }


    @Before ("@API")
    public  void setupScenarioAPI()  {
        RestAssured.baseURI = ConfigReader.getProperty("api.base.uri");
    }



    @Before ("@DB")  // before each scenario tagged with @DB
    public  void setupScenarioDB()  {
        DBUtils.createConnection();
    }

    @After ("@DB")  // after each scenario tagged with @DB
    public  void tearDownScenarioDB()  {
        DBUtils.close();
    }

    //    @Before ("@DB or @API")  // before each scenario related to DB or API
//    public  void setupScenarioDB()  {
//        System.out.println("Create db connection");
//    }

    //@Before ("@UI")  // conditionally tagged hooks
    //    public  void setupScenario(){
    //        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicit.wait"))));
    //        Driver.getDriver().manage().window().maximize();
    //        Driver.getDriver().get(ConfigReader.getProperty("url"));
    //    }


//    @Before (order = 2) // before each scenario
//    public  void setupScenario2(){
//        System.out.println("Before each scenario");
//    }
//
//    @After (order = 2) // after each scenario
//    public  void tearScenario2(){
//        System.out.println("After each scenario");
//    }

//    @BeforeStep
//    public void setupEachStep(){
//        System.out.println("Before each Step");
//    }
//
//    @AfterStep
//    public void tearEachStep(){
//        System.out.println("After each Step");
//    }
//
//
//    @BeforeAll
//    public static void beforeAllScenarios(){
//        System.out.println("Before All scenarios");
//    }
//
//    @AfterAll
//    public static void tearAllScenarios(){
//        System.out.println("After All scenarios");
//    }


    @After // after each scenario
    public  void tearDownScenario(Scenario scenario){

        if(scenario.isFailed()){
            byte[] screenshotFile = ((TakesScreenshot) (Driver.getDriver())).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotFile, "image/png", "screenshot" );
        }

        Driver.quitDriver();
    }

}
