package org.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.StepImple.stepDefnitionImple;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

    @And("I select the applicant type")
    public void select_aplicant_type() {
        stepDefnitionImple.selectAplicantType();
    }

    @And("I should select the product")
    public void select_products() {
        stepDefnitionImple.selectProducts();
    }

    @And("I now enter my first name {string} and last name {string}")
    public void enter_name(String firstName, String secondName) {
        stepDefnitionImple.enterName(firstName, secondName);
        waitFor(5000);
    }

    @And("I now enter my email {string}")
    public void enter_email(String email) {
        waitFor(5000);
        WebElement emailInput = driver.findElement(By.id("email-input"));
        emailInput.sendKeys(email);
        emailInput.sendKeys(Keys.ENTER);
    }

    @And("I now enter my annual income {string}")
    public void enter_your_salary(String salary) {
        waitFor(5000);
        WebElement incomeInput = driver.findElement(By.id("input-number"));
        incomeInput.sendKeys(salary);
        incomeInput.sendKeys(Keys.ENTER);
        waitFor(5000);
    }

    @And("I can select the amount of basic life coverage")
    public void user_select_amount_basic_life_coverage() {
        waitFor(5000);
        WebElement slider = driver.findElement(By.id("coverage-slider-wrapper"));
        Actions actions = new Actions(driver);
        actions.moveToElement(slider, 50, 0).click().perform();
        WebElement nextButton = driver.findElement(By.id("btn-next"));
        nextButton.click();
    }

    @And("I now enter my date of birth {string}")
    public void user_enter_dateofBirth(String dateofbirth) {
        waitFor(5000);
        WebElement DateOfBirth = driver.findElement(By.id("date-input"));
        DateOfBirth.sendKeys(dateofbirth);
        DateOfBirth.sendKeys(Keys.ENTER);
    }

    @And("I now select my gender {string}")
    public void user_can_select_gender(String Gender) {
        waitFor(5000);
        if (Gender.equals("Male")) {
            WebElement gender = driver.findElement(By.id("option-item-0"));
            gender.click();
        } else if (Gender.equals("Female")) {
            WebElement gender = driver.findElement(By.id("option-item-1"));
            gender.click();
        }
    }

    @And("I now enter my mobile number {string}")
    public void user_enter_mobile_number(String mobile) {
        waitFor(5000);
        WebElement MobileInput = driver.findElement(By.id("input-phone"));
        MobileInput.sendKeys(mobile);
        MobileInput.sendKeys(Keys.ENTER);
    }

    private void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
