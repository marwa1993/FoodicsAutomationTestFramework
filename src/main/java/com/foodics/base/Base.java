package com.foodics.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite; // Change to AfterSuite
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.foodics.utils.Read_excel_data;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

    protected static AndroidDriver driver;
    protected FileInputStream inputstream;
    protected Properties prop;

    @Parameters({"deviceName", "platformName", "platformVersion"})
    @BeforeClass
    public void beforeClass(String deviceName, String platformName, String platformVersion) throws Exception {

        File propFile = new File("src/main/resources/config/Configuration.properties");
        inputstream = new FileInputStream(propFile);
        prop = new Properties();
        prop.load(inputstream);

        File androidApp = new File(prop.getProperty("androidAppPath"));

        DesiredCapabilities desiredCaps = new DesiredCapabilities();
        desiredCaps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        desiredCaps.setCapability(CapabilityType.PLATFORM_NAME, platformName);
        desiredCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        desiredCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("androidAutomationName"));
        desiredCaps.setCapability(MobileCapabilityType.APP, androidApp.getAbsolutePath());
        driver = new AndroidDriver(new URL(prop.getProperty("appiumServerLink")), desiredCaps);
    }

    @AfterSuite
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider
    public String[][] test_data() throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
    	Read_excel_data obj = new Read_excel_data();
        return obj.read_sheet();  // Fetches test data from the Excel sheet
    }
}
