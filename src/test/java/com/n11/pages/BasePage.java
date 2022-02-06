package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "searchData")
    public WebElement searchText;

    @FindBy(className = "searchBtn")
    public WebElement searchBtn;

    public void searchProduct(String product){
        searchText.sendKeys(product);
        searchBtn.click();
    }
}
