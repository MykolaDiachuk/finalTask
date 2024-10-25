package org.example.saucedemo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private By usernameField = By.cssSelector("#user-name");
    private By passwordField = By.cssSelector("#password");
    private By loginButton = By.cssSelector("#login-button");
    private By errorMessage = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        logger.info("Entered username: " + username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        logger.info("Entered password: " + password);
    }

    public void clearUsername() {
        WebElement username = driver.findElement(usernameField);
        username.clear();
        username.sendKeys(" ");
        username.sendKeys(Keys.BACK_SPACE);
        logger.info("Cleared username");
    }

    public void clearPassword() {
        WebElement username = driver.findElement(passwordField);
        username.clear();
        username.sendKeys(" ");
        username.sendKeys(Keys.BACK_SPACE);
        logger.info("Cleared password");
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        logger.info("Logged in");
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}
