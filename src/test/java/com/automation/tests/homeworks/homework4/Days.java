package com.automation.tests.homeworks.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Days {
    private WebDriver driver;

@Test
public void clickonRandomCheckBox()
{
//    List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
//    Random ram=new Random();
//
//    if(!checkboxes.get(ram).isSelected)
//    {
//        checkboxes.get(ram).click();
//    }
}
//public void randomlySelect(){
//    List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
//    Random ram=new Random();
//    int ranDay=ram.nextInt(5);
//    if(!checkBoxes.get(ram).isSelected)
//    {
//        checkBoxes.get(ram).click();
//    }
//}


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
    }
    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
        driver.quit();
    }


}
