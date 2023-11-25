package org.example.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseComponent {
    public WebDriver driver;
    public WebElement root;

    public BaseComponent(WebElement root, WebDriver driver) {
        this.driver = driver;
        this.root = root;
    }
}
