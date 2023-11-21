package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {




    // For this design pattern to work properly, you will need to call Driver.getDriver() everytime you need a WebDriver
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();


    private Driver(){}


    public static synchronized WebDriver getDriver(){

        if(drivers.get() == null){   // if it is not initialized, initialize it

            String browser = System.getProperty("browser"); // read the browser value from command line


            if(browser == null){ // if nothing was passed through cmd
                browser = ConfigReader.getProperty("browser").toLowerCase(); //read the browser type from the config file
            }


            switch (browser){
                case "chrome":
                    drivers.set(new ChromeDriver());
                    break;
                case "chromeheadless":
                    drivers.set(new ChromeDriver(new ChromeOptions().addArguments("--headless").addArguments("window-size=1920x1080")));
                    break;
                case "edge":
                    drivers.set(new EdgeDriver());
                    break;
                case "edgeheadless":
                    drivers.set(new EdgeDriver(new EdgeOptions().addArguments("--headless").addArguments("window-size=1920x1080")));
                    break;
                case "firefox":
                    drivers.set(new FirefoxDriver());
                    break;
                case "firefoxheadless":
                    drivers.set(new FirefoxDriver(new FirefoxOptions().addArguments("--headless").addArguments("window-size=1920x1080")));
                    break;
                case "safari":
                    drivers.set(new SafariDriver());
                    break;
                default:
                    throw new UnsupportedOperationException(browser + " is not supported. Use chrome, edge, firefox or safari.");

            }



        }

        return drivers.get();  // return the already initailized driver
    }

    public static synchronized void quitDriver(){
        if(drivers.get() != null){
            drivers.get().quit();
            drivers.remove();
        }

    }

}
