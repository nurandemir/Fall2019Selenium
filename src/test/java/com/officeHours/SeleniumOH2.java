package com.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    public static void main(String[] args) {

        //1.go to the automationpractice.com
        //2.search for 'Tshirt' in a searchbox +click enter or click search button
        //3.Validate you got 'no results' message on UI
        //4.Search for 'tshirt'
        //5.Validate there was  I result found

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com");
        WebElement search_box=driver.findElement(By.id("search_query_top"));
        search_box.sendKeys("tshirt"+ Keys.ENTER);

        //No results were found for your search "tshirt"
        WebElement error=driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
        String errorText=error.getText();
        System.out.println(errorText);

        search_box=driver.findElement(By.id("search_query_top"));
        search_box.clear();
        search_box.sendKeys("t-shirt"+Keys.ENTER);

        WebElement count=driver.findElement(By.className("product-count"));
        System.out.println(count.getText());


        /*
        <a class="button ajax_add_to_cart_button btn btn-default"
        href="http://automationpractice.com/index.php?controller=cart&amp;add=1&amp;id_product=1&amp;token=e817bb0705dd58da8db074c69f729fd8"
        rel="nofollow" title="Add to cart" data-id-product="1">
            <span>Add to cart</span>
        </a>
        a - link
        span - description
         */
        WebElement addToCart = driver.findElement(By.className("button ajax_add_to_cart_button btn btn-default"));
        addToCart.click();


        driver.quit();

    }
}
