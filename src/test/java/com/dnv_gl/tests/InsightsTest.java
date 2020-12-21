package com.dnv_gl.tests;

import com.dnv_gl.utilities.ConfigurationReader;
import org.testng.annotations.Test;


public class InsightsTest  extends TestBase{


    @Test
    public void Test1() throws InterruptedException {


       extentTest = report.createTest("Login Test");
       extentTest.info("go to url");

       driver.get(ConfigurationReader.get("url"));

       extentTest.info("click  Insigth");
       insights.clickInsigth();
       extentTest.info(" click Power Renewable");
       insights.clickPowerRenewables();

       extentTest.info("scroll Down");
       insights.scrollDown();
       extentTest.info(" click Sign Up");
       insights.clickSignUp();
       extentTest.info("enter Subscribe");
       insights.inputSubscribe();
       extentTest.info("select Country");
       insights.selectCountry("Spain");

       extentTest.info("click Energy Management");
       insights.clickEngMan();
       extentTest.info("click Solar");
       insights.clickSolar();

       extentTest.info("click Privacy");
       insights.clickPrivacy();

       extentTest.info("click Submit");
       insights.clickSubmit();

       extentTest.info("check Feedback message");
       insights.checkFeedbackMessage();





          }
}
