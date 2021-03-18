package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/a[1]")
    WebElement signInLink;

    @FindBy(id = "dashboard-repos-container")
    WebElement repoContainer;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignInLink(){
        signInLink.click();
    }

    public void waitClickSignInLink(){
       try{
           WebDriverWait wait= new WebDriverWait(driver, 20);
           wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public boolean repoContainerIsDisplay(){
        return repoContainer.isDisplayed();
    }
}
