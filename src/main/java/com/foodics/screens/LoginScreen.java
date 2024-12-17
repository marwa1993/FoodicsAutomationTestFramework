package com.foodics.screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.foodics.base.Base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginScreen extends Base {

    private WebDriverWait wait;

    private final By loginPageButton = AppiumBy.xpath("//android.widget.TextView[@text='Login']");
    private final By emailField = AppiumBy.accessibilityId("input-email");
    private final By passwordField = AppiumBy.accessibilityId("input-password");
    private final By loginButton = AppiumBy.xpath("//android.widget.TextView[@text='LOGIN']");
    private final By successMessage = AppiumBy.xpath("//android.widget.TextView[@text='You are logged in!']");
    private final By okButton = AppiumBy.className("android.widget.Button");

    public LoginScreen(final AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void openLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPageButton)).click();
    }

    public void enterCredentials(final String userName, final String password) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(userName);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public String getSuccessMessage() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return messageElement.getText();
    }

    public void closeSuccessMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }

    public String login(final String userName, final String password) {
        openLoginPage();
        enterCredentials(userName, password);
        clickLoginButton();
        String message = getSuccessMessage();
        closeSuccessMessage();
        return message;
    }
}

