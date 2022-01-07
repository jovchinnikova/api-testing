package com.solvd.apiwebtesting.web;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ResultBlock extends AbstractUIObject {

    private List<WebElement> tvTitles;

    public ResultBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        tvTitles = findTitles();
    }

    public List<WebElement> getTvTitles() {
        return tvTitles;
    }

    public List<WebElement> findTitles(){
        List<WebElement> titles = driver.findElements(By.xpath(".//div[@class='schema-product__title']"));
        return titles.stream().distinct().collect(Collectors.toList());
    }
}
