package com.springernature.fluffy.testpages;


import com.springernature.fluffy.basetest.BaseTest;
import org.junit.*;
import com.springernature.fluffy.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePagePageTest extends BaseTest
{
    private static HomePage homePage;

    @Before
    public void beforeTest()
    {
        homePage = new HomePage(getDriver());
        homePage.open();
    }

    @After
    public void afterTest()
    {
        homePage.close();
    }

    @AfterClass
    public static void afterClass()
    {
        homePage.quit();
    }

    @Test
    public void searchForTextReturnsResults()
    {
        homePage.searchFor("corona virus")
                .returnsResults()
                .checkSearchTerm("corona virus");
    }

    @Test
    public void checkChangeLanguageToDeutsch() {
        homePage.clickLanguageButton();
        WebDriverWait wait = new WebDriverWait(getDriver(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cross-nav cross-nav--wide']//button[@class='flyout-caption cur']/span")));
        homePage.changeLanguageDeutsch().checkLanguage("Deutsch");
    }

}
