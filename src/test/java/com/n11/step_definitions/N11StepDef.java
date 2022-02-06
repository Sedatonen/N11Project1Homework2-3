package com.n11.step_definitions;

import com.n11.pages.BasePage;
import com.n11.pages.BasketPage;
import com.n11.pages.PaymentPage;
import com.n11.pages.SearchPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class N11StepDef {

    BasePage basePage = new BasePage();
    SearchPage searchPage = new SearchPage();
    BasketPage basketPage = new BasketPage();
    PaymentPage paymentPage = new PaymentPage();

    @Given("user go to n11 home page and search {string}")
    public void user_go_to_n11_home_page_and_search(String product) {
        basePage.searchProduct(product);
    }

    @When("user add products to basket")
    public void user_add_products_to_basket() throws InterruptedException {
        Assert.assertTrue(searchPage.resultText.getText().contains("iphone"), "Verify Product");

        searchPage.selectProduct();
        Assert.assertTrue(basketPage.productNumber.getText().contains("3"), "Verify Product number");

        basketPage.getCheapestProduct();
        Assert.assertTrue(basketPage.productNumber.getText().contains("5"), "Verify add Product");
    }

    @Then("user select filter")
    public void user_select_filter() {
        Assert.assertTrue(searchPage.resultText.getText().contains("Telefon"), "Verify Product");

        searchPage.setFilter();
        Select sortTo = new Select(searchPage.dropDownsortingType);

        Assert.assertTrue(sortTo.getFirstSelectedOption().getText().contains("Yorum sayısı"));
        Assert.assertTrue(searchPage.freeShippingCheckBox.isSelected());
    }

    @Then("user pays with wrong card number")
    public void user_pays_with_wrong_card_number() {
        basketPage.continueAsGuest();
        Assert.assertTrue(paymentPage.securePaymentTxt.getText().contains("GÜVENLİ ÖDEME"), "Verify Payment Page");

        paymentPage.makePayment();
        Assert.assertTrue(paymentPage.errorText.getText().contains("Geçersiz kredi kartı numarası"), "Verify Wrong Card");
    }
}
