package com.automation.tests.vytrek.fleet;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrek.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclesPageTests extends AbstractTestBase {

    @Test
    public void verifyTitle(){
        LoginPage loginPage=new LoginPage();
        VehiclesPage vehiclesPage=new VehiclesPage();

        loginPage.login();
        vehiclesPage.navigateTo("Fleet","Vehicles");

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
