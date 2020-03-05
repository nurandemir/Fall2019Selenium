package com.automation.tests.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayPractice {
    public static void main(String[] args) throws Exception{
        //Go to ebay
        //enter search term
        //click on search button
        //print number of results

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("selenium books" + Keys.ENTER);
        System.out.println(driver.findElement(By.tagName("h1")).getText().split(" ")[0]);
        driver.quit();

        //go to amazon
        //Go to ebay
        //enter search term
        //click on search button
        //verify title contains search term
        //driver.get("https://www.amazon.com/");
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("cookbook");

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.amazon.com/");
        driver1.findElement(By.id("twotabsearchtextbox")).sendKeys("cookbook",Keys.ENTER);
        String title=driver1.getTitle();
        System.out.println("title = " + title);

        if(title.contains("cookbook")){
            System.out.println("Test passed!");
        }else{
            System.out.println("Test Failed!");
        }

        driver1.quit();



        //Go to wikipedia.org
        //enter search term `selenium webdriver`
        //click on search button
        //click on search result `Selenium (software)`
        //verify url ends with `Selenium_(software)`

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://www.wikipedia.com/");

        driver2.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver2.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);
        String link = driver2.getCurrentUrl(); // to get link as a String
        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver2.quit();

    }
}
