//package com.foodics.testcases;
//
package com.foodics.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodics.base.Base;
import com.foodics.screens.LoginScreen;

/**
 * Test class to verify the Login Screen functionality.
 */
public class LoginScreenTest extends Base {

    /**
     * Test case to verify successful login.
     */
    @Test(dataProvider = "test_data")
    public void testLoginSuccess(String userName, String password) {
        // Expected success message directly in the test
        String expectedMessage = "You are logged in!";

        // Create an instance of the LoginScreen
        LoginScreen loginScreen = new LoginScreen(driver);

        // Perform login and capture the success message
        String successMessage = loginScreen.login(userName, password);

        // Assert that the success message matches the expected text
        Assert.assertEquals(successMessage, expectedMessage, "Login success message does not match!");

        // Log the test result for visibility
        System.out.println("Login successful and verified.");
    }
}

