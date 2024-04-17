package com.browserstack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class POSignUpAndSignIn
{
    private WebDriver webDriver;

    private By TxtUserName = By.xpath("//input[@data-test='username']");
    private By TxtPassword = By.xpath("//input[@data-test='password']");
    private By BtnLogin = By.xpath("//input[@data-test='login-button']");
    private By ErrorMsg = By.xpath("//h3[@data-test='error']");
    private By buttonLockedUser = By.xpath("//button[contains(@class, 'error-button')]");
    private By h3LocatorError = By.xpath("//h3[contains(@data-test, 'error')]");

    public POSignUpAndSignIn(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }
    public void getApplication(String url) {
        webDriver.navigate().to(url);
    }
    public void enterUserName(String userName)
    {
        //new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TxtUserName));
        WebElement userNameElement = webDriver.findElement(TxtUserName);
        userNameElement.sendKeys(userName);
    }

    public void enterPassword(String password)
    {
        //new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TxtPassword));
        WebElement passwordElement = webDriver.findElement(TxtPassword);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton()
    {
        //new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BtnLogin));
        WebElement loginButtonElement = webDriver.findElement(BtnLogin);
        loginButtonElement.click();
    }

    public void isLoginErrorDisplayed(String expected) {
        //new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ErrorMsg));
        WebElement errorMsgElement = webDriver.findElement(ErrorMsg);
        Assert.assertTrue(errorMsgElement.isDisplayed(), "ErrorMsg Is Not Displayed");
        Assert.assertTrue(errorMsgElement.getText().contains(expected));
    }

    public void isLockedUserErrorDisplayed(String expected) {
        //new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(h3LocatorError));
        WebElement h3LocatorErrorElement = webDriver.findElement(h3LocatorError);
        Assert.assertTrue(h3LocatorErrorElement.getText().contains(expected));
    }
}
