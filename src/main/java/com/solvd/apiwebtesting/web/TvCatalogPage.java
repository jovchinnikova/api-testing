package com.solvd.apiwebtesting.web;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TvCatalogPage extends AbstractPage {

    @FindBy(id = "schema-products")
    private ResultBlock resultBlock;

    @FindBy(className = "schema-filter__wrapper")
    private FilterBlock filterBlock;

    @FindBy(xpath = "//*[contains(@class, 'state_animated')]")
    private ExtendedWebElement waitLine;

    public TvCatalogPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("tv_catalog_url"));
    }

    public ResultBlock getResultBlock() {
        return resultBlock;
    }

    public FilterBlock getFilterBlock() {
        return filterBlock;
    }

    public ExtendedWebElement getWaitLine() {
        return waitLine;
    }
}
