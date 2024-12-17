package com.foodics.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodics.base.Base;
import com.foodics.screens.SignUpScreen;

/**
 * Test case to verify the functionality of the SignUp screen.
 */
public class SignUpScreenTest extends Base {

    /**
     * Test case to verify successful sign-up.
     * Data is fetched from Excel using DataProvider.
     */
    @Test(dataProvider = "test_data")
    public void testSignUpSuccess(String userName, String password) {
        // Expected success message directly in the test
        String expectedMessage = "You successfully signed up!";

        // Create an instance of the SignUpScreen
        SignUpScreen signUpScreen = new SignUpScreen(driver);

        // Perform sign-up and capture the success message
        String successMessage = signUpScreen.signUp(userName, password);

        // Assert that the success message matches the expected text
        Assert.assertEquals(successMessage, expectedMessage, "Sign-up success message does not match!");

        // Log the test result for visibility
        System.out.println("Sign-up successful and verified.");
    }
}
