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


WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();

        driver.findElement(By.id("gh-ac")).sendKeys("selenium books" + Keys.ENTER);
        System.out.println(driver.findElement(By.tagName("h1")).getText().split(" ")[0]);
        driver.quit();

        //go to amazon
        //Go to ebay
        //enter search term
        //click on search button
        //verify title contains search term
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("cookbook");

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



//        //Go to wikipedia.org
//        //enter search term `selenium webdriver`
//        //click on search button
//        //click on search result `Selenium (software)`
//        //verify url ends with `Selenium_(software)`
//
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

        //Vasyl' way
        //public class March4 {
        //    static WebDriver driver;
        //    public static void main(String[] args) throws Exception{
        ////        ebayTest();
        ////        amazonTest();
        //        wikiTest();
        //    }
        //    /**
        //     * Go to ebay --->          driver.get("http://ebay.com");
        //     * enter search term        input.sendKeys("java book");
        //     * click on search button   searchButton.click();
        //     * print number of results
        //     */
        //    public static void ebayTest() throws Exception {
        //        WebDriver driver = DriverFactory.createDriver("chrome");
        //        driver.get("http://ebay.com");
        //        Thread.sleep(2000);//to wait 2 seconds
        //        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        //        Thread.sleep(2000);//to wait 2 seconds
        //        driver.findElement(By.id("gh-btn")).click();
        //        Thread.sleep(4000);//to wait 2 seconds
        //        WebElement searchResults = driver.findElement(By.tagName("h1"));
        //        String[] searchSentence = searchResults.getText().split(" ");
        //        System.out.println(Arrays.toString(searchSentence));
        //        System.out.println(searchSentence[0]);
        //        driver.quit();
        //    }
        //    /**
        //     * go to amazon
        //     * enter search term
        //     * click on search button
        //     * verify title contains search term
        //     */
        //    public static void amazonTest() throws Exception{
        //        driver = DriverFactory.createDriver("chrome");
        //        driver.get("http://amazon.com");
        //        //enter text and click ENTER
        //        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        //        Thread.sleep(4000);//to wait 2 seconds
        //        String title = driver.getTitle();
        //        if(title.contains("java book")){
        //            System.out.println("TEST PASSED");
        //        }else {
        //            System.out.println("TEST FAILED");
        //        }
        //        driver.quit();
        //    }
        //    /**
        //     * Go to wikipedia.org
        //     * enter search term `selenium webdriver`
        //     * click on search button
        //     * click on search result `Selenium (software)`
        //     * verify url ends with `Selenium_(software)`
        //     */
        //    public static void wikiTest() throws Exception{
        //        driver = DriverFactory.createDriver("chrome");
        //        //Go to wikipedia.org
        //        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        //        //enter search term `selenium webdriver` & click on search button
        //        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);
        //        Thread.sleep(3000);
        //        //click on search result `Selenium (software)`
        //        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        //        Thread.sleep(2000);
        //        String link = driver.getCurrentUrl(); // to get link as a String
        //        //verify url ends with `Selenium_(software)`
        //        if(link.endsWith("Selenium_(software)")){
        //            System.out.println("TEST PASSED");
        //        }else {
        //            System.out.println("TEST FAILED");
        //        }
        //        driver.quit();
        //    }
        //}
    }
}
