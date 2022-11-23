using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace lab10
{
    internal class POForCart
    {
        private WebDriver driver;

        public POForCart(WebDriver driver)
        {
            this.driver = driver;
        }

        public POForCart openCartPage()
        {
            driver.Navigate().GoToUrl("https://www.zara.com/by/ru/shop/cart");
            return this;
        }

        public POForCart checkCartItems()
        {
            Console.WriteLine(driver.FindElements(By.XPath("//*[@id='main']/article/div[2]/div[3]/div[1]/div/div/div[2]/ul")).Count() > 0 ? "result exist" : "something going wrong");
            return this;
        }

    }
}
