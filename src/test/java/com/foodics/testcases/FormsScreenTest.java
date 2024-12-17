package com.foodics.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodics.base.Base;
import com.foodics.screens.FormsScreen;
import com.foodics.utils.FormsTestData; // New utility class for test data

public class FormsScreenTest extends Base {

    @Test
    public void testFormsSuccess() {
        // Test Data from TestData class
        String inputText = FormsTestData.INPUT_TEXT;
        String expectedInitialSwitchText = FormsTestData.EXPECTED_INITIAL_SWITCH_TEXT;
        String expectedUpdatedSwitchText = FormsTestData.EXPECTED_UPDATED_SWITCH_TEXT;
        String expectedDropDownText = FormsTestData.EXPECTED_DROPDOWN_TEXT;
        String expectedActiveButtonMessage = FormsTestData.EXPECTED_ACTIVE_BUTTON_MESSAGE;

        // Initialize FormsScreen
        FormsScreen formsScreen = new FormsScreen(driver);

        // Step 1: Open forms page
        formsScreen.openFormsScreen();

        // Step 2: Test text input field
        String inputTextResult = formsScreen.enterTextAndGetResult(inputText);
        Assert.assertEquals(inputTextResult, inputText, "Input text result does not match!");

        // Step 3: Test initial switch text
        String initialSwitchText = formsScreen.getSwitchText();
        Assert.assertEquals(initialSwitchText, expectedInitialSwitchText, "Initial switch text mismatch!");

        // Step 4: Test updated switch text
        String updatedSwitchText = formsScreen.toggleSwitchAndGetUpdatedText();
        Assert.assertEquals(updatedSwitchText, expectedUpdatedSwitchText, "Updated switch text mismatch!");

        // Step 5: Test drop-down selection
        String dropDownResult = formsScreen.selectDropDownOption();
        Assert.assertEquals(dropDownResult, expectedDropDownText, "Drop-down result mismatch!");

        // Step 6: Test active button message
        String activeMessage = formsScreen.clickActiveButtonAndGetMessage();
        Assert.assertEquals(activeMessage, expectedActiveButtonMessage, "Active button message mismatch!");

        // Step 7: Click inactive button
        formsScreen.clickInactiveButton();

        System.out.println("All forms assertions passed successfully!");
    }
}
