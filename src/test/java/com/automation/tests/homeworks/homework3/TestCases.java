package com.automation.tests.homeworks.homework3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {
    private String URL = "https://practice-cybertekschool.herokuapp.com/registration_form";
    private WebDriver driver;
    private By usernameBy=By.name("username");
    private By emailBy=By.name("email");
    private By passwordBy=By.name("password");
    private By phoneBy=By.name("phone");

    private By maleBy=By.cssSelector("input[value='male']");
    private By femaleBy=By.cssSelector("input[value='female']");
    private By otherBy=By.cssSelector("input[value='other']");

    private By dateOfBirthBy = By.cssSelector("input[name=birthday]");
    private By departmentBy=By.name("department");
    private By jobTitleBy=By.name("job_title");
    private By signUpBy=By.id("wooden_spoon");
    private By warningMessage = By.xpath("//small[text()='The date of birth is not valid']");//?
    private By cplusplusBy = By.xpath("//label[text(),'C++]'");
    private By javaBy = By.xpath("//label[text()='Java']");
    private By javaScriptBy = By.xpath("//label[text(),'JavaScript']");
    private By firstNameBy = By.name("firstname");
    private By lastNameBy=By.name("lastname");
    private By warningFirstNameBy = By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']");
    private By warningLastNameBy=By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']");
    //private By succesfullRegisMessage=By

    @Test(description = "wrong birthday")
    public void invalidDateOfBirth() {
        driver.findElement(dateOfBirthBy).sendKeys("wrong_dob");
        BrowserUtils.wait(5);

        WebElement warningElement = driver.findElement(warningMessage);
        BrowserUtils.wait(5);
        Assert.assertTrue(warningElement.isDisplayed());
        BrowserUtils.wait(5);
       String expected="The date of birth is not valid";
       String actual=warningElement.getText();
       Assert.assertEquals(expected, actual);


    }

    @Test
    public void displayJavaJavascriptC() {

        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'C++')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Java')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'JavaScript')]")).isDisplayed());


    }

    @Test
    public void displayWarningMessageFirst() {
        driver.findElement(firstNameBy).sendKeys("b");
        WebElement warning = driver.findElement(warningFirstNameBy);
        Assert.assertTrue(warning.isDisplayed());


    }
    @Test
    public void verifyDisplayMessageLast(){
        driver.findElement(lastNameBy).sendKeys("a");
        WebElement warningLastName = driver.findElement(warningLastNameBy);
        Assert.assertTrue(warningLastName.isDisplayed());

    }
    @Test
    public void fillOutRegistrationFrom(){
        driver.findElement(firstNameBy).sendKeys("Patrick");
        driver.findElement(lastNameBy).sendKeys("White");
        driver.findElement(usernameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@email.com");
        driver.findElement(passwordBy).sendKeys("123455678");
        driver.findElement(phoneBy).sendKeys("234-123-1231");
        driver.findElement(maleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("01/02/1940");

        Select departmentSelect=new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobTitleSelect=new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(5);
        String expected="You've successfully completed registration!";
        String actual=driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);





    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        BrowserUtils.wait(5);


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
