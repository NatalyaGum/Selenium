Feature: As a user I want to get ability to use mail

  Background: Running a mailru login
    Given the user navigates to mailru home page
    When the user logs in


  Scenario Outline: Create email
    Given the user navigates to frame of mail body
    When the user creates mail addressed to "<email>"
    And the user saves a draft
    Then draft to "<email>" is displayed on draftPage
    Examples:
    |email          |
    |leoshpo@mail.ru|
    |2004nbg@mail.ru|


