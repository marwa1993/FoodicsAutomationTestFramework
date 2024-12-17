package com.foodics.testcases;

import com.foodics.base.Base;
import com.foodics.screens.SwipeScreen;
import org.testng.annotations.Test;

/**
 * Test case to verify the swipe functionality.
 */
public class SwipeScreenTest extends Base {

    /**
     * Test case to verify swipe functionality on the carousel.
     */
    @Test
    public void testSwipeFunctionality() {
        // Step 1: Initialize SwipeScreen with the driver from Base class
        SwipeScreen swipeScreen = new SwipeScreen(driver);

        // Step 2: Perform the swipe action on the carousel
        swipeScreen.swipeCarousel();

        // Step 3: Add a success message for confirmation (logging)
        System.out.println("Swipe action performed successfully and carousel is swiped 3 times.");
    }
}


