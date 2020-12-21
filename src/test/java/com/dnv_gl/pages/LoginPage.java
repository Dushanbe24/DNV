package com.dnv_gl.pages;

import com.dnv_gl.tests.TestBase;
import com.dnv_gl.utilities.ConfigurationReader;
import com.dnv_gl.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage  {


    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(css = "a.the-header__login")
    public WebElement signInVeracity;

    @FindBy(id = "userNameInput")
    public WebElement emailInput;

    @FindBy(id = "passwordInput")
    public WebElement passwordInput;

    @FindBy(id = "submitButton")
    public WebElement submitBtn;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookies;


    @FindBy(xpath = " //a[@title='Visit the Veracity Marketplace']")
    public WebElement marketplace;


    @FindBy(xpath = "//label[@for='maritime']/span")
    public WebElement maritime;


    @FindBy(xpath = "//a[@href='/alternative-fuels-insight-platform-afi']")
    public WebElement alternative;


    @FindBy(xpath = "//button[@data-gtm-action='Free access']")
    public WebElement freeAccess;

     @FindBy(xpath = "(//span)[7]/..")
    public WebElement feedBackMessage;








    public void clickSignVeracity() {
        signInVeracity.click();
    }

    public void inputLogin() throws InterruptedException {
        Thread.sleep(2000);

        String username = ConfigurationReader.get("email");
        String password = ConfigurationReader.get("password");
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitBtn.click();

    }

    public void acceptAllCookies() {
        cookies.click();
    }

    public void selectMarketplace() {
        marketplace.click();
    }

    public void selectMaritime(){
        maritime.click();
    }

    public void selectAlternativePage(){
           alternative.click();
    }

    public void  clickFreeAccess() {
        freeAccess.click();
    }
    public void checkFeedBackMessage() throws InterruptedException {
        String expected = "Thanks for your interest in Alternative Fuels Insight Platform (AFI)";
        Thread.sleep(2000);
        String actual = feedBackMessage.getText().trim();

        Assert.assertEquals(actual,expected,"The message is not expected");



    }
}
