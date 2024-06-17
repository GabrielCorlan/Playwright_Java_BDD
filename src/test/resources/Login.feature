Feature: User login

  Scenario: Login in DemoQA using valid credentials
    Given User clicks on login button
    When User inputs username and password
    Then User is redirected to homepage