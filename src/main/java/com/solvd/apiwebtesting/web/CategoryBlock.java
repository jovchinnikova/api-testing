package com.solvd.apiwebtesting.web;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoryBlock extends AbstractUIObject {

    @FindBy(xpath = ".//span[contains(text(),'Электроника')]")
    private ExtendedWebElement electronicCategory;

    public CategoryBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getElectronicCategory() {
        return electronicCategory;
    }
}
