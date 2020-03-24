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

public class TestCaseSix {
    private WebDriver driver;
    private String URL="https://www.tempmailaddress.com/";
    private String URL2="https://practice-cybertekschool.herokuapp.com/";

   @Test
   public void receiveEmailOpen(){
       driver.get(URL);
       BrowserUtils.wait(5);
       WebElement copyEmail=driver.findElement(By.id("email"));
       String email=copyEmail.getText();
       driver.navigate().to(URL2);
       driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
       driver.findElement(By.name("full_name")).sendKeys("Jane Smith");
       driver.findElement(By.name("email")).sendKeys(email);
       driver.findElement(By.name("wooden_spoon")).click();
       BrowserUtils.wait(5);

       String actual=driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();//?
       BrowserUtils.wait(5);
       String expected="Thank you for signing up. Click the button below to return to the home page.";
       Assert.assertEquals(actual,expected);

       driver.navigate().to(URL);
       BrowserUtils.wait(5);
       String expected2= driver.findElement(By.xpath("//tbody[@id='schranka']/tr[1]/td[1]")).getText().trim();
                                               //By.xpath("//table/tbody/tr[1]/td
       System.out.println(expected2);

       String actual2="do-not-reply@practice.cybertekschool.com";
       Assert.assertEquals(actual2,expected2);
       BrowserUtils.wait(5);

       driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-envelope']")).click();
       String actual3=driver.findElement(By.xpath("//span[@id='odesilatel']")).getText();
       String expected3="do-not-reply@practice.cybertekschool.com";
       Assert.assertEquals(actual3,expected3);

       String actual4=driver.findElement(By.xpath("//span[text()='Thanks for subscribing to practice.cybertekschool.com!']")).getText();
      String expected4="Thanks for subscribing to practice.cybertekschool.com!";
       Assert.assertEquals(actual4,expected4);


   }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();



    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
