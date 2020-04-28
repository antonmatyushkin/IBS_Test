package ru.ibs.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.ibs.pages.GooglePage;
import ru.ibs.pages.OpenBankPage;
import ru.ibs.utils.DriverManager;
import ru.ibs.utils.TestProperties;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ExchangeRateVerificationTest {

    private WebDriver driver;
    private GooglePage googlePage = new GooglePage();
    private OpenBankPage openBankPage = new OpenBankPage();
    private static Properties properties = TestProperties.getInstance().getProperties();

    @BeforeSuite
    public void initDriver() throws Exception {
        System.out.println("You are testing in Chrome.");
        driver = DriverManager.getDriver();
        driver.get(properties.getProperty("app.url"));
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void exchangeRateVerificationTest() {
        googlePage.fillField(googlePage.searchField, "Открытие");
        googlePage.click(googlePage.searchButton);
        googlePage.checkSearchResult(googlePage.result);
        googlePage.click(googlePage.result);
        openBankPage.checkExchange(openBankPage.purchasePrice, openBankPage.salePrice, "USD");
        openBankPage.checkExchange(openBankPage.purchasePrice, openBankPage.salePrice, "EUR");
    }

    @AfterSuite
    public void afterSuite() {
        DriverManager.quitDriver();
    }

}
