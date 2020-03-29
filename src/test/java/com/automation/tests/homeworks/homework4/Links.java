package com.automation.tests.homeworks.homework4;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Links {
    WebDriver driver;
    @Test
    public void links(){
        driver.get("https://www.w3schools.com/");
        List<WebElement> l1 = driver.findElements(By.tagName("a"));
        for(WebElement each : l1){
            if(each.isDisplayed()){
                System.out.println(each.getText());
                System.out.println(each.getAttribute("href"));
            }
        }
    }

}
/*
@Test
public void valid_links(){
    driver.get("https://www.selenium.dev/documentation/en/");
    List<WebElement> links = driver.findElements(By.tagName("a"));
    for(int i=0; i<links.size(); i++){
        String href = links.get(i).getAttribute("href");
        try {
            URL url = new URL(href);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();
            Assert.assertEquals(httpURLConnection.getResponseCode(), 200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 */