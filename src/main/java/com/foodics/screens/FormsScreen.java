package com.foodics.screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * Page Object class for the Forms screen in the application.
 * Contains methods for interacting with form elements and verifying results.
 */
public class FormsScreen {

    private WebDriverWait wait;

    // Locators for form elements
    private final By formsButton = AppiumBy.xpath("//android.widget.TextView[@text='Forms']");
    private final By textInputField = AppiumBy.accessibilityId("text-input");
    private final By inputTextResult = AppiumBy.accessibilityId("input-text-result");
    private final By switchButton = AppiumBy.accessibilityId("switch");
    private final By switchText = AppiumBy.accessibilityId("switch-text");
    private final By dropDownButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Dropdown']/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
    private final By dropDownOption1 = AppiumBy.xpath("//android.widget.CheckedTextView[@text='webdriver.io is awesome']");
    private final By dropDownInputField = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Dropdown']/android.view.ViewGroup/android.widget.EditText");
    private final By buttonActive = AppiumBy.accessibilityId("button-Active");
    private final By buttonInActive = AppiumBy.accessibilityId("button-Inactive");
    private final By activeMessage = AppiumBy.id("android:id/message");
    private final By okButton = AppiumBy.className("android.widget.Button");

    // Constructor
    public FormsScreen(final AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Open forms screen
    public void openFormsScreen() {
        wait.until(ExpectedConditions.elementToBeClickable(formsButton)).click();
    }

    // Enter text into the input field and return the result
    public String enterTextAndGetResult(final String inputText) {
        wait.until(ExpectedConditions.elementToBeClickable(textInputField)).sendKeys(inputText);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inputTextResult)).getText();
    }

    // Get the current switch text
    public String getSwitchText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(switchText)).getText();
    }

    // Toggle the switch and get the updated switch text
    public String toggleSwitchAndGetUpdatedText() {
        wait.until(ExpectedConditions.elementToBeClickable(switchButton)).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(switchText)).getText();
    }

    // Select a drop-down option and return the input field value
    public String selectDropDownOption() {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dropDownOption1)).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownInputField)).getText();
    }

    // Click the active button and return the message displayed
    public String clickActiveButtonAndGetMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonActive)).click();
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(activeMessage)).getText();
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
        return message;
    }

    // Click inactive button
    public void clickInactiveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonInActive)).click();
    }
}
