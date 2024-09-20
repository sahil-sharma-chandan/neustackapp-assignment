package org.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private String baseUrl;
    private String chromeDriverPath;

    // Constructor that initializes the properties by calling loadProperties
    public ConfigLoader() {
        loadProperties();
    }

    // Method to load properties from the config.properties file
    private void loadProperties() {
        Properties properties = new Properties(); // Create a Properties object
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            // Attempt to find and load the config.properties file
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties");
            }
            properties.load(input); // Load properties from the input stream
            // Retrieve and assign values to class variables
            baseUrl = properties.getProperty("Assignment.baseurl");
            chromeDriverPath = properties.getProperty("Chrome.driver.path");
        } catch (Exception ex) {
            // Handle exceptions related to loading properties
            throw new RuntimeException("Error loading configuration", ex);
        }
    }

    // Getter method to return the base URL
    public String getBaseUrl() {
        return baseUrl;
    }

    // Getter method to return the Chrome driver path
    public String getChromeDriverPath() {
        return chromeDriverPath;
    }
}
