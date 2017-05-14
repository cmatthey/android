/*
 * Android implementation for Home page
 */
package com.coco.demo.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAndroidImpl implements HomePage {

    public HomePageAndroidImpl(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "hello")
    public MobileElement helloBtn;

    @Override
    public void navToHello() {
        helloBtn.click();
    }
    @FindBy(id = "home")
    public MobileElement homeFld;

    @Override
    public String getHome() {
        return homeFld.getText();
    }
}
