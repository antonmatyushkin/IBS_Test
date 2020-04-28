package ru.ibs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenBankPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Курс обмена в интернет-банке']")
    public WebElement exchangeOfInternetBank;

    public String salePrice = "//tr[contains(@class,'ain-page-exchange')]/descendant::span[text()='%s']/ancestor::tr/descendant::td[contains(@class,'separator')]/following-sibling::td/div/span[@class='main-page-exchange__rate']";
    public String purchasePrice = "//tr[contains(@class,'ain-page-exchange')]/descendant::span[text()='%s']/ancestor::tr/descendant::td[contains(@class,'separator')]/preceding-sibling::td/div/span[@class='main-page-exchange__rate']";

    @Override
    public WebElement getField(String className) throws Exception {
        return getField(className, "ru.ibs.pages.OpenBankPage");
    }

}
