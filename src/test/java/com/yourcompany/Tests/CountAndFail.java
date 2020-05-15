package com.yourcompany.Tests;

import com.yourcompany.Pages.GuineaPigPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

/**
 * Created by meganmarshall on 05/15/20.
 */

public class CountAndFail extends TestBase {

    public CountAndFail() throws UnsupportedEncodingException {
    }

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void findTextTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting GuineaPig page...");
        GuineaPigPage page = GuineaPigPage.visitPage(driver);

        this.annotate("Looking for text...");
        boolean findThisText = driver.getPageSource().contains("I am some page content");

        this.annotate("Asserting that we are on a new page...");
        Assert.assertTrue(findThisText);
    }

}