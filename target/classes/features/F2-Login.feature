Feature: F2-Login | user should be able to login to the system


  Scenario: user login with valid data
    When    user navigate to login page
    And     user enter "eng.christine.hany@gmail.com" and "CHri01)$"
    Then    user click on login button
    And     user could login successfully and go to home page


  Scenario: user login with invalid data
    When    user navigate to login page
    And     user enter "eng.christine.hany@gmail.com" and "123456"
    Then    user click on login button
    And     user could not login successfully and go to home page