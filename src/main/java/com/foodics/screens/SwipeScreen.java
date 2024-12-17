package com.foodics.screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * Page Object for the Swipe functionality on the app.
 */
public class SwipeScreen {

    private WebDriverWait wait;
    private AndroidDriver driver;

    // Locators for swipe-related elements
    private final By swipePageButton = AppiumBy.xpath("//android.widget.TextView[@text='Swipe']");
    private final By carousel = AppiumBy.accessibilityId("Carousel");

    // Constructor to initialize WebDriverWait
    public SwipeScreen(final AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /**
     * Navigates to the Swipe page by clicking the swipe button.
     */
    public void navigateToSwipePage() {
        wait.until(ExpectedConditions.elementToBeClickable(swipePageButton)).click();
    }

    /**
     * Gets the carousel element for swipe actions.
     * @return WebElement representing the carousel.
     */
    public WebElement getCarouselElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(carousel));
    }

    /**
     * Performs swipe action on the carousel (left swipe).
     * @param startX The start X coordinate for swipe.
     * @param endX The end X coordinate for swipe.
     * @param centerY The Y coordinate to center the swipe vertically.
     */
    public void performSwipe(int startX, int endX, int centerY) {
        new TouchAction(driver)
            .press(PointOption.point(startX, centerY)) // Start swipe
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // Wait before swipe
            .moveTo(PointOption.point(endX, centerY)) // Move swipe horizontally
            .release()
            .perform();
    }

    /**
     * Calculates swipe start and end points based on carousel element's dimensions.
     * @param carouselElement The WebElement representing the carousel.
     * @return An array where the first element is the start X, second is the end X, and third is the center Y.
     */
    public int[] calculateSwipeCoordinates(WebElement carouselElement) {
        int elementX = carouselElement.getLocation().getX();
        int elementY = carouselElement.getLocation().getY();
        int elementWidth = carouselElement.getSize().getWidth();
        int elementHeight = carouselElement.getSize().getHeight();

        int startX = elementX + elementWidth * 3 / 4; // Start at 75% of the width
        int endX = elementX + elementWidth * 1 / 4;   // End at 25% of the width
        int centerY = elementY + elementHeight / 2;   // Vertically center

        return new int[] { startX, endX, centerY };
    }

    /**
     * Performs a swipe action 3 times on the carousel element.
     */
    public void swipeCarousel() {
        navigateToSwipePage();
        WebElement carouselElement = getCarouselElement();

        // Calculate swipe coordinates based on the carousel element's location and size
        int[] coordinates = calculateSwipeCoordinates(carouselElement);

        // Perform swipe 3 times
        for (int i = 0; i < 3; i++) {
            performSwipe(coordinates[0], coordinates[1], coordinates[2]);
        }
    }
}







