package com.solvd.apiwebtesting.web;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath="//div[@class='header-style__middle']")
    private MenuBlock menuBlock;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private ExtendedWebElement searchLine;

    @FindBy(xpath = "//header[@class='b-main-page-blocks-header-2 cfix']//a[@href='https://catalog.onliner.by']")
    private ExtendedWebElement catalogHeader;

    @FindBy(className = "catalog-offers__list swiper-wrapper")
    private ExtendedWebElement catalogOfferBlock;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public MenuBlock getMenuBlock() {
        return menuBlock;
    }

    public ExtendedWebElement getSearchLine() {
        return searchLine;
    }

    public ExtendedWebElement getCatalogHeader() {
        return catalogHeader;
    }

    public ExtendedWebElement getCatalogOfferBlock() {
        return catalogOfferBlock;
    }
}
