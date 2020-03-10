package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));

        //Whether this select element support selecting multiple options at the same time?
        //This is done by checking the value of the "multiple" attribute
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println("isMultiple = " + isMultiple);//if it's true, you can select many options

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        //lets get all selected options
        List<WebElement>selectedLanguages=languagesSelect.getAllSelectedOptions();

        for(WebElement selectedLanguage:selectedLanguages){
            System.out.println("selectedLanguage = " + selectedLanguage.getText());
        }

        BrowserUtils.wait(3);

        languagesSelect.deselectByVisibleText("Java");

        BrowserUtils.wait(3);

        languagesSelect.deselectAll();


        BrowserUtils.wait(3);
        driver.quit();
    }
}
