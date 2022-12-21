package com.example.lab12_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistPage {
    private WebDriver driver;

    static final String BASE_URL = "https://www.zara.com/by/ru/signup";

    static final By emailInputLocator = By.xpath("//*[@id=\"address-form\"]/div[1]/div[2]/div/div/div[1]/input");
    static final By phoneInputLocator = By.xpath("//*[@id=\"address-form\"]/div[1]/div[14]/div[2]/div/div/input");
    static final By Locator = By.xpath("");
    //static final By Locator = By.xpath("");

    public RegistPage() {}

    public RegistPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistPage openPage(){
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String checkEmail(String email){
        WebElement emailBar = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(emailInputLocator)));
        emailBar.sendKeys(email);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"theme-app\"]/div/div/div[2]")))).click();
        WebElement notification = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form-input__desc-email\"]"))));
        return notification.getText();
    }

    public String checkPhone(String phone){
        WebElement searchBar = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(phoneInputLocator)));
        searchBar.sendKeys(phone);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"theme-app\"]/div/div/div[2]")))).click();
        WebElement notification = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form-input__desc-phones[0].subscriberNumber\"]"))));
        System.out.println(notification.getText());
        return  notification.getText();
    }
}
