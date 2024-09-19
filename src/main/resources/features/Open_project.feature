Feature: Open Application and Title Verification of the Application

  Scenario Outline: Open the application URL and verify title
    Given I open the application URL
    Then I should see the title "Welcome"
    And Click on start a new Application
    And Select Applicant type
    And User should be Select product
    And Now Enter Your First name "<FirstName>" and second name "<SecondName>"
    And Now Enter email "<Email>"
    And Now Enter your anual Income "<Salary>"
    And Now user can Select the amount of Basic Life coverage
    And Now user can enter date of birth "<DOB>"
    And Now user can select your gender "<Gender>"
    And Now user should be enter mobile number "<Mobile>"

    Examples:
      | FirstName | SecondName | Email           | Salary | DOB      | Gender | Mobile     |
      | Sahil     | Sharma     | sahil@gmail.com | 120000 | 20082001 | Male   | 9792727271 |
