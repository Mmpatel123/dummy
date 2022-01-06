@contact
Feature: As customer I
  want to contact us

  Scenario: contact us
    Given I am on the home page
    When I click on the "contact us" at footer menu
    Then I should see contact us page
    And the url should contain with "/contactus"

    Scenario: Validate ContactUs page with valid Name,Email and Enquiry
      Given I am on the home page
      When I click on the "contact us" at footer menu
     And I enter name "Amisha", email "am@gmail.com" and enquiry "About product"
      And I click on submit on Contact Us page
      Then I should see "Your enquiry has been successfully sent to the store owner" message
