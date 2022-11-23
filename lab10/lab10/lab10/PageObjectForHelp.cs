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
    internal class PageObjectForHelp
    {
        private static WebDriver driver = new ChromeDriver("D:\\projects\\BSTU\\5\\tests");
        private IWebElement helpButton;

        public PageObjectForHelp openPage()
        {
            driver.Navigate().GoToUrl("https://www.zara.com/by/ru/logon");
            return this;
        }

        public PageObjectForHelp ClickHelpButton()
        {
            Thread.Sleep(3000);
            driver.FindElement(By.XPath("//*[@id='onetrust-close-btn-container']/button")).Click();
            getHelpButton();
            helpButton.Click();
            checkPage();
            return this;
        }

        private void getHelpButton()
        {
            this.helpButton = driver.FindElement(By.XPath("//*[@id='theme-app']/div/div/header/div/div[2]/div/a[1]"));
        }

        public void checkPage()
        {
            Console.WriteLine(driver.Url.ToString() == "https://www.zara.com/by/ru/" ? "yra" : "not yra");
        }
    }
}
