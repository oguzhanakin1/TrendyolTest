package com.testTrendyol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage
{
    protected WebDriver driver;
    WebDriverWait wait;
    private By increaseItemCount = By.xpath("//*[@class=\"ty-numeric-counter-button\"]");
    private By numberField = By.xpath("//*[@class=\"counter-content\"]");
    private By decreaseItemCount = By.xpath("//*[@class=\"ty-numeric-counter-button\"]");
    private By removeItem = By.xpath("//*[@class=\"i-trash\"]");
    private By removeItemPopUpButton = By.xpath("//*[@class=\"btn-item btn-remove\"]");
    private static final Logger logger = LogManager.getLogger(CartPage.class);
    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,90);
    }

    public CartPage increaseDecreaseAndRemoveItem() throws InterruptedException {
        logger.info("Selenium in cart page.");
        Thread.sleep(2000);
        boolean isClickable = true;
        try {
            logger.info("Selenium tries to increase product count.");
            driver.findElement(increaseItemCount).click();
        }
        catch (Exception e) {
            logger.info("Selenium could not increase product count. Continuing");
            isClickable = false;
        }
        String itemCount = driver.findElement(numberField).getText();
        Thread.sleep(500);
        if(itemCount.equals("2")) {
            logger.info("Selenium tries to decrease product count.");
            driver.findElement(decreaseItemCount).click();
        }
        Thread.sleep(500);
        logger.info("Selenium tries to remove the product.");
        wait.until(ExpectedConditions.elementToBeClickable(removeItem));
        driver.findElement(removeItem).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(removeItemPopUpButton));
        driver.findElement(removeItemPopUpButton).click();
        logger.info("Products removed from cart");
        return new CartPage(driver);
    }
}
