package com.example.marah.Core;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class BaseClass {

    public static AppiumDriver driver;

    String apkPath = System.getProperty("user.dir") + "/src/test/java/com/example/marah/apps/Weather.apk";

    public void AndroidSetup() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:platformName", "ANDROID");
            caps.setCapability("appium:deviceName", "e3d2f001");
            caps.setCapability("appium:platformVersion", "10.0");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:app", apkPath);
            caps.setCapability("appium:disableWindowAnimation", true);
            caps.setCapability("appium:waitForIdleTimeout", 0);
            caps.setCapability("appium:autoGrantPermissions", true);


            URL url = new URL("http://127.0.0.1:4723/");

            driver = new AndroidDriver(url, caps);

//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        } catch (Exception e) {
            System.out.println("exception cause : " + e.getCause());
            System.out.println("exception message : " + e.getMessage());
            System.out.println("exception StackTrace : ");
        }

    }

    public void AndroidTearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
