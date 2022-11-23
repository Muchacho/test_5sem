using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace lab10
{
    internal class PageObjectForSearch
    {   
        private static WebDriver driver = new ChromeDriver("D:\\projects\\BSTU\\5\\tests");
        private dynamic searchResults;
        private IWebElement searchBar;

        public PageObjectForSearch openPage()
        {
            driver.Navigate().GoToUrl("https://www.zara.com/by/ru/search");
            return this;
        }

        public PageObjectForSearch startSearch(string word)
        {
            getSearchBar();
            this.searchBar.SendKeys(word);
            return this;
        }

        private void getSearchBar()
        {
            this.searchBar = driver.FindElement(By.XPath("//*[@id='search-products-form-combo-input']"));
        }

        public PageObjectForSearch getSearchResults()
        {
            Console.WriteLine(driver.FindElements(By.XPath("//li[@class='layout-categories-category layout-categories-category--is-highlighted layout-categories-category--level-1']")).Count() > 0 ? "result exist" : "something going wrong");
            Thread.Sleep(2000);
            return this;
        }
    }
}
