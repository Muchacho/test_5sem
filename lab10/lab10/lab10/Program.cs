using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab10
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //SearchingTest();
            HelpTest();
        }
            

        static void SearchingTest()
        {
            PageObjectForSearch pageObjectForSearch = new PageObjectForSearch();
            pageObjectForSearch.openPage().startSearch("shirt").getSearchResults();
        }

        static void HelpTest()
        {
            PageObjectForHelp pageObjectForHelp = new PageObjectForHelp();
            pageObjectForHelp.openPage().ClickHelpButton().checkPage();
        }
    }
}
