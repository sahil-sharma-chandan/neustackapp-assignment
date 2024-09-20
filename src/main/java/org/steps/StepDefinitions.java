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
        try {
            System.setProperty("webdriver.chrome.driver", configLoader.getChromeDriverPath());
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(configLoader.getBaseUrl());
            stepDefnitionImple = new stepDefnitionImple(driver);
            stepDefnitionImple.waitForPageToLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should see the title {string}")
    public void i_should_see_the_title(String expectedTitle) {
        try {
            String actualTitle = driver.getTitle();
            assertEquals(expectedTitle, actualTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("Click on start a new Application")
    public void i_should_click_on_start_a_new_Application() {
        try {
            stepDefnitionImple.clickOnStartNewApplication();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I select the applicant type")
    public void select_aplicant_type() {
        try {
            stepDefnitionImple.selectAplicantType();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I should select the product")
    public void select_products() {
        try {
            stepDefnitionImple.selectProducts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now enter my first name {string} and last name {string}")
    public void enter_name(String firstName, String secondName) {
        try {
            waitFor(5000); // Wait for the application to stabilize
            stepDefnitionImple.enterName(firstName, secondName);
            waitFor(5000); // Wait for the name entry to process
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now enter my email {string}")
    public void enter_email(String email) {
        try {
            waitFor(5000); // Wait for the application to stabilize
            WebElement emailInput = driver.findElement(By.id("email-input"));
            emailInput.sendKeys(email);
            emailInput.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now enter my annual income {string}")
    public void enter_your_salary(String salary) {
        try {
            waitFor(5000); // Wait for the application to stabilize
            WebElement incomeInput = driver.findElement(By.id("input-number"));
            incomeInput.sendKeys(salary);
            incomeInput.sendKeys(Keys.ENTER);
            waitFor(5000); // Wait for the salary entry to process
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I can select the amount of basic life coverage")
    public void user_select_amount_basic_life_coverage() {
        try {
            waitFor(5000); // Wait for the application to stabilize
            WebElement slider = driver.findElement(By.id("coverage-slider-wrapper"));
            Actions actions = new Actions(driver);
            actions.moveToElement(slider, 50, 0).click().perform();
            WebElement nextButton = driver.findElement(By.id("btn-next"));
            nextButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now enter my date of birth {string}")
    public void user_enter_dateofBirth(String dateofbirth) {
        try {
            waitFor(5000); // Wait for the application to stabilize
            WebElement DateOfBirth = driver.findElement(By.id("date-input"));
            DateOfBirth.sendKeys(dateofbirth);
            DateOfBirth.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now select my gender {string}")
    public void user_can_select_gender(String Gender) {
        try {
            waitFor(5000); // Wait for the application to stabilize
            if (Gender.equals("Male")) {
                WebElement gender = driver.findElement(By.id("option-item-0"));
                gender.click();
            } else if (Gender.equals("Female")) {
                WebElement gender = driver.findElement(By.id("option-item-1"));
                gender.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now enter my mobile number {string}")
    public void user_enter_mobile_number(String mobile) {
        try {
            waitFor(5000); // Wait for the application to stabilize
            WebElement MobileInput = driver.findElement(By.id("input-phone"));
            MobileInput.sendKeys(mobile);
            MobileInput.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now enter my USA address {string}")
    public void user_enter_usa_address(String address) {
        try {
            waitFor(5000); // Wait for the application to stabilize
            WebElement AddressInput = driver.findElement(By.id("address-input-autocomplete"));
            AddressInput.sendKeys(address);
            waitFor(5000); // Wait for the address entry to process
            AddressInput.sendKeys(Keys.ARROW_DOWN);
            AddressInput.sendKeys(Keys.ENTER);
            WebElement AgreeConsonent = driver.findElement(By.id("address-check-auth-release-agree"));
            AgreeConsonent.click();
            WebElement AgreeHipaanotice = driver.findElement(By.id("address-check-consent-business"));
            AgreeHipaanotice.click();
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
            waitFor(5000); // Wait for the UI to update
            WebElement NextButton = driver.findElement(By.id("btn-next"));
            NextButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now select my Height from dropdown")
    public void select_height() {
        try {
            waitFor(5000); // Wait for the application to stabilize
            WebElement dropdownElement = driver.findElement(By.id("dropdown-height"));
            dropdownElement.click();
            WebElement selectHeight = driver.findElement(By.cssSelector("#headlessui-menu-item-\\:rc\\:"));
            selectHeight.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now enter my weight in ibs {string}")
    public void enter_weight(String weight) {
        try {
            waitFor(9000); // Wait for the application to stabilize
            WebElement WeightInput = driver.findElement(By.id("input-weight"));
            WeightInput.sendKeys(weight);
            waitFor(9000); // Wait for the weight entry to process
            WebElement NextButton = driver.findElement(By.id("btn-next"));
            NextButton.click();
            waitFor(9000); // Wait for the UI to update
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now select In the past ten years, or as indicated below, have you been treated for.")
    public void select_in_the_past() {
        try {
            waitFor(9000); // Wait for the application to stabilize
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
            WebElement LastTenYears = driver.findElement(By.id("checkbox-none-of-above"));
            LastTenYears.click();
            waitFor(9000); // Wait for the selection to process
            WebElement NextButton = driver.findElement(By.id("btn-next"));
            NextButton.click();
            waitFor(9000); // Wait for the UI to update
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I Now select In the past ten years, or as indicated, have you been treated for.")
    public void select_in_the_past_second() {
        try {
            waitFor(20000); // Wait for the application to stabilize
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
            WebElement LastTenYears = driver.findElement(By.id("checkbox-none-of-above"));
            LastTenYears.click();
            waitFor(9000); // Wait for the selection to process
            WebElement NextButton = driver.findElement(By.id("btn-next"));
            NextButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now choose Have consulted, been advised or been examined by any healthcare provider")
    public void choose_consulted() {
        try {
            waitFor(15000); // Wait for the application to stabilize
            WebElement chooseConsultedElement = driver.findElement(By.id("radio-no"));
            chooseConsultedElement.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now choose Do you currently take any medications")
    public void choose_medicine() {
        try {
            waitFor(10000); // Wait for the application to stabilize
            WebElement chooseMedicineElement = driver.findElement(By.id("radio-no"));
            chooseMedicineElement.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I now download my preview signed application")
    public void review_application() {
        try {
            waitFor(20000); // Wait for the application to stabilize
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
            waitFor(5000); // Wait for the UI to update
            WebElement chooseMedicineElement = driver.findElement(By.id("btn-review-unsigned-app"));
            chooseMedicineElement.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
