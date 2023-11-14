package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {


    // For this design pattern to work properly, you will need to call Driver.getDriver() everytime you need a WebDriver
    private static WebDriver driver;


    private Driver(){}


    public static WebDriver getDriver(){

        if(driver == null){   // if it is not initialized, initialize it

            //read the browser type from the config file
            String browser = ConfigReader.getProperty("browser").toLowerCase();

            switch (browser){
                case "chrome":
                    driver =  new ChromeDriver();
                    break;
                case "edge":
                    driver =  new EdgeDriver();
                    break;
                case "firefox":
                    driver =  new FirefoxDriver();
                    break;
                case "safari":
                    driver =  new SafariDriver();
                    break;
                default:
                    throw new UnsupportedOperationException(browser + " is not supported. Use chrome, edge, firefox or safari.");

            }



        }

        return driver;  // return the already initailized driver
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }

    }

}
