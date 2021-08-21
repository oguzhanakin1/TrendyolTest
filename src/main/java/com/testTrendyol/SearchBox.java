package com.testTrendyol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SearchBox {
    protected WebDriver driver;
    WebDriverWait wait;
    private By searchArea = By.xpath("//*[@class=\"search-box\"]");
    private By searchIcon = By.xpath("//*[@class=\"search-icon\"]");
    private static final Logger logger = LogManager.getLogger(SearchBox.class);
    public SearchBox(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,90);
    }
    public SearchBox SearchProduct(String searchProduct) throws InterruptedException {
        logger.info("Logged in, searching product");
        Thread.sleep(2000);
        driver.findElement(searchArea).sendKeys(searchProduct);
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        driver.findElement(searchIcon).click();
        logger.info("Product searched");
        Thread.sleep(500);
        return new SearchBox(driver);
    }
}
