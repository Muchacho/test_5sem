package com.example.lab12_1.tests;

import com.example.lab12_1.driverSingleton.DriverSingleton;
import com.example.lab12_1.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Ref;

public class Tests {

    @Test
    public void searchProduct(){
        Boolean successful = new SearchPage(DriverSingleton.getDriver())
                .openPage()
                .startSearch("Shirt")
                .isResultExist();
        Assert.assertEquals(true, successful);
    }

    @Test
    public void checkMainLink(){
        Boolean successful = new SearchPage(DriverSingleton.getDriver())
                .openPage()
                .checkMainPageLink();
        Assert.assertEquals(true, successful);
    }

    @Test
    public void changeLanguage(){
        String header = new InfoPage(DriverSingleton.getDriver())
                .openPage()
                .changeLanguage()
                .getHeader();
        Assert.assertEquals("Company", header);
    }

    @Test
    public void checkHelpLink(){
        Boolean successful = new CartPage(DriverSingleton.getDriver())
                .openPage()
                .checkHelpPage();
        Assert.assertEquals(true, successful);
    }

    @Test
    public void checkRegistByEmail(){
        String notification = new RegistPage(DriverSingleton.getDriver())
                .openPage()
                .checkEmail("qwe");
        Assert.assertEquals("Введите действительный адрес электронной почты.", notification);
    }

    @Test
    public void checkRegistByPhone(){
        String notification = new RegistPage(DriverSingleton.getDriver())
                .openPage()
                .checkPhone("qwe");
        Assert.assertEquals("Неверный номер телефона", notification);
    }

    @Test
    public void addProductToCart() throws InterruptedException {
        Boolean b = new ProductsPage(DriverSingleton.getDriver())
                .openPage()
                .addProduct()
                .zaglushka();
        Assert.assertEquals(false, b);
    }
}
