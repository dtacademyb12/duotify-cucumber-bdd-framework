package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class PlaylistDetailsPage {


    public PlaylistDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//div[@class='rightSection']//h2")
    private WebElement name;

    @FindBy(xpath = "//div[@class='rightSection']//p[1]")
    private WebElement username;

    @FindBy(xpath = "//div[@class='rightSection']//p[2]")
    private WebElement countSongs;









}
