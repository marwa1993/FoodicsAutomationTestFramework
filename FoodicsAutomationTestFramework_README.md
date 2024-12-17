
# Foodics Automation Test Framework

This project is an automation test framework for Wdiodemoapp application, using Appium, Selenium, TestNG, and Java. It aims to automate different screens of the Wdiodemoapp mobile application and verifies their functionalities.

## Table of Contents

- [Requirements](#requirements)
- [Project Setup](#project-setup)
- [Running the Tests](#running-the-tests)
- [Test Case Details](#test-case-details)
- [Dependencies](#dependencies)

## Requirements

- **Java**: 11 or later (Java 11 is required for compilation and execution).
- **Appium**: To interact with mobile applications.
- **Selenium**: To handle browser automation (if needed).
- **TestNG**: Test framework for running the tests.

## Project Setup

1. **Clone the Repository**

    ```bash
    git clone https://github.com/yourusername/FoodicsAutomationTestFramework.git
    cd FoodicsAutomationTestFramework
    ```

2. **Install Dependencies**

    Ensure that **Maven** is installed on your system. You can check this by running:

    ```bash
    mvn -v
    ```

    If Maven is not installed, follow the instructions here: [Install Maven](https://maven.apache.org/install.html)

3. **Configure Appium Server**

    You need to have Appium installed. Install it via npm:

    ```bash
    npm install -g appium
    ```

    You can also install Appium Desktop for a GUI-based server to interact with Appium.

4. **Configure Android Emulator/Device**

    Make sure you have an Android emulator running or a physical Android device connected. The tests use a real device (R5CX80M0H2K) and platform version 14 as default, but this can be customized by changing the parameters in the `testng.xml` file.

    To check if the device is connected properly:

    ```bash
    adb devices
    ```

## Running the Tests

1. **Run the tests via Maven**

    To execute all tests, simply run:

    ```bash
    mvn clean test
    ```

    This will compile the project, download dependencies, and run all tests.

2. **Run Tests in Parallel**

    The tests are configured to run in parallel via the `testng.xml` file. This allows efficient execution of multiple test classes simultaneously. You can change the parallel configuration as needed.

3. **View Test Results**

    The results of the test execution will be output in the `target/test-classes` directory by default. You can view the results in the generated reports (e.g., TestNG HTML reports).

## Test Case Details

### 1. **SignUpScreenTest**

Verifies the functionality of the sign-up screen, ensuring correct input and navigation.

### 2. **LoginScreenTest**

Verifies the functionality of the login screen, ensuring correct credentials and login process.

### 3. **FormsScreenTest**

Tests the functionality of form submissions in the app.

### 4. **SwipeScreenTest**

Verifies the swipe functionality on the carousel in the app.

## Dependencies

- **Selenium**: Used for web automation tasks (for example, handling web-based elements).
- **TestNG**: Testing framework for Java to run and report tests.
- **Appium**: For mobile automation on Android devices.
- **Apache POI**: For handling Excel files.
- **SLF4J**: For logging purposes.



