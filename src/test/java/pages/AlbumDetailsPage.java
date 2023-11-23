package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

@Data
public class AlbumDetailsPage {

    public AlbumDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='rightSection']//h2")
    private WebElement albumName;

    @FindBy(xpath = "//div[@class='rightSection']//p[@role='link']")
    private WebElement artistName;

    @FindBy(xpath = "//div[@class='rightSection']//p[@role='link']//following-sibling::p")
    private WebElement songCount;

    public String getArtistName(){
       return artistName.getText().substring(3);
    }

    public String getSongcount(){
        return songCount.getText().split(" ")[0];
    }

}
