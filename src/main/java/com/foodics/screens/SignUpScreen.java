package com.foodics.screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.foodics.base.Base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * Page Object representing the Sign-Up screen functionality.
 */
public class SignUpScreen extends Base {

    private WebDriverWait wait;

    // Locators for sign-up screen elements
    private final By loginPageButton = AppiumBy.xpath("//android.widget.TextView[@text='Login']");
    private final By signUpTap = AppiumBy.xpath("//android.widget.TextView[@text='Sign up']");
    private final By email = AppiumBy.accessibilityId("input-email");
    private final By password = AppiumBy.accessibilityId("input-password");
    private final By confirmPassword = AppiumBy.accessibilityId("input-repeat-password");
    private final By signUpButton = AppiumBy.accessibilityId("button-SIGN UP");
    private final By successMessage = AppiumBy.xpath("//android.widget.TextView[@text='You successfully signed up!']");
    private final By okButton = AppiumBy.className("android.widget.Button");

    // Constructor to initialize the WebDriverWait
    public SignUpScreen(final AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /**
     * Navigates to the sign-up screen.
     */
    public void navigateToSignUpPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPageButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signUpTap)).click();
    }

    /**
     * Fills in the email, password, and confirm password fields.
     * @param userName The username (email) to be entered.
     * @param pass The password to be entered.
     */
    public void fillSignUpForm(final String userName, final String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(userName);
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(confirmPassword)).sendKeys(pass);
    }

    /**
     * Clicks the sign-up button to submit the form.
     */
    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    /**
     * Captures and returns the success message after signing up.
     * @return The success message displayed after sign-up.
     */
    public String getSuccessMessage() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return messageElement.getText();
    }

    /**
     * Closes the success message by clicking the OK button.
     */
    public void closeSuccessMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }

    /**
     * Performs the full sign-up process including navigating, filling the form, and getting the success message.
     * @param userName The username (email) to be entered.
     * @param pass The password to be entered.
     * @return The success message displayed after sign-up.
     */
    public String signUp(final String userName, final String pass) {
        navigateToSignUpPage();
        fillSignUpForm(userName, pass);
        clickSignUpButton();
        String message = getSuccessMessage();
        closeSuccessMessage();
        return message;
    }
}

