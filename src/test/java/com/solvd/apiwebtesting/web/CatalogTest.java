package com.solvd.apiwebtesting.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Locale;

public class CatalogTest implements IAbstractTest {

    @Test()
    public void verifyCategory(){
        CatalogPage catalogPage = goToCatalogPage();
        CategoryBlock categories = catalogPage.getCategories();
        Assert.assertTrue(categories.isUIObjectPresent(),"No categories found");
        Assert.assertTrue(categories.getElectronicCategory().isElementPresent(),"Electronic category not found");;
    }

    @Test()
    public void verifyTv(){
        CatalogPage catalogPage = goToCatalogPage();
        TvCatalogPage tvCatalogPage = new TvCatalogPage(getDriver());
        Assert.assertTrue(catalogPage.getTvWidget().clickIfPresent(),"TV widget not found");
        Assert.assertTrue(tvCatalogPage.isPageOpened(),"TV catalog page wasn't opened");
        ResultBlock resultBlock = tvCatalogPage.getResultBlock();
        Assert.assertTrue(resultBlock.isUIObjectPresent(),"There are no TVs found");
        SoftAssert softAssert = new SoftAssert();
        resultBlock.getTvTitles().stream()
                .map(webElement -> webElement.getText().toLowerCase(Locale.ROOT))
                .forEach(title -> softAssert.assertTrue(title.contains("телевизор"),"The displayed result is not a TV"));
        softAssert.assertAll();
    }

    @Test()
    public void verifyFilter(){
        CatalogPage catalogPage = goToCatalogPage();
        catalogPage.getTvWidget().clickIfPresent();
        TvCatalogPage tvCatalogPage = new TvCatalogPage(getDriver());
        Assert.assertTrue(tvCatalogPage.isPageOpened(),"Page is not opened");
        FilterBlock filterBlock = tvCatalogPage.getFilterBlock();
        ResultBlock resultBlock = tvCatalogPage.getResultBlock();
        Assert.assertTrue(resultBlock.isUIObjectPresent(),"Result block not found");
        Assert.assertTrue(filterBlock.isUIObjectPresent(),"Filter block not found");
        ManufactureFilter manufactureFilter = filterBlock.getManufactureFilter();
        Assert.assertTrue(manufactureFilter.isUIObjectPresent(),"Manufacture filter not found");
        ExtendedWebElement LGManufacture = manufactureFilter.getManufacture();
        LGManufacture.check();
        ExtendedWebElement waitLine = tvCatalogPage.getWaitLine();
        WebDriverWait wait = new WebDriverWait(getDriver(),30);
//        wait.until(driver -> waitLine.isPresent());
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitLine.getBy()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(waitLine.getBy()));
//        wait.until(driver -> !waitLine.isPresent());
        Assert.assertTrue(LGManufacture.isChecked(),"LG manufacture wasn't checked");
        SoftAssert softAssert = new SoftAssert();
        resultBlock.getTvTitles().stream()
                .map(webElement -> webElement.getText())
                .forEach(title -> softAssert.assertTrue(title.contains("LG"),"The displayed result is not an LG TV"));
        softAssert.assertAll();
    }

    private CatalogPage goToCatalogPage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        MenuBlock menuBlock = homePage.getMenuBlock();
        return menuBlock.openCatalogPage();
    }
}
