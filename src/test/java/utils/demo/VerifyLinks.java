package utils.demo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class VerifyLinks {


    @Test
    public void testLinks(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.duotech.io/");
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
           String url = link.getAttribute("href");
            System.out.println(url);
            when().get(url).then().statusCode(200); //rest assured code to check if the link is working
        }
    }
}
