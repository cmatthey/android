/*
 * Base Test Class handling device configuration, ex. Android vs iOS
 */
package com.coco.demo;

import com.coco.demo.pages.HelloPage;
import com.coco.demo.pages.HelloPageAndroidImpl;
import com.coco.demo.pages.HelloPageIOSImpl;
import com.coco.demo.pages.HomePage;
import com.coco.demo.pages.HomePageAndroidImpl;
import com.coco.demo.pages.HomePageIOSImpl;
import com.coco.demo.util.AppiumBase;
import com.coco.demo.util.AppiumController;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author coco
 */
public class TestBase extends AppiumBase {

    protected HomePage homePage;
    protected HelloPage helloPage;
    protected AppiumDriver driver;

    public TestBase() {
        driver = driver();
    }

    @BeforeClass
    public void setUp() throws Exception {
        AppiumController.instance.init();
        switch (AppiumController.oSEnv) {
            case "ANDROID":
                homePage = new HomePageAndroidImpl(driver);
                helloPage = new HelloPageAndroidImpl(driver);
                break;
            case "IOS":
                homePage = new HomePageIOSImpl(driver);
                helloPage = new HelloPageIOSImpl(driver);
                break;
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        AppiumController.instance.terminate();
    }
}
