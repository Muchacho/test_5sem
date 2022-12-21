package com.example.lab12_1.tests;

import com.example.lab12_1.driverSingleton.DriverSingleton;
import com.example.lab12_1.page.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.sql.Ref;

public class Tests {

    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
    }
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id);
    }
    @Test
    public void searchProduct() throws MalformedURLException {
        Boolean successful = new SearchPage(DriverSingleton.getRemoteDriver())
                .openPage()
                .startSearch("Shirt")
                .isResultExist();
        assertThat(successful).isTrue();
//        Assert.assertEquals(true, successful);
    }

    @Test
    public void checkMainLink(){
        Boolean successful = new SearchPage(DriverSingleton.getDriver())
                .openPage()
                .checkMainPageLink();
        assertThat(successful).isTrue();
    }

    @Test
    public void changeLanguage(){
        String header = new InfoPage(DriverSingleton.getDriver())
                .openPage()
                .changeLanguage()
                .getHeader();
        assertThat("Company").isEqualTo(header);
    }

    @Test
    public void checkHelpLink(){
        Boolean successful = new CartPage(DriverSingleton.getDriver())
                .openPage()
                .checkHelpPage();
        assertThat(successful).isTrue();
    }

    @Test
    public void checkRegistByEmail(){
        String notification = new RegistPage(DriverSingleton.getDriver())
                .openPage()
                .checkEmail("qwe");
        assertThat(notification).isNotEmpty();
    }

    @Test
    public void checkRegistByPhone(){
        String notification = new RegistPage(DriverSingleton.getDriver())
                .openPage()
                .checkPhone("qwe");
        assertThat(notification).isNotEmpty();
//        assertThat("Неверный номер телефона").isEqualTo(notification);
//        Assert.assertEquals("Неверный номер телефона", notification);
    }

    @Test
    public void addProductToCart() throws InterruptedException {
        Boolean successful = new ProductsPage(DriverSingleton.getDriver())
                .openPage()
                .addProduct()
                .getProduct();
        assertThat(successful).isTrue();
    }
}
