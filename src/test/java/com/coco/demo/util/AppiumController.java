package com.coco.demo.util;

import com.coco.demo.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author coco
 */
public class AppiumController {

    public static String oSEnv = System.getProperty("OS") != null ? System.getProperty("OS") : "ANDROID";
    public static AppiumController instance = new AppiumController();
    public static AppiumDriver driver;

    public void init() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir;
        File app;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (oSEnv) {
            case "ANDROID":
                appDir = new File(classpathRoot, "/app/Android");
                app = new File(appDir, "demo.api");
                capabilities.setPlatform(Platform.ANDROID);
                capabilities.setCapability("deviceName", "ANDROID");
                capabilities.setVersion(Constants.DEVICE_VERSION_ANDROID);
                capabilities.setBrowserName("");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("package", "com.coco.demo");
                capabilities.setCapability("appActivity", "com.coco.demo.MainActivity");
                driver = new AndroidDriver(new URL(Constants.APPIUM_SERVER), capabilities);
                break;
            case "IOS":
                appDir = new File(classpathRoot, "/app/iOS");
                app = new File(appDir, "demo.app");
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", Constants.DEVICE_VERSION_IOS);
                capabilities.setBrowserName("");
                capabilities.setCapability("app", app.getAbsolutePath());
                driver = new IOSDriver(new URL(Constants.APPIUM_SERVER), capabilities);
                break;
        }
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public void terminate() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
