package com.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Sel_Home4_March30 {
    private WebDriver driver = Driver.getDriver();
    @Test
    public void test() {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserUtils.wait(2);
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        List<WebElement> labels = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
        int counter = 0;
        while (counter < 3) {
            Random random = new Random();
            //gives you a number from 0 to bound (exclusive)
            int checkboxToSelect = random.nextInt(checkboxes.size());
            if (checkboxes.get(checkboxToSelect).isEnabled()) {
                checkboxes.get(checkboxToSelect).click();
                System.out.println("Selected :: " + labels.get(checkboxToSelect).getText());
                checkboxes.get(checkboxToSelect).click();
                if (labels.get(checkboxToSelect).getText().equals("Friday")) {
                    counter++;
                }
            }
        }
        driver.quit();
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));
        Random random = new Random();
        int yearToSelect = random.nextInt(year.getOptions().size());
        //select a year
        year.selectByIndex(yearToSelect);
        for (int i = 0; i < 12; i++) {
            //we create date object based on year and month
            LocalDate localDate = LocalDate.of(yearToSelect, i + 1, 1);
            //select a month
            month.selectByIndex(i);
            int actual = day.getOptions().size();//actual number of days
            int expected = Month.from(localDate).length(isLeapYear(yearToSelect)); //expected number of days in a month
            System.out.println("Month: " + month.getFirstSelectedOption().getText());
            System.out.println("Expected number of days: " + expected);
            System.out.println("Actual number of days: " + actual);
            System.out.println();
            Assert.assertEquals(actual, expected);
        }
        driver.quit();
    }
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
        }
        return year % 4 == 0;
    }
    @Test
    public void test3() {
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        driver.findElement(By.linkText("Under $25")).click();
        //we collect only dollar values from the price of every item
        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
        //we convert collection of web elements into collection of strings
        List<String> pricesText = BrowserUtils.getTextFromWebElements(prices);
        System.out.println(pricesText);
        for (String price : pricesText) {
            //we convert every price as a string into integer
            int priceConverted = Integer.parseInt(price);
            //checking if the price of every item is under 25
            Assert.assertTrue(priceConverted < 25);
        }
        driver.quit();
    }
}


