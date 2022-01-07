package com.solvd.apiwebtesting.web;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuBlock extends AbstractUIObject {

    @FindBy(xpath = "//span[@class='header-style__sign' and contains(text(), 'Главная страница')]")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//a[./span[@class='header-style__sign' and contains(text(), 'Каталог')]]")
    private ExtendedWebElement catalogLink;

    public MenuBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage(){
        homeLink.click();
        return new HomePage(driver);
    }

    public CatalogPage openCatalogPage(){
        catalogLink.click();
        return new CatalogPage(driver);
    }

    public ExtendedWebElement getHomeLink() {
        return homeLink;
    }

    public ExtendedWebElement getCatalogLink() {
        return catalogLink;
    }
}
