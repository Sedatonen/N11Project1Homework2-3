package com.n11.pages;

import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.n11.utilities.BrowserUtils.*;

public class SearchPage extends BasePage {

    @FindBy(className = "resultText")
    public WebElement resultText;

    @FindBy(css = "[content='TRY']")
    public List<WebElement> products;

    @FindBy(className = "seg-popup-close")
    public WebElement closePopUp;

    @FindBy(xpath = "//*[@class=\"pagination\"]/a[3]")
    public WebElement thirdPages;

    @FindBy(className = "icon-white-basket")
    public WebElement addBasketBtn;

    @FindBy(className = "btnGoBasket")
    public WebElement basketBtn;

    @FindBy(xpath = "(//*[@class =\"brand-checkbox\"])[4]")
    public WebElement filterElementList;

    @FindBy(id = "sortingType")
    public WebElement dropDownsortingType;

    @FindBy(id = "freeShippingOption")
    public WebElement freeShippingCheckBox;

    WebDriver driver = Driver.get();

    public void selectProduct() {
        String actualUrl = Driver.get().getCurrentUrl();
        hover(products.get(0));

        products.get(0).click();//ilk ürün
        addBasketBtn.click();
        //closePopUp.click();
        System.out.println(actualUrl);
        driver.get(actualUrl);

        int lastProduct = products.size() - 1;//son ürünün indexi
        hover(products.get(lastProduct));
        products.get(lastProduct).click();//son ürün tıkla
        addBasketBtn.click();


        driver.get(actualUrl);
        thirdPages.click();
        hover(products.get(4));
        products.get(4).click();
        addBasketBtn.click();

        basketBtn.click();

    }

    public void setFilter() {
        filterElementList.click();
        waitForVisibility(dropDownsortingType, ConfigurationReader.getTime("explicit.wait"));
        Select sortTo = new Select(dropDownsortingType);
        sortTo.selectByVisibleText("Yorum sayısı");
        waitForClickablility(freeShippingCheckBox,ConfigurationReader.getTime("explicit.wait"));
        freeShippingCheckBox.click();
    }
}
