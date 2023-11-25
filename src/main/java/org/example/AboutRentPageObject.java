package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRentPageObject {
    private WebDriver driver;
    private By dateFieldAboutRentPage = By.xpath(".//input[@placeholder='* Когда привезти самокат']");//локатор проля Когда привезти самокат
    private By rentalPeriodFieldAboutRentPage = By.xpath(".//div[text()='* Срок аренды']");//локатор поля Срок аренды
    private By twoDaysChoiseAboutRentPage = By.xpath(".//div[text()='двое суток']");//локатор кнопки выбора количества суток
    private By orderButtonAboutRentPage = By.xpath(".//button[text()='Заказать' and @class='Button_Button__ra12g Button_Middle__1CSJM']");//локатор кнопки Заказать
    private By yesOrderButtonAboutRentPage = By.xpath(".//button[text()='Да' and @class='Button_Button__ra12g Button_Middle__1CSJM']");//локатор кнопки Да
    private By orderPlacedAboutRentPage = By.xpath(".//div[text()='Заказ оформлен']");//локатор заголовка Заказ оформлен

    public AboutRentPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void fillDateFieldAboutRentPage(String date) {
        this.driver.findElement(this.dateFieldAboutRentPage).sendKeys(new CharSequence[]{date, Keys.DOWN, Keys.ENTER});
    }

    public void clickRentalPeriodFieldAboutRentPage() {
        this.driver.findElement(this.rentalPeriodFieldAboutRentPage).click();
    }

    public void clickTwoDaysChoiseAboutRentPage() {
        this.driver.findElement(this.twoDaysChoiseAboutRentPage).click();
    }

    public void clickOrderButtonAboutRentPage() {
        this.driver.findElement(this.orderButtonAboutRentPage).click();
    }

    public void clickYesOrderButtonAboutRentPage() {
        this.driver.findElement(this.yesOrderButtonAboutRentPage).click();
    }

    public void waitForLoadHeaderOrderPlaced() {
        (new WebDriverWait(this.driver, 3L)).until(ExpectedConditions.visibilityOfElementLocated(this.orderPlacedAboutRentPage));
    }
}
