package com.log.selenium;

import com.log.selenium.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
    @Test
    public void verifyGoogleTitle() {
        getDriver().get("https://www.google.com");
        String title = getDriver().getTitle();
        Assert.assertEquals(title, "Google999");
    }
}
