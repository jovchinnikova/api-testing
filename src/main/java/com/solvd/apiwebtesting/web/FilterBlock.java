package com.solvd.apiwebtesting.web;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterBlock extends AbstractUIObject {

    @FindBy(xpath = "//div[.//span[contains(text(),'Производитель')] and @class='schema-filter__fieldset']")
    private ManufactureFilter manufactureFilter;

    public FilterBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ManufactureFilter getManufactureFilter() {
        return manufactureFilter;
    }
}
