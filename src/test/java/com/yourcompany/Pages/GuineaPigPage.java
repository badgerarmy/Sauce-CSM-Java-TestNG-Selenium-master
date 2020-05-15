package com.yourcompany.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.util.List;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;


public class GuineaPigPage {

    @FindBy(linkText = "i am a link")
    private WebElement theActiveLink;

    @FindBy(id = "your_comments")
    private WebElement yourCommentsSpan;

    @FindBy(id = "comments")
    private WebElement commentsTextAreaInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "fbemail")
    private WebElement emailTextAreaInput;

    public WebDriver driver;
    public static String url = "https://saucelabs.github.io/training-test-page";

    public static GuineaPigPage visitPage(WebDriver driver) {
        GuineaPigPage page = new GuineaPigPage(driver);
        page.visitPage();
        return page;
    }

    public GuineaPigPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void followLink() {
        theActiveLink.click();
    }

    public void submitComment(String text) {
        commentsTextAreaInput.sendKeys(text);
        submitButton.click();
    }

    public void submitEmail(String text) {
        emailTextAreaInput.sendKeys(text);
        submitButton.click();
    }

    public void checkBox() {
        WebElement target = driver.findElement(By.id("unchecked_checkbox"));
        target.click();
    }

    public boolean verifyCheckBox() {
        WebElement target = driver.findElement(By.id("unchecked_checkbox"));
        return target.isSelected();
    }

    public String getSubmittedCommentText() {
        return yourCommentsSpan.getText();
    }

    public boolean isOnPage() {
        String title = "I am a page title - Sauce Labs";
        return driver.getTitle() == title;
    }

}
