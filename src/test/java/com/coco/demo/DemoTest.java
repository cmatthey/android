/*
 * Sample tests
 */
package com.coco.demo;

import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 *
 * @author coco
 */
public class DemoTest extends TestBase {

    @Test(description = "Verify Hello world! verbiage on Hello page")
    public void testHello() {
        final String expectedText = "Hello world!";
        String actualText;

        homePage.navToHello();
        actualText = helloPage.getHello();
        MatcherAssert.assertThat(actualText, is(expectedText));
    }

    @Test(description = "Verify Demo verbiage on Home page")
    public void testHome() {
        final String expectedText = "Demo";
        String actualText;

        homePage.navToHello();
        actualText = helloPage.getHello();
        back();
        MatcherAssert.assertThat(actualText, is(expectedText));
        actualText = helloPage.getHello();
    }

    @AfterMethod
    public void back() {
        driver.navigate().back();
    }
}
