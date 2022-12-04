Feature: mailru

  Scenario:Running a mailru login

    Given user navigate to mailru home page
    When click signIn button
    And enters user credentials
    And submits login form
    Then mailbox page is displayed