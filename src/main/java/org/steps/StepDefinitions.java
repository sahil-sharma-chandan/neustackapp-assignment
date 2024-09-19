package org.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.StepImple.stepDefnitionImple;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.utils.ConfigLoader;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private WebDriver driver;
    private final ConfigLoader configLoader = new ConfigLoader();
    private stepDefnitionImple stepDefnitionImple;

    @Given("I open the application URL")
    public void i_open_the_application_url() {
        System.setProperty("webdriver.chrome.driver", configLoader.getChromeDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(configLoader.getBaseUrl());
        stepDefnitionImple = new stepDefnitionImple(driver);
        stepDefnitionImple.waitForPageToLoad();
    }

    @Then("I should see the title {string}")
    public void i_should_see_the_title(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @And("Click on start a new Application")
    public void i_should_click_on_start_a_new_Application() {
        stepDefnitionImple.clickOnStartNewApplication();
    }

    @And("Select Applicant type")
    public void select_aplicant_type(){
        stepDefnitionImple.selectAplicantType();
    }

    @And("User should be Select product")
    public void select_products(){
        stepDefnitionImple.selectProducts();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
