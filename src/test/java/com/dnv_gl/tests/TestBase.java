package com.dnv_gl.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.dnv_gl.pages.InsightsPage;
import com.dnv_gl.pages.LoginPage;
import com.dnv_gl.utilities.ConfigurationReader;
import com.dnv_gl.utilities.Driver;
import com.dnv_gl.utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {


    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    InsightsPage insights = new InsightsPage();
    LoginPage login = new LoginPage();
    protected static ExtentReports report;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentTest;


    @BeforeClass
    public void setUp() {

        report = new ExtentReports();
        String projectpath = System.getProperty("user.dir");
        String path = projectpath + "/test-output/report.html";


        htmlReporter = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("DNV_GL test");

        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", "os.name");

    }

    @AfterTest
    public void tearDownTest() {
        report.flush();

    }


    @BeforeMethod
    public void setUpMethod() {

        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);

    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Case is skipped: " + result.getName());
        }

        Driver.closeDriver();
    }
}