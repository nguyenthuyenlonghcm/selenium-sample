package com.log.selenium.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.log.selenium.base.BaseTest;
import com.log.selenium.utils.ExtentManager;
import com.log.selenium.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getExtent();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        Object testClass = result.getInstance();

        WebDriver driver =
                ((BaseTest) testClass).getDriver();

        String screenshotPath =
                ScreenshotUtils.takeScreenshot(
                        driver,
                        result.getMethod().getMethodName()
                );

        test.get().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
