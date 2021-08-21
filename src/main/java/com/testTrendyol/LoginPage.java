package com.testTrendyol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{

    protected WebDriver driver;
    WebDriverWait wait;

    private By closeAd = By.xpath("//*[@class=\"modal-close\"]");
    private By signIn = By.xpath("//*[@class=\"link-text\"]");
    private By byEmail = By.id("login-email");
    private By byPassword = By.id("login-password-input");
    private By login = By.xpath("//*[@class=\"q-primary q-fluid q-button-medium q-button submit\"]");
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,90);
    }

    public LoginPage closeAdAndLoginUser(String email , String password) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(closeAd));
        driver.findElement(closeAd).click();
        logger.info("Selenium tries to sign in");
        wait.until(ExpectedConditions.elementToBeClickable(signIn));
        driver.findElement(signIn).click();
        Thread.sleep(500);
        driver.findElement(byEmail).sendKeys(email);
        Thread.sleep(500);
        driver.findElement(byPassword).sendKeys(password);
        logger.info("User values sent.");
        driver.findElement(login).click();
        Thread.sleep(500);
        logger.info("Clicked to login button.");
        return new LoginPage(driver);
    }

}
