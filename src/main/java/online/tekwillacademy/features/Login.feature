Feature: Login Flow Tests

  @TestRun
  Scenario Outline: An error message is displayed when login uses invalid <attribute>
    Given The "https://tekwillacademy-opencart.online/index.php?route=account/login&language=en-gb" link is accessed
    And the following set of credentials is entered into the login form:
      | <email>    |
      | <password> |
    When the login button is clicked
    Then the following error messages are displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | attribute | email              | password |
      | email     | notvalid@gmail.com | Any      |
      | password  | valid@gmail.com    | invalid  |
      | email     | justdots....       | valid    |