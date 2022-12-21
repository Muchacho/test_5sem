package com.example.lab12_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;

    static final String BASE_URL = "https://www.zara.com/by/ru/shop/cart";

    static final By helpLinkLocator = By.xpath("//*[@id=\"theme-app\"]/div/div/header/div/div[2]/div/a[2]");

    public CartPage() {}

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage openPage(){
        driver.navigate().to(BASE_URL);
        return this;
    }

    public Boolean checkHelpPage(){
        System.out.println(driver.getCurrentUrl());
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(helpLinkLocator))).click();
        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl() == "https://www.zara.com/by/ru/help"){
            return false;
        } else return true;
    }

}
