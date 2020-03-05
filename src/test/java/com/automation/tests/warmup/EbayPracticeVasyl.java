package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayPracticeVasyl {
    static WebDriver driver;

    public static void main(String[] args)throws Exception {
//ebayTest();
//amazonTest();
wikiTest();


    }
    public static void ebayTest()throws Exception{
        driver= DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("Java Book"+ Keys.ENTER);

        Thread.sleep(3000);
        WebElement researchResult=driver.findElement(By.tagName("h1"));
        System.out.println(researchResult.getText().split(" ")[0]);

        driver.quit();

    }
    public static void amazonTest()throws Exception{
        driver=DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Book",Keys.ENTER);

        Thread.sleep(3000);
        String title=driver.getTitle();
        if(title.contains("Java Book")){
            System.out.println("Test passed!");
        }else{
            System.out.println("Test failed!");
        }

        driver.quit();
    }
    public static void wikiTest()throws Exception{
        driver = DriverFactory.createDriver("chrome");
        //Go to wikipedia.org
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        //enter search term `selenium webdriver` & click on search button
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);

        Thread.sleep(3000);

        //click on search result `Selenium (software)`
        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(2000);

        String link = driver.getCurrentUrl(); // to get link as a String
        //verify url ends with `Selenium_(software)`

        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();



    }
}
