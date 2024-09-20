package org.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.StepImple.stepDefnitionImple;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.ConfigLoader;

import java.time.Duration;

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
        waitFor(5000);
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

    @And("I now enter my USA address {string}")
    public void user_enter_usa_address(String address){
        waitFor(5000);
        WebElement AddressInput = driver.findElement(By.id("address-input-autocomplete"));
        AddressInput.sendKeys(address);
        waitFor(5000);
        AddressInput.sendKeys(Keys.ARROW_DOWN);
        AddressInput.sendKeys(Keys.ENTER);
        WebElement AgreeConsonent = driver.findElement(By.id("address-check-auth-release-agree"));
        AgreeConsonent.click();
        WebElement AgreeHipaanotice = driver.findElement(By.id("address-check-consent-business"));
        AgreeHipaanotice.click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        waitFor(5000);
        WebElement NextButton = driver.findElement(By.id("btn-next"));
        NextButton.click();
    }

    @And("I now select my Height from dropdown")
    public void select_height(){
        waitFor(5000);
        WebElement dropdownElement = driver.findElement(By.id("dropdown-height"));
        dropdownElement.click();
        WebElement selectHeight = driver.findElement(By.cssSelector("#headlessui-menu-item-\\:rc\\:"));
        selectHeight.click();
    }

    @And("I now enter my weight in ibs {string}")
    public void enter_weight(String weight){
        waitFor(9000);
        WebElement WeightInput = driver.findElement(By.id("input-weight"));
        WeightInput.sendKeys(weight);
        waitFor(9000);
        WebElement NextButton = driver.findElement(By.id("btn-next"));
        NextButton.click();
        waitFor(9000);
    }
    @And("I now select In the past ten years, or as indicated below, have you been treated for.")
    public void select_in_the_past(){
        waitFor(9000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        WebElement LastTenYears = driver.findElement(By.id("checkbox-none-of-above"));
        LastTenYears.click();
        waitFor(9000);
        WebElement NextButton = driver.findElement(By.id("btn-next"));
        NextButton.click();
        waitFor(9000);
    }

    @And("I Now select In the past ten years, or as indicated, have you been treated for.")
    public void select_in_the_past_second() {
        waitFor(20000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        WebElement LastTenYears = driver.findElement(By.id("checkbox-none-of-above"));
        LastTenYears.click();
        waitFor(9000);
        WebElement NextButton = driver.findElement(By.id("btn-next"));
        NextButton.click();
    }

    @And("I now choose Have consulted, been advised or been examined by any healthcare provider")
    public void choose_consulted(){
        waitFor(20000);
        WebElement chooseConsultedElement = driver.findElement(By.id("radio-no"));
        chooseConsultedElement.click();
    }

    @And("I now choose Do you currently take any medications")
    public void choose_medicine(){
        waitFor(20000);
        WebElement chooseMedicineElement = driver.findElement(By.id("radio-no"));
        chooseMedicineElement.click();
    }

    @And("I now download my preview signed application")
    public void review_application(){
        waitFor(20000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        waitFor(5000);
        WebElement chooseMedicineElement = driver.findElement(By.id("btn-review-unsigned-app"));
        chooseMedicineElement.click();
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
