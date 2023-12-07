package pages;

import lombok.Data;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class PlaylistsPage {


    public PlaylistsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    public void clickOnPlaylist(String name){
        Driver.getDriver().findElement(By.xpath("//div[@class='gridViewInfo'][.='"+name+"']")).click();
    }


        public void createPlaylist(String name){
        Driver.getDriver().findElement(By.xpath("//button[.='NEW PLAYLIST']")).click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(name);
        alert.accept();

    }





}
