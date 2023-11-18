package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SignUpPage {


    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;


    @FindBy(id = "email2")
    private WebElement email2;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password2")
    private WebElement password2;


    @FindBy(name = "registerButton")
    private WebElement signUplink;



    public void signUpWithValidData(){
        Faker faker = new Faker();
        username.sendKeys(faker.name().username());
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        this.email.sendKeys(email);
        email2.sendKeys(email);
        String pass = faker.internet().password();
        password.sendKeys(pass);
        password2.sendKeys(pass);
        signUplink.click();
    }
}
