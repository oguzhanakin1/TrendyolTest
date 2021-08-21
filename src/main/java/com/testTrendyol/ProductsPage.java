package com.testTrendyol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;
public class ProductsPage {
    protected WebDriver driver;
    WebDriverWait wait;
    private By favIcons = By.xpath("//*[@class=\"fvrt-btn-wrppr\"]");
    private By myFavsButton = By.xpath("//*[@class=\"link\"]");
    private static final Logger logger = LogManager.getLogger(ProductsPage.class);
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,90);
    }
    public ProductsPage findAndAddToFavorites() throws InterruptedException {
        logger.info("Selenium tries to add a random product to favorites.");
        Thread.sleep(2000);
        List <WebElement> favButtons = driver.findElements(favIcons);
        Random random = new Random();
        int randomIndex = random.nextInt(favButtons.size());
        favButtons.get(randomIndex).click();;
        logger.info("Random product added to favorites.");
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(myFavsButton));
        driver.findElement(myFavsButton).click();
        logger.info("Selenium tries to get favorites page");
        Thread.sleep(500);
        return new ProductsPage(driver);
    }
}
