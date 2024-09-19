Feature: Open Application and Title Verification of the Application

  Scenario Outline: Open the application URL and verify title
    Given I open the application URL
    Then I should see the title "Welcome"
    And Click on start a new Application
    And I select the applicant type
    And I should select the product
    And I now enter my first name "<FirstName>" and last name "<SecondName>"
    And I now enter my email "<Email>"
    And I now enter my annual income "<Salary>"
    And I can select the amount of basic life coverage
    And I now enter my date of birth "<DOB>"
    And I now select my gender "<Gender>"
    And I now enter my mobile number "<Mobile>"

    Examples:
      | FirstName | SecondName | Email           | Salary | DOB        | Gender | Mobile     |
      | Sahil     | Sharma     | sahil@gmail.com | 120000 | 20/08/2001 | Male   | 9792727271 |
