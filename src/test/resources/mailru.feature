Feature: As a user I want to get ability to use mailbox

  Background: running a mailru login
    Given the user navigates to mailru home page
    When the user logs in


  Scenario Outline: create email
    Given the user navigates to frame of mail body
    When the user creates mail addressed to "<email>"
    And the user saves a draft
    Then draft to "<email>" is displayed on draftPage
    Examples:
    |email          |
    |leoshpo@mail.ru|
    |2004nbg@mail.ru|


  Scenario:send email from draft
    Given the user navigates in draftBox with mail
    When the user opens mail and sends it
    Then the mail is in sentBox with the current time


  Scenario:clean spamBox
    Given the user navigates in spamBox
    When the user cleans spamBox
    Then the spamBox is empty


  Scenario:log out from mailbox
    When the user logs out from mailbox
    Then the user is on Home page and logged out