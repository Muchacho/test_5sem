package com.example.lab12_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    private WebDriver driver;
    private final String BASE_URL = "https://www.zara.com/by/ru/search";
    private final By searchBarLocator = By.xpath("//*[@id='search-products-form-combo-input']");
    private final By firstResultElementLocator = By.xpath(("//*[@id='main']/article/div/div/section/div[2]/section[1]/ul/li[1]"));
    private final By mainPageLinkLocator = By.xpath("//*[@id=\"theme-app\"]/div/div/header/div/div[1]/div/div/h1/a");
    public SearchPage(){};

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage openPage(){
        driver.navigate().to(BASE_URL);
        return this;
    }

    public SearchPage startSearch(String word){
        WebElement searchBar = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(searchBarLocator)));
        searchBar.sendKeys(word);
        return this;
    }

    public Boolean isResultExist(){
//        driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")))).click();
        WebElement result =  new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(firstResultElementLocator)));
        System.out.println(result);
        if(result != null){
            return true;
        }
        else return false;
    }

    public Boolean checkMainPageLink(){
        System.out.println(driver.getCurrentUrl());
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(mainPageLinkLocator))).click();
        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl() == BASE_URL){
            return false;
        } else return true;
    }
}
