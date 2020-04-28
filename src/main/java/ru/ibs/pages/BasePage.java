package ru.ibs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.ibs.utils.DriverManager;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public abstract class BasePage {

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public abstract WebElement getField(String name) throws Exception;

    public WebElement getField(String name, String className) throws Exception {
        Class example = Class.forName(className);
        List<Field> fields = Arrays.asList(example.getFields());
        for (Field field : fields){
            if (field.equals(name)){
                return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }

    public WebElement element(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public void fillField(WebElement field, String value) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("return arguments[0].style.border='1px solid magenta';", field);
        field.clear();
        field.sendKeys(value);
        js.executeScript("return arguments[0].style.border='1px solid black';", field);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void checkSearchResult(WebElement element) {
        assertTrue(element.isDisplayed(), "Поле отсуттвует.");
    }

    public void checkExchange(String purchase, String sale, String currency) {
        String i = element(By.xpath(String.format(purchase, currency))).getText();
        String j = element(By.xpath(String.format(sale, currency))).getText();

        assertTrue(Double.parseDouble(i.replace(",", ".")) < Double.parseDouble(j.replace(",", "."))
                , "Курс продажи больше кура покупки.");
    }

}