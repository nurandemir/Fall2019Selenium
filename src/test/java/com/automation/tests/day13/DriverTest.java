package com.automation.tests.day13;

import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DriverTest {
    @Test
    public void googleTest(){
        //Driver.getDriver() ---> returns driver
        Driver.getDriver().get("http://google.com");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Google");
        Driver.closeDriver();
    }
}