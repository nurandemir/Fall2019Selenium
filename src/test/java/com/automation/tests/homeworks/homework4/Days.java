package com.automation.tests.homeworks.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Days {
    private WebDriver driver;

@Test
public void randomlySelect(){
    List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
    List<WebElement>dayNames=driver.findElements(By.xpath("//label"));
    Random r=new Random();
    int count=0;
    while(count<3){
        int index=r.nextInt(dayNames.size());
        if(checkBoxes.get(index).isEnabled()){
            dayNames.get(index).click();
            if(dayNames.get(index).getText().equals("Friday")){
                count++;
            }
            System.out.println(dayNames.get(index).getText());
            dayNames.get(index).click();
        }
    }



}
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
    }
    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(2);
       // driver.quit();
    }
}
