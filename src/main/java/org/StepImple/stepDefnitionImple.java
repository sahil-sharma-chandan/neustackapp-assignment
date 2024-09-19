package org.StepImple;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class stepDefnitionImple {
    private WebDriver
            driver;
    private WebDriverWait
            wait;

    public void waitForPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public stepDefnitionImple(WebDriver driver) {
        this.driver =
                driver;
        this.wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnStartNewApplication() {
        waitForPageToLoad();
        WebElement
                getStartButton =
                wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-next")));
        getStartButton.click();
        waitForPageToLoad();
    }

    public void selectAplicantType() {
        waitForPageToLoad();
        WebElement
                AplicatType =
                wait.until(ExpectedConditions.elementToBeClickable(By.id("option-item-0")));
        AplicatType.click();
    }

    public void selectProducts() {
        waitForPageToLoad();
        WebElement
                AplicatType =
                wait.until(ExpectedConditions.elementToBeClickable(By.id("option-item-0")));
        AplicatType.click();
    }
}
