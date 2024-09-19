package org.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private String
            baseUrl;
    private String
            chromeDriverPath;

    public ConfigLoader() {
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties");
            }
            properties.load(input);
            baseUrl = properties.getProperty("Assignment.baseurl");
            chromeDriverPath = properties.getProperty("Chrome.driver.path");
        } catch (Exception ex) {
            throw new RuntimeException("Error loading configuration", ex);
        }
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }
}
