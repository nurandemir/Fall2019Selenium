package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests {

    private WebDriver driver;
    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);

        List<WebElement> searchItems=driver.findElements(By.tagName("h3"));

        for(WebElement each:searchItems){
            System.out.println(each.getText());
            String var=each.getText();
            //if there is a text print it
            if(!var.isEmpty()){ // var is short of variable
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
        //with Assertion we are verifying test, no assertion no verification
        //without assertion test is useless, every test has to have assertion

    }
    /**
     * Given user is on the amazon.com page
     * When user enters "java" as a search item
     * Then user clicks on the search button
     * And user clicks on the first search item
     * And user verifies that title of the search item contains "Java"
     */
    @Test(description="Search for Java book on amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        //there is a chance that item is not visible
        //so we need to maximize window before clicking on it
        driver.manage().window().maximize();
        BrowserUtils.wait(5);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(5);

        //find all links inside h2 elements, because h2 element is no clickable itself
        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));
        //click on the first item
        for(WebElement searchItem: searchItems){
            System.out.println("Title: "+searchItem.getText());
        }
        searchItems.get(0).click();

        BrowserUtils.wait(5);
        WebElement productTitle = driver.findElement(By.id("title"));

        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);
        Assert.assertTrue(productTitleString.contains("Java"));
        //so h2 elements are not clickable, even though they contain links
        //that's why, instead of collection all h2 elements
        //we collected all hyperlinks
        //every hyperlink represent some search item

    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79.0").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
//test without assertion is useless - what makes test => test
//without assertion you can not understand test has passed or failed

