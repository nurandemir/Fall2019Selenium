package com.officeHours;

import com.automation.tests.vytrek.AbstractTestBase;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumOH_Wait_March31 extends AbstractTestBase {
    /*
    Implicit Wait:-set it 1 time and it will work for every findElement method
    -NoSuchElementException

    Thread.sleep- not Selenium wait! Thread -java class,sleep() method of Thread class
                  stops the execution of java program
                  -we never want to use this method in our tests

     Explicit Wait : We have to declare every time before the interaction with element
                     Expected Condition we are looking for

     Singleton: it helps to make sure we have only 1 instance of driver object at a time
     */

    @Test
    public void testWait() {
        Driver.getDriver().get("http://qa3.vytrack.com");

        WebElement user=Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement password=Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement submit=Driver.getDriver().findElement(By.id("_submit"));

        user.sendKeys("salesmanager110");
        password.sendKeys("UserUser123");
        submit.click();


    }

}
