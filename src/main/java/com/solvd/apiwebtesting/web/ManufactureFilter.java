package com.solvd.apiwebtesting.web;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ManufactureFilter extends AbstractUIObject {

    @FindBy(xpath = ".//span[@class='schema-filter__checkbox-text' and contains(text(),'LG')]")
    private ExtendedWebElement manufacture;

    public ManufactureFilter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getManufacture() {
        return manufacture;
    }
}
