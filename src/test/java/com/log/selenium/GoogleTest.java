package com.log.selenium;

import com.log.selenium.base.BaseTest;
import com.log.selenium.utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void verifyGoogleTitle() {

        ExtentTestManager.getTest()
                .info("Open Google homepage");

        getDriver().get("https://www.google.com");

        ExtentTestManager.getTest()
                .info("Get page title");

        String title = getDriver().getTitle();

        ExtentTestManager.getTest()
                .info("VP: Verify page title");

        Assert.assertEquals(title, "Google999"); // cố tình FAIL
    }

    @Test
    public void verifyGoogleUrl() {

        ExtentTestManager.getTest()
                .info("Open Google homepage");

        getDriver().get("https://www.google.com");

        ExtentTestManager.getTest()
                .info("Get current URL");

        String currentUrl = getDriver().getCurrentUrl();

        ExtentTestManager.getTest()
                .info("VP: Verify current URL contains 'google'");

        Assert.assertTrue(
                currentUrl.contains("google"),
                "Current URL does not contain 'google'"
        );

        ExtentTestManager.getTest()
                .pass("Verify Google URL PASSED");
    }
}
