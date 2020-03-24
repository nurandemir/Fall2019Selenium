package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelfPractice {
    //Go to http://practice.cybertekschool.com/tables
    //Click on "Last name" column name
    //Verify that table is sorted by last name in alphabetic order.
    private WebDriver driver;

    //    @Test
//    public void alphabeticOrder(){
//      driver.get("http://practice.cybertekschool.com/tables") ;
//    driver.findElement(By.xpath("//*[@id='table1']//th[1]/span")).click();
//    List<WebElement>lastNames=driver.findElements(By.xpath("//*[@id='table1']//tbody//tr"));
//    for(int i=0;i<lastNames.size()-1;i++){
//        String name=lastNames.get(i).getText();
//        String next=lastNames.get(i+1).getText();
//        Assert.assertTrue(name.compareTo(next)<=0);
//    }
//    }
    @Test
    public void waitForTitle() {
        driver.get("https://google.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Google"));
        driver.navigate().to("https://amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));

    }

    @Test
    public void elementToBeClickable() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5)).
                ignoring(NoSuchElementException.class);
        WebDriverWait  webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        WebElement submitButtn = wait.until(driver -> driver.findElement(By.xpath("//button[text()='Submit']\"")));
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        submitButtn.click();

    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }


    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }

}
