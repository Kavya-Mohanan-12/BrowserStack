Feature: SignUpAndSignIn

  This feature covers scenarios related to Sign-Up and Sign-In

  Scenario Outline: Login with various user credentials
    Given I am on the login page of "https://www.saucedemo.com/"
    When I enter my username as "<username>"
    And I enter my password as "<password>"
    And I click the login button
    Then I should see "<expected_result>"

    @3060
    Examples:
      | username      | password     | expected_result         |
      | standard_user | secret_sauce | Redirected to home page  |

    @3061
    Examples:
      | username        | password     | expected_result                      |
      | locked_out_user | secret_sauce | Sorry, this user has been locked out  |

    @3062
    Examples:
      | username     | password     | expected_result         |
      | problem_user | secret_sauce | Redirected to home page  |

    @3063
    Examples:
      | username                | password     | expected_result         |
      | performance_glitch_user | secret_sauce | Redirected to home page  |

    @3064
    Examples:
      | username                   | password        | expected_result                                             |
      | performance_glitch_user123 | secret_sauce123 | Username and password do not match any user in this service |
