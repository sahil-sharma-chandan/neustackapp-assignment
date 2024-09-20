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
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    private void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickOnStartNewApplication() {
        waitForPageToLoad();
        WebElement getStartButton = waitUntilClickable(By.id("btn-next"));
        getStartButton.click();
        waitForPageToLoad();
    }

    public void selectAplicantType() {
        waitFor(5000);
        WebElement aplicantType = waitUntilClickable(By.id("option-item-0"));
        aplicantType.click();
    }

    public void selectProducts() {
        waitForPageToLoad();
        waitFor(5000);
        WebElement basicLife = waitUntilClickable(By.id("checkbox-item-3"));
        basicLife.click();
        waitFor(5000);
        basicLife.sendKeys(Keys.ENTER);
    }

    public void enterName(String firstName, String secondName) {
        WebElement firstNameField = waitUntilVisible(By.id("first_name"));
        firstNameField.sendKeys(firstName);
        WebElement secondNameField = waitUntilVisible(By.id("last_name"));
        secondNameField.sendKeys(secondName);
        secondNameField.sendKeys(Keys.ENTER);
        waitFor(5000);
    }
}
