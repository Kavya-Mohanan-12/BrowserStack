package com.browserstack.stepdefs;

import com.browserstack.pageobjects.POSignUpAndSignIn;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SignUpAndSignInSteps
{

    private WebDriver driver;
    private POSignUpAndSignIn signUpAndSignIn;

    @Before
    public void setUp() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> bstackOptions = new HashMap<>();
        bstackOptions.putIfAbsent("source", "cucumber-java:sample-master:v1.2");
        capabilities.setCapability("bstack:options", bstackOptions);
        driver = new RemoteWebDriver(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);
        signUpAndSignIn = new POSignUpAndSignIn(driver);
    }

    @After
    public void teardown(Scenario scenario) throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }


    @Given("I am on the login page of {string}")
    public void i_am_on_the_login_page_of(String string)
    {
        signUpAndSignIn.getApplication(string);
    }
    @When("I enter my username as {string}")
    public void i_enter_my_username_as(String string)
    {
        signUpAndSignIn.enterUserName(string);
    }
    @When("I enter my password as {string}")
    public void i_enter_my_password_as(String string)
    {
        signUpAndSignIn.enterPassword(string);
    }
    @When("I click the login button")
    public void i_click_the_login_button()
    {
        signUpAndSignIn.clickLoginButton();
    }
    @Then("I should see {string}")
    public void i_should_see(String string)
    {
        if(string == "Redirected to home page")
        {
            //signUpAndSignIn.Home.IsShoppingCartContainerDisplayed();
        }
        else if(string == "Sorry, this user has been locked out")
        {
            signUpAndSignIn.isLockedUserErrorDisplayed(string);
        }
        else if(string== "Username and password do not match any user in this service")
        {
            signUpAndSignIn.isLoginErrorDisplayed(string);
        }
    }
}
