package com.coco.demo.util;

import io.appium.java_client.AppiumDriver;

/**
 *
 * @author coco
 */
public abstract class AppiumBase {

    protected AppiumDriver driver() {
        return AppiumController.instance.driver;
    }
}
