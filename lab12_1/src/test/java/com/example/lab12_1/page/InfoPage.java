package com.example.lab12_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InfoPage {
    private WebDriver driver;

    static final String BASE_URL = "https://www.zara.com/by/ru/z-kompaniya-corp1391.html?v1=11112";

    static final By englishLanguageLinkLocator = By.xpath("//*[@id=\"theme-app\"]/div/div/footer/div/div[2]/div[2]/div/nav/ul/li[1]/a");

    static final By companyHeaderLocator = By.xpath("//*[@id=\"main\"]/article/div/div/header/h2");

    public InfoPage() {}

    public InfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public InfoPage openPage(){
        driver.navigate().to(BASE_URL);
        return this;
    }

    public InfoPage changeLanguage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(englishLanguageLinkLocator))).click();
        return this;
    }

    public String getHeader(){
        WebElement header = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(companyHeaderLocator)));
        return header.getText();
    }
}
