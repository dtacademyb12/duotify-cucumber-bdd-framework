package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class UserDetailsPage {

    public UserDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//span[@class='message'][.='Update successful']")
    public WebElement successMessage;
    public void updateEmail(String newEmail){
        Driver.getDriver().findElement(By.name("email")).clear();
        Driver.getDriver().findElement(By.name("email")).sendKeys(newEmail);
        Driver.getDriver().findElement(By.xpath("//div[@class='container borderBottom']//button[.='SAVE']")).click();
    }
}
