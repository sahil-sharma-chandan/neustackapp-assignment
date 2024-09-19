package com.example.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", glue = "org.steps", plugin = {"pretty", "html:target/cucumber-reports"})
public class TestRunner {
    // This class is empty, it's just a runner for the Cucumber tests
}