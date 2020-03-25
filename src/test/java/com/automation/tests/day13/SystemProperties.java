package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {
    @Test
    public void test(){
        // /Users/studio2/IdeaProjects/Fall2019Selenium/pom.xml
        // System.getProperty("user.dir") + "/pom.xml"
        System.out.println(System.getProperty("user.dir"));//  you will get project's path
        System.out.println(System.getProperty("os.name"));
        //flexible path to downloads folder
        //System.getProperty("user.home")+"/Downloads"
        System.out.println(System.getProperty("user.home"));

        String pathToDownloads=System.getProperty("user.home")+"/Downloads"; // works for everbody
        System.out.println(pathToDownloads);

        System.out.println(System.getProperty("os.arch"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
    }

// user.dir => to specify path to the project

//when building a framework, collection of libraries, classes, tests in the classes reusable method,
//test data, we have so many codes and we have to organize them,
//you want one central point of configuration,
  //URL define for all your classes one time
    // browser
}
