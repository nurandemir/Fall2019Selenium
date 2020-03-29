package com.automation.tests.homeworks.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TodaysDate {
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
    public void selectBirthday(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

     WebElement year=driver.findElement(By.id("year"));
     Select selectYear=new Select(year);
     selectYear.selectByVisibleText("2020");
     String expected="2020";

     WebElement month=driver.findElement(By.id("month"));
     Select selectMonth=new Select(month);
     selectMonth.selectByVisibleText("March");
     String expected2="March";


     WebElement day=driver.findElement(By.id("day"));
     Select selectDay=new Select(day);
     selectDay.selectByVisibleText("25");
     String expected3="25";
/*
driver.get("http://practice.cybertekschool.com/dropdown");
    WebElement year = driver.findElement(By.id("year"));
    WebElement month = driver.findElement(By.id("month"));
    WebElement day = driver.findElement(By.id("day"));
    Select y = new Select(year);
    Select m = new Select(month);
    Select d = new Select(day);
    String year_value = y.getFirstSelectedOption().getText();
    String month_value = m.getFirstSelectedOption().getText();
    String day_value = d.getFirstSelectedOption().getText();
    SimpleDateFormat sf = new SimpleDateFormat("yyyyMMMMdd");
    Assert.assertEquals(year_value+month_value+day_value, sf.format(new Date()));
 */





    }
}
