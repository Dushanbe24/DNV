package com.dnv_gl.tests;

import com.dnv_gl.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{


    @Test
    public void Test2() throws InterruptedException {

        extentTest = report.createTest("Login Test");


        extentTest.info("go to url");
        driver.get(ConfigurationReader.get("url"));



        extentTest.info("click Sign Veracity");
        login.clickSignVeracity();
        extentTest.info("Input Login");
        login.inputLogin();
        extentTest.info("Accept All Cookies");
        login.acceptAllCookies();
        extentTest.info("select Marketplace");
        login.selectMarketplace();
        extentTest.info("select Maritime");
        login.selectMaritime();
        extentTest.info("select Alternative Page");
        login.selectAlternativePage();
        extentTest.info("click Free Access");
        login.clickFreeAccess();
        extentTest.info("check Feed Back Message");
        login.checkFeedBackMessage();












    }


    }
