package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "login_field")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(name = "commit")
    WebElement signinButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsernameInput(String username){
        usernameField.sendKeys(username);
    }

    public void setPasswordInput(String password){
        passwordField.sendKeys(password);
    }

    public void clickSignInButton(){
        signinButton.click();
    }

    public void loginAction(String username, String password){
        setUsernameInput(username);
        setPasswordInput(password);
        clickSignInButton();
    }
}
