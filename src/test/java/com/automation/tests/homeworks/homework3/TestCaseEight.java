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

public class TestCaseEight {

    WebDriver driver;
    private String URL="https://practice-cybertekschool.herokuapp.com/";

    @Test
    public void verifyUSDisplayed(){
driver.findElement(By.xpath("//div[@class='autocomplete' ]/input")).sendKeys("“United States of America");
driver.findElement(By.xpath("//input[@type='button']")).click();
WebElement result=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(result.isDisplayed());


    }

@BeforeMethod
    public void setup(){
    WebDriverManager.chromedriver().version("79").setup();
    driver=new ChromeDriver();
    driver.get(URL);
    BrowserUtils.wait(3);
    driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();

}
@AfterMethod
    public void teardown(){
    driver.quit();
}

}
