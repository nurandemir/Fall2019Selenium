package com.automation.tests.homeworks.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DepartmentsSort {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
    }
    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }

    @Test
    public void verfyAllNotSorted(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-close']")).click();
       
    }




}
