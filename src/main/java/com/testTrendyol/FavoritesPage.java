package com.testTrendyol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoritesPage {
    protected WebDriver driver;
    WebDriverWait wait;
    private By basketButton = By.xpath("//*[@class=\"basket-button   \"]");
    private By removeFromFavorites = By.xpath("//*[@class=\"ufvrt-btn-wrppr\"]");
    private By myBasket = By.xpath("//*[@class=\"link account-basket\"]");
    private static final Logger logger = LogManager.getLogger(FavoritesPage.class);
    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,90);
    }
    public FavoritesPage addToBasketAndRemoveFromFavorites() throws InterruptedException {
        logger.info("Selenium in favorites page.");
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,200)");
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(basketButton));
        driver.findElement(basketButton).click();
        logger.info("Product added to cart.");
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,-200)");
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(removeFromFavorites));
        driver.findElement(removeFromFavorites).click();
        logger.info("Product removed from favorites page.");
        Thread.sleep(500);
        driver.findElement(myBasket).click();
        Thread.sleep(500);
        return new FavoritesPage(driver);
    }

}
