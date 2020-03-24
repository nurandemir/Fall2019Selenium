package com.automation.tests.homeworks.homework3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseSeven {
    private WebDriver driver;
    private String URL="https://practice-cybertekschool.herokuapp.com";

@Test
public void uploadFileVerify(){
    driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("/Users/nuran/Desktop/Create a Car.txt");
    //Users/nuran/Desktop/Create a Car.txt
    BrowserUtils.wait(5);
    driver.findElement(By.xpath("//input[@id='file-submit']")).click();
    BrowserUtils.wait(5);
    String expected=driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
    BrowserUtils.wait(5);
    String actual="File Uploaded!";
    Assert.assertEquals(actual, expected);

    WebElement fileUploaded=driver.findElement(By.id("uploaded-files"));
    Assert.assertTrue(fileUploaded.isDisplayed());

}


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//a[text()='File Upload']")).click();


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
