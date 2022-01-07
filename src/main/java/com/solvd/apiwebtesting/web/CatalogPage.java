package com.solvd.apiwebtesting.web;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends AbstractPage {

    @FindBy(className = "catalog-navigation-classifier-buffer")
    private CategoryBlock categories;

    @FindBy(xpath = "//div[@class='widget-item']//h3[contains(text(),'Телевизоры')]")
    private ExtendedWebElement tvWidget;

    public CatalogPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("catalog_url"));
    }

    public CategoryBlock getCategories() {
        return categories;
    }

    public ExtendedWebElement getTvWidget() {
        return tvWidget;
    }
}
