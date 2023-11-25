package org.example;

import org.example.component.HomePageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class HomePageObject {
    private WebDriver driver;
    private By orderButtonUpOnHomePage = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");//локатор кнопки Заказать в верхней части главной страницы
    private By orderButtonDownOnHomePage = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");//локатор кнопки Заказать в нижней части главной страницы
    private By titleWhomScooter = By.xpath(".//div[text()='Для кого самокат']");//локатор заголовка Для кого самокат

    private By components = By.xpath(".//div[@data-accordion-component= 'AccordionItem']");//локатор компонента со списком вопросов и ответов

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickorderButtonOnHomePage(String buttonLocation) {
        if (Objects.equals(buttonLocation, "Up")) {
            clickorderButtonUpOnHomePage();
        } if (Objects.equals(buttonLocation, "Down")){
            clickorderButtonDownOnHomePage();
        }

    }
    public void clickorderButtonUpOnHomePage() {
        this.driver.findElement(this.orderButtonUpOnHomePage).click();
    }

    public void clickorderButtonDownOnHomePage() {
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        WebElement element = this.driver.findElement(this.orderButtonDownOnHomePage);
        js.executeScript("arguments[0].click()", element);
    }

    public void waitForLoadHeaderOrderPage() {
        (new WebDriverWait(this.driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(titleWhomScooter));
    }

    public HomePageComponent getComponent(int index) {
        WebElement webElement = this.driver.findElements(this.components).get(index);
        return new HomePageComponent(webElement, this.driver);
    }
}
