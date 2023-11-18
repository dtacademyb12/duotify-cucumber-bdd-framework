package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "loginUsername")
    private WebElement username;

    @FindBy(id = "hideLogin")
    private WebElement signUpPageLink;

    @FindBy(id = "loginPassword")
    private WebElement password;


    @FindBy(name = "loginButton")
    private WebElement signInButton;

    @FindBy(xpath= "//span[contains(text(), 'incorrect')]")
    private WebElement errorMessage;




}
