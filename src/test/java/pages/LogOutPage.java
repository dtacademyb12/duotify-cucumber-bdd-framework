package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LogOutPage {


    public LogOutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

   public void clickOnLink(String text){
        Driver.getDriver().findElement(By.xpath("//button[.='"+text+"']")).click();
   }
}
