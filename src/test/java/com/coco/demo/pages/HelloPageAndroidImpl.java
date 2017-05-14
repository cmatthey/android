/*
 * Android implementation for Hello page
 */
package com.coco.demo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelloPageAndroidImpl implements HelloPage {

    public HelloPageAndroidImpl(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "hello")
    public MobileElement helloFld;

    @Override
    public String getHello() {
        return helloFld.getText();
    }
}
