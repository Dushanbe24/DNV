package com.dnv_gl.pages;

import com.dnv_gl.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InsightsPage {

    public InsightsPage() {
        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(xpath = "//a[@href='#'][@title='Insights']")
    public WebElement Insights;

    @FindBy(xpath = "//a[@href='/power-renewables/insights/index.html']")
    public WebElement powerAndRenewables;

    @FindBy(xpath = "//a[@title='Sign up']")
    public WebElement signUp;

    @FindBy(id = "id-FirstName")
    public WebElement firstName;

    @FindBy(id = "id-LastName")
    public WebElement lastName;

    @FindBy(id = "id-CompanyName")
    public WebElement companyName;

    @FindBy(id = "id-JobTitle")
    public WebElement jobTitle;

    @FindBy(id = "Country")
    public WebElement country;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(xpath = "//label[@for='Energymanagement']/span")
    public WebElement energyMng;

    @FindBy(xpath = "//label[@for='Solar']/span")
    public WebElement solar;

    @FindBy(xpath = "//iframe[@class='dnvgl-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//label[@for='PrivacyStatement']/span")
    public WebElement privacy;

    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement submit;

    @FindBy(xpath = "//div[@data-lineheight]/span")
    public WebElement feedBackMessage;


    public void clickInsigth() {
        Insights.click();

    }

    public void clickPowerRenewables() {
        powerAndRenewables.click();
    }

    public void scrollDown() {
        Actions actions = new Actions(Driver.get());
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();

        }
    }

    public void clickSignUp() {
        signUp.click();
    }

    public void inputSubscribe() throws InterruptedException {
        Thread.sleep(2000);
        switchIframe();
        firstName.sendKeys("Firuza");
        lastName.sendKeys("Kasirova");
        companyName.sendKeys("DNV-GL");
        jobTitle.sendKeys("QA Automation Engineer");
        email.sendKeys("firuzatest@gmail.com");

    }

    public void selectCountry(String countryName) {
        Select select = new Select(country);
        select.selectByVisibleText(countryName);

    }

    public void clickEngMan() {
        energyMng.click();
    }

    public void clickSolar() {
        solar.click();
    }

    public void switchIframe() {
        Driver.get().switchTo().frame(iframe);

    }

    public void clickPrivacy() {
        privacy.click();
    }

    public void clickSubmit() {
        submit.click();
    }


    public void checkFeedbackMessage(){

        String expectResult = "Thank you for registering your interest to receive email from DNV GL - Energy";
        String actualResult = feedBackMessage.getText().trim();

        Assert.assertEquals(actualResult,expectResult,"The message is not expected");

    }



}
