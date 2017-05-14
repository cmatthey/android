/*
 * iOS implementation for Home page
 */
package com.coco.demo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageIOSImpl implements HomePage {

    public HomePageIOSImpl(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
    public MobileElement helloBtn;

    @Override
    public void navToHello() {
        helloBtn.click();
    }

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
    public MobileElement homeFld;

    @Override
    public String getHome() {
        return homeFld.getText();
    }
}
