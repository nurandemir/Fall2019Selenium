package com.automation.tests.homeworks.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseNineToTwelve {

    WebDriver driver;
    private String URL="https://practice-cybertekschool.herokuapp.com/";

    @Test
    public void statusCodeTwoHundredDisplayMsg(){

      driver.findElement(By.xpath("//a[text()='200']")).click();
      WebElement txtStatusCode=driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(txtStatusCode.isDisplayed());

    }
    @Test
    public void statusCodeThreeHndrdOneDisplyMsg(){
        driver.findElement(By.xpath("//a[text()='301']")).click();
        WebElement txtThreeHundredOneCode=driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(txtThreeHundredOneCode.isDisplayed());

    }
    @Test
    public void statCode404Msg(){
      driver.findElement(By.xpath("//a[text()='404']")).click();
      WebElement fourHndrd4Txt=driver.findElement(By.xpath("//div[@class='example']/p"));
      Assert.assertTrue(fourHndrd4Txt.isDisplayed());

    }
    @Test
    public void statCode500Msg(){
        driver.findElement(By.xpath("//a[text()='500']")).click();
        WebElement txt505=driver.findElement(By.xpath("//div[@class='example']/p"));
        Assert.assertTrue(txt505.isDisplayed());
    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.findElement(By.linkText("Status Codes")).click();

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
