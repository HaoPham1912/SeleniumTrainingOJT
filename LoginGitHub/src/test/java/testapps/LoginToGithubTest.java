package testapps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import utils.ConfigTestData;

import java.util.concurrent.TimeUnit;

public class LoginToGithubTest {

    WebDriver driver;
    ConfigTestData configTestData = new ConfigTestData();
    HomePage homePage;
    LoginPage loginPage;
    String username = configTestData.getUsername();
    String password = configTestData.getPassword();

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", configTestData.getDriverPath());
        driver = new ChromeDriver();
        driver.get(configTestData.getWebUrl());
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void loginSuccessNormalCase(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.clickSignInLink();
        loginPage.loginAction(username, password);
        Assert.assertTrue(homePage.repoContainerIsDisplay());
    }

    @Test(priority = 1)
    public void loginSuccessExplicitCase(){ ;
        homePage.waitClickSignInLink();
        loginPage.loginAction(username,password);
        Assert.assertTrue(homePage.repoContainerIsDisplay());
    }

    @AfterMethod
    public void resetTimeout(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.quit();
    }
}
