package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends BasePage{

    @FindBy(className = "cardNumberInput")
    public WebElement cardNo;

    @FindBy(id = "cardOwnerName")
    public WebElement cardName;

    @FindBy(id = "expireMonth")
    public WebElement cardMonth;

    @FindBy(id = "expireYear")
    public WebElement cardYear;

    @FindBy(id = "securityCode")
    public WebElement cardSecurityCode;

    @FindBy(id = "js-paymentBtn")
    public WebElement makePaymentBtn;

    @FindBy(className = "errorText")
    public WebElement errorText;

    @FindBy(className = "securePayment")
    public WebElement securePaymentTxt;

    public void makePayment(){

        cardNo.sendKeys("1234");
        cardName.sendKeys("Sedat Onen");
        Select month = new Select(cardMonth);
        month.selectByVisibleText("12");
        Select year = new Select(cardYear);
        year.selectByVisibleText("2030");
        cardSecurityCode.sendKeys("521");
        makePaymentBtn.click();

    }


}
