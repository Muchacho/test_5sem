using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace lab10
{
    internal class PageObjectForCart
    {
        private static WebDriver driver = new ChromeDriver("D:\\projects\\BSTU\\5\\tests");
        private IWebElement addButton;
        private IWebElement choiseSize;

        public PageObjectForCart openPage()
        {
            driver.Navigate().GoToUrl("https://www.zara.com/by/ru/muzhchiny-rubashki-l737.html?v1=2113199");
            return this;
        }

        public PageObjectForCart addItemInCart()
        {
            Thread.Sleep(3000);
            driver.FindElement(By.XPath("//*[@id='onetrust-close-btn-container']/button")).Click();
            ClickAddButton();
            ChoosingSize();
            return this;
        }

        private void ClickAddButton()
        {
            driver.FindElement(By.XPath("//*[@id='main']/article/div[2]/section[1]/ul/li[1]/a/div[2]/button")).Click();
        }

        private void ChoosingSize()
        {
            driver.FindElement(By.XPath("//*[@id='product - size - selector - 228110437 - item - 0']")).Click();
        }

        public POForCart openCart()
        {
            POForCart newDriver = new POForCart(driver);
            return newDriver.openCartPage();
        }
    }
}
