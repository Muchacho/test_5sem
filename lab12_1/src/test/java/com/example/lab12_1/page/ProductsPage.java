package com.example.lab12_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private WebDriver driver;

    static final String BASE_URL = "https://www.zara.com/by/ru/zhenshchiny-blejzery-l1055.html?v1=2113388";

    static final By addProductButtonLocator = By.id("product-size-selector-222748511-toggle-button");
    static final By addProductButtonLocator1 = By.xpath("//*[@id=\"main\"]/article/div[2]/section[1]/ul/li[1]/ul[2]/li/a/div[2]/button/div");

    static final By productSizeLocator = By.xpath("//*[@id=\"product-size-selector-222748511-item-0\"]");

    static final By companyHeaderLocator = By.xpath("//*[@id=\"main\"]/article/div/div/header/h2");

    static final By mainPageLocator = By.xpath("//*[@id=\"main\"]/article/div[2]/a[2]");

    public ProductsPage() {}

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductsPage openPage(){
        driver.navigate().to(BASE_URL);
        return this;
    }

    public ProductsPage addProduct() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")))).click();
        Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(addProductButtonLocator1))).click();
        Thread.sleep(5000);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(productSizeLocator))).click();
        return this;
    }
    public boolean getProduct(){
        return true;
    }
}
