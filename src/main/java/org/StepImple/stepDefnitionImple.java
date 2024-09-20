package org.StepImple;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class stepDefnitionImple {
    private WebDriver driver;
    private WebDriverWait wait;

    public stepDefnitionImple(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForPageToLoad() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
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

    private WebElement waitUntilClickable(By locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null if the element is not clickable
        }
    }

    private WebElement waitUntilVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null if the element is not visible
        }
    }

    public void clickOnStartNewApplication() {
        try {
            waitForPageToLoad();
            WebElement getStartButton = waitUntilClickable(By.id("btn-next"));
            if (getStartButton != null) {
                getStartButton.click();
            }
            waitForPageToLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectAplicantType() {
        try {
            waitFor(5000); // Wait for the application to stabilize
            WebElement aplicantType = waitUntilClickable(By.id("option-item-0"));
            if (aplicantType != null) {
                aplicantType.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectProducts() {
        try {
            waitForPageToLoad();
            waitFor(5000); // Wait for the application to stabilize
            WebElement basicLife = waitUntilClickable(By.id("checkbox-item-3"));
            if (basicLife != null) {
                basicLife.click();
                waitFor(5000); // Wait for the selection to process
                basicLife.sendKeys(Keys.ENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterName(String firstName, String secondName) {
        try {
            WebElement firstNameField = waitUntilVisible(By.id("first_name"));
            if (firstNameField != null) {
                firstNameField.sendKeys(firstName);
            }
            WebElement secondNameField = waitUntilVisible(By.id("last_name"));
            if (secondNameField != null) {
                secondNameField.sendKeys(secondName);
                secondNameField.sendKeys(Keys.ENTER);
            }
            waitFor(5000); // Wait for the name entry to process
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
