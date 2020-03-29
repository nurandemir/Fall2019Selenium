package com.automation.pages.fleet;

//for every page we are gonna create a corresponding page
// We can group page classes based on tab name

//vytrack app pages --framework ->page package
//Vehicles. -> VehiclePage.java
//Vehicles Models -> VehiclesModelsPage.java
//Vehicle Costs. -> vehicleCostsPage.java

import com.automation.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends AbstractPageBase {
    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;

    public void clickToCreateCar() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();

    }
}
//page to page
//test to test