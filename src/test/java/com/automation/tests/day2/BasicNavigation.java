package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{
        //to start selenium script we need:
        //setup webdriver(browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //in Selenium, everything starts from WebDriver interface
        driver.get("http://google.com");

        Thread.sleep(3000);
        String title=driver.getTitle();

        String expectedTitle="Google";

        System.out.println("Title is "+title);

        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TeST FAILED!");
        }

        driver.close();




    }
}
