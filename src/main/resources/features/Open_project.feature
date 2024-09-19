Feature: Open Application and title verification of the Application

  Scenario: Open the application URL and verify title
    Given I open the application URL
    Then I should see the title "Welcome"
    And Click on start a new Application
    And Select Applicant type
    And User should be Select product

