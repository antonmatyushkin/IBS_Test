package ru.ibs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage {

    @FindBy(xpath = "//div[@class='r']/a[@href='https://www.open.ru/']")
    public WebElement result;

    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchField;

    @FindBy(xpath = "//div[@class='tfB0Bf']/descendant::input[@value='Поиск в Google']")
    public WebElement searchButton;

    @Override
    public WebElement getField(String className) throws Exception {
        return getField(className, "ru.ibs.pages.MainPage");
    }

}
