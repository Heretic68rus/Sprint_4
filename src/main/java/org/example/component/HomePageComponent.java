package org.example.component;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageComponent extends BaseComponent {
    private By question = By.xpath(".//div[contains(@id, 'accordion__heading')]");//локатор блока с вопросами на главной странице
    private By answer = By.xpath(".//div[contains(@id, 'accordion__panel')]");//локатор блока с ответами на главной странице

    public HomePageComponent(WebElement root, WebDriver driver) {
        super(root, driver);
    }

    public String getQuestion() {
        return this.root.findElement(this.question).getText();
    }

    public String getAnswer() {
        return this.root.findElement(this.answer).getText();
    }

    public void openQuestion() {
        WebElement questionElement = this.root.findElement(this.question);
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", questionElement);
        new WebDriverWait(this.driver, 3).until(ExpectedConditions.elementToBeClickable(this.question));
        questionElement.click();
    }
}