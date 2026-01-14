package com.log.selenium;

import com.log.selenium.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
    /**
     * Test 1: Verify title (cố tình FAIL để demo report)
     */
    @Test
    public void verifyGoogleTitle() {
        getDriver().get("https://www.google.com");
        String title = getDriver().getTitle();
        Assert.assertEquals(title, "Google999");
    }

    /**
     * Test 2: Verify current URL (PASS)
     */
    @Test
    public void verifyGoogleUrl() {

        getDriver().get("https://www.google.com");

        String currentUrl = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("google"),
                "Current URL does not contain 'google'"
        );
    }
}
