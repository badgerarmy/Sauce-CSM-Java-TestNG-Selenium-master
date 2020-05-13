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
 * Created by meganmarshall on 05/06/20.
 */

public class CheckboxTest extends TestBase {

    public CheckboxTest() throws UnsupportedEncodingException {
    }

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void checkTheBox(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Load page");
        GuineaPigPage page = GuineaPigPage.visitPage(driver);

        this.annotate("Checking the unchecked checkbox");
        page.checkBox();


        this.annotate("Assert checkbox checked");
        Assert.assertTrue(page.verifyCheckBox());
    }

}