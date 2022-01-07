package com.solvd.apiwebtesting.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest implements IAbstractTest {

    /*
    java -Dwebdriver.chrome.driver=D:/selenium/chromedriver.exe -jar D:/selenium/selenium-server-standalone-3.9.0.jar
     */

    @Test
    public void verifyMenuBlock(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Home page wasn't opened");
        MenuBlock menuBlock =  homePage.getMenuBlock();
        Assert.assertTrue(menuBlock.isUIObjectPresent(),"Menu block wasn't found");
    }

    @Test(dependsOnMethods = "verifyMenuBlock")
    public void verifyHomeLink(){
        MenuBlock menuBlock = openMenuBlock();
        HomePage testPage = menuBlock.openHomePage();
        Assert.assertTrue(testPage.isPageOpened(),"Home page wasn't opened");
    }

    @Test(dependsOnMethods = "verifyMenuBlock")
    public void verifyCatalogLink(){
        MenuBlock menuBlock = openMenuBlock();
        CatalogPage testPage = menuBlock.openCatalogPage();
        Assert.assertTrue(testPage.isPageOpened(),"Catalog page wasn't opened");
    }

    private MenuBlock openMenuBlock() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        return homePage.getMenuBlock();
    }
}
