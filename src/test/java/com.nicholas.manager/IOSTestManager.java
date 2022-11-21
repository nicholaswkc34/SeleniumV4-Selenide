package com.nicholas.manager;

import com.codeborne.selenide.Configuration;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class IOSTestManager extends TestManager {

    private IOSDriverManager iosDriverManager = new IOSDriverManager();

    @BeforeSuite
    public void createDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Sony Xperia Z2");
        caps.setCapability("platformVersion", "6.0.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);

        caps.setCapability("platformName", "Ios");

        iosDriverManager.createDriver(caps);
    }

    @BeforeMethod
    public void setup() {
        closeWebDriver();
        Configuration.browserSize = null;
        Configuration.browser = IOSDriverManager.class.getName();

        open();
    }

    @Test
    public void testing() {

    }


}
