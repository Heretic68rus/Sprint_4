package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageObject {
    private WebDriver driver;
    private By nameFieldOrderPage = By.xpath(".//input[@placeholder='* Имя']");//локатор поля Имя
    private By familyNameFieldOrderPage = By.xpath(".//input[@placeholder='* Фамилия']");//локатор поля Фамилия
    private By addressFieldOrderPage = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");//локатор поля Адрес
    private By metroFieldOrderPage = By.xpath(".//input[@placeholder='* Станция метро']");//локатор поля Станция метро
    private By phoneFieldOrderPage = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");//локатор поля Телефон
    private By furtherButtonOrderPage = By.xpath(".//button[text()='Далее']");//локатор кнопки Далее
    private By headerAboutRent = By.xpath(".//div[text()='Про аренду']");//локатор заголовка Про аренду

    public OrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void fillNameFieldOrderPage(String name) {
        this.driver.findElement(this.nameFieldOrderPage).sendKeys(new CharSequence[]{name});
    }

    public void fillFamilyNameFieldOrderPage(String familyName) {
        this.driver.findElement(this.familyNameFieldOrderPage).sendKeys(new CharSequence[]{familyName});
    }

    public void fillAddressFieldOrderPage(String address) {
        this.driver.findElement(this.addressFieldOrderPage).sendKeys(new CharSequence[]{address});
    }

    public void fillMetroFieldOrderPage(String metro) {
        this.driver.findElement(this.metroFieldOrderPage).sendKeys(new CharSequence[]{metro, Keys.DOWN, Keys.ENTER});
    }

    public void fillPhoneFieldOrderPage(String phone) {
        this.driver.findElement(this.phoneFieldOrderPage).sendKeys(new CharSequence[]{phone});
    }

    public void clickFurtherButtonOrderPage() {
        this.driver.findElement(this.furtherButtonOrderPage).click();
    }

    public void waitForLoadHeaderAboutRentPage() {
        (new WebDriverWait(this.driver, 3L)).until(ExpectedConditions.visibilityOfElementLocated(headerAboutRent));
    }
}
