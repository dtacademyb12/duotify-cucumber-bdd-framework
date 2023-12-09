package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

@Data
public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='gridViewInfo']")
    private List<WebElement> albums;

    @FindBy(id = "nameFirstAndLast")
    private WebElement name;




    public void clickOnALink(String linkText) {
        String xpath = "//span[@role='link'][contains(text(), '" + linkText +"')]";
      Driver.getDriver().findElement(By.xpath(xpath)).click();
    }


    public void clickOnAlbum(String name){
        String xpath = "//div[@class='gridViewInfo'][.='"+name+"']";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    public WebElement getAlbum(String name){
        String xpath = "//div[@class='gridViewInfo'][.='"+name+"']";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        return element;
    }
}
