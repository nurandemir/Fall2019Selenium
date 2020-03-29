package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {
    @Test
    public void test(){

        // System.getProperty("user.dir") + "/pom.xml"
        //Users/nuran/IdeaProjects/Fall2019Selenium=>user.dir
        System.out.println(System.getProperty("user.dir"));// you will get project's path
        System.out.println(System.getProperty("os.name"));// Mac OS X
        //flexible path to downloads folder
        //System.getProperty("user.home")+"/Downloads"
        System.out.println(System.getProperty("user.home"));//Users/nuran

        String pathToDownloads=System.getProperty("user.home")+"/Downloads"; // works for everybody
        System.out.println(pathToDownloads); ///Users/nuran/Downloads

        System.out.println(System.getProperty("os.arch")); // x86_64

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
    }

// user.dir => to specify path to the project
//properties:
//when building a framework, collection of libraries, classes, tests in the classes reusable method,
//test data, we have so many codes and we have to organize them,
//you want one central point of configuration, how you are gonna manage
  //URL define for all your classes one time
    // control panel
}
