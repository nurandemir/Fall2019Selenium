package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){

    String browser= ConfigurationReader.getProperty("browser");
    String url=ConfigurationReader.getProperty("qa1");
    String color = ConfigurationReader.getProperty("color");

        System.out.println(browser);// chrome
        System.out.println(url); // http://qa1.vytrack.com
        System.out.println(color); // red

        String storeManager = ConfigurationReader.getProperty("store_manager");
        String password = ConfigurationReader.getProperty("password");
        String driver = ConfigurationReader.getProperty("driver");


        System.out.println(storeManager);

        System.out.println(password);

        System.out.println(driver);


    }
}
//Basically we are creating a permanent hashMap in our project
// that has all of our preferences and settings for the whole project.
// we then create a utility class that loads up this hashMap so that
// all of our future classes will automatically use them