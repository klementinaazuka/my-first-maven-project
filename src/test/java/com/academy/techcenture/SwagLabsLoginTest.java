package com.academy.techcenture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwagLabsLoginTest {


    private WebDriver driver;

    //this method will run before each test case i.e @Test
    @BeforeMethod
    public void beforeEachMethod(){
        //chrome instance configuration
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //navigating to link
        driver.get("https://saucedemo.com");
    }

    @AfterMethod
    public void afterEachMethod(){
        if (driver != null){
            driver.quit();
        }
    }


    @Test(priority = 0)
    public void loginTestPositive(){

        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "Swag Labs", "Login Page titles do not match");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.name("password"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginBtn.isEnabled(), "Login Button is not enabled");

        loginBtn.click();

        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, "Swag Labs", "Home Page titles do not match");
    }

    @Test(priority = 1)
    public void loginTestNegative(){
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "Swag Labs", "Login Page titles do not match");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.name("password"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_s!!!!");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginBtn.isEnabled(), "Login Button is not enabled");

        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));

        Assert.assertTrue(errorMessage.isDisplayed(), "Error message was not displayed");
        String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(errorMessage.getText().trim(),expectedErrorMsg, "Error messages are not the same" );
    }

    @Test(priority = 1)
    public void loginTestEmptyCredentials() throws InterruptedException {
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "Swag Labs", "Login Page titles do not match");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.name("password"));

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginBtn.isEnabled(), "Login Button is not enabled");
        loginBtn.click();

        Thread.sleep(500);

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message was not displayed");
        String expectedErrorMsg = "Epic sadface: Username is required";
        Assert.assertEquals(errorMessage.getText().trim(),expectedErrorMsg, "Error messages are not the same" );

        username.sendKeys("standard_user");
        loginBtn = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginBtn.isEnabled(), "Login Button is not enabled");
        loginBtn.click();

        errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message was not displayed");
        expectedErrorMsg = "Epic sadface: Password is required";
        Assert.assertEquals(errorMessage.getText().trim(),expectedErrorMsg, "Error messages are not the same" );
    }

}
