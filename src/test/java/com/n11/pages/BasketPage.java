package com.n11.pages;

import com.n11.utilities.BrowserUtils;
import com.n11.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.n11.utilities.BrowserUtils.waitForVisibility;

public class BasketPage extends BasePage {

    @FindBy(xpath = "(//*[@class=\"closeBtn\"])[3]")
    public WebElement closeMessage;

    @FindBy(name = "productDisplayPrice")
    public List<WebElement> price;

    @FindBy(className = "spinnerUp")
    public List<WebElement> quantityUp;

    @FindBy(id = "js-buyBtn")
    public WebElement buyBtn;

    @FindBy(className = "btn-continue")
    public WebElement continueBtn;

    @FindBy(id = "guestEmail")
    public WebElement emailBtn;

    @FindBy(id = "js-guestEmailCheck")
    public WebElement emailCheckBtn;

    @FindBy(id = "fullName")
    public WebElement fullName;

    @FindBy(id = "cityId")
    public WebElement cityId;

    @FindBy(id = "districtId")
    public WebElement districtId;

    @FindBy(id = "neighbourhoodId")
    public WebElement neighbourhoodId;

    @FindBy(id = "addressDetail")
    public WebElement addressDetail;

    @FindBy(id = "gsm")
    public WebElement gsm;

    @FindBy(id = "shippingAddresstcNO")
    public WebElement shippingAddresstcNO;

    @FindBy(id = "addressName")
    public WebElement addressName;

    @FindBy(id = "js-goToPaymentBtn")
    public WebElement goToPayment;

    @FindBy(xpath = "//*[@class='dtl header']")
    public WebElement productNumber;

    public void getCheapestProduct() throws InterruptedException {
        closeMessage.click();//guest info
        int cheapProd = 0;
        int cheapPrice = Integer.parseInt(price.get(0).getAttribute("value"));//en ucuz ürün ilk ürün
        for (int i = 0; i < price.size(); i++) {//fiyat karşıştırdık

            int actualPrice = Integer.parseInt(price.get(i).getAttribute("value"));//o anki fiyat

            if (actualPrice < cheapPrice) {//o anki fiyat ilk üründen küçük mü
                cheapPrice = actualPrice;
                cheapProd = i;
            }
        }
        Thread.sleep(1000);
        BrowserUtils.doubleClick(quantityUp.get(cheapProd));
        Thread.sleep(1000);
    }

    public void continueAsGuest() {
        buyBtn.click();
        waitForVisibility(continueBtn, ConfigurationReader.getTime("explicit.wait"));
        continueBtn.click();
        waitForVisibility(emailBtn, ConfigurationReader.getTime("explicit.wait"));
        emailBtn.sendKeys("sedatonennnnn@gmail.com");
        emailCheckBtn.click();
        waitForVisibility(fullName, ConfigurationReader.getTime("explicit.wait"));
        fullName.sendKeys("sedat onen");
        Select city = new Select(cityId);
        city.selectByVisibleText("İstanbul");
        Select district = new Select(districtId);
        district.selectByVisibleText("Bağcılar");
        Select neighbourhood = new Select(neighbourhoodId);
        neighbourhood.selectByVisibleText("Yıldıztepe");
        addressDetail.sendKeys("yıldıztepe mahallesi");
        gsm.click();
        gsm.sendKeys("351231212");
        shippingAddresstcNO.sendKeys("23731684868");
        addressName.sendKeys("yıldızte mahallesi ev");
        goToPayment.click();
    }
}
