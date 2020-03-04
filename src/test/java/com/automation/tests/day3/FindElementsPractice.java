package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");

        driver.findElement(By.name("username")).sendKeys("tomsmith");

        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        Thread.sleep(2000);

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();

        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //let's click on Logout button. It looks like a button, but it's actually a link
        //every element with <a> tag is a link
        //if you have couple spaces in the text, just use partialLinkText instead of linkText
        //linkText - equals()
        //partialLinkText - contains()-complete match doesn't required

        WebElement logout = driver.findElement(By.partialLinkText("Logout"));

        String href=logout.getAttribute(("href"));
        System.out.println(href);

        String classname=logout.getAttribute("class");
        System.out.println(classname);

        logout.click();
        Thread.sleep(2000);

        //let's enter invalid credentials
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        System.out.println(errorMessage.getText());
        Thread.sleep(2000);

        driver.quit();






//we are writing same codes again and again
//we will write a method and call it : DRY Principle
//sth that support our code : utilities
//under automation package
//We created utilities package and DriverFactory class under automation package
//we wrote reusable methods inside DriverFactory class named => createDriver
//whenever we need to crate webDriver object
//we will call our custom method
/*
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
 */
    }
}
