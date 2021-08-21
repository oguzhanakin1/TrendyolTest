package com.testTrendyol;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestByOrder
{
    private static ChromeDriver driver;
    private static final Logger logger = LogManager.getLogger(TestByOrder.class);
    private void setupDriver()
    {
        if(driver == null)
        {
            System.out.println("Initializing driver.");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.trendyol.com/");
        }
    }
    @Test
    public void ALoginPage() throws InterruptedException {
        setupDriver();
        LoginPage login = new LoginPage(driver);
        login.closeAdAndLoginUser(Settings.email, Settings.password);
        logger.info("Login page tested");
    }
    @Test
    public void BSearchBox() throws InterruptedException {
        setupDriver();
        SearchBox search = new SearchBox(driver);
        search.SearchProduct(Settings.searchProduct);
        logger.info("Search box tested");
    }
    @Test
    public void CProductsPage() throws InterruptedException {
        setupDriver();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.findAndAddToFavorites();
        logger.info("Products page tested");
    }
    @Test
    public void DFavoritesPage() throws InterruptedException {
        setupDriver();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        favoritesPage.addToBasketAndRemoveFromFavorites();
        logger.info("Favorites page tested");
    }
    @Test
    public void FCartPage() throws InterruptedException {
        setupDriver();
        CartPage cartPage = new CartPage(driver);
        cartPage.increaseDecreaseAndRemoveItem();
        logger.info("Cart page tested");
    }
}
