Feature: As a user I want to get ability to use mailru

  Scenario:Running a mailru login
    Given the user navigates to mailru home page
    When the user logs in
    Then user's mailbox page is displayed