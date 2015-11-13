@Login
Feature: Login
  Test successfully and unsuccessfully login and logout

  @SmokeTest
  Scenario: Users should be able to login using valid credentials
    Given I navigate to Login page
    When I login as "Silvia" with password "Password"
    Then I should login successfully

  #@SmokeTest
  #Scenario Outline: Users should be able to login using valid credentials
#    Given I navigate to Login page
#    When I login as "<User Name>" with password "<Password>"

#    Then I should login successfully

  #Examples:
#    | User Name  | Password     |
#    | Admin      |              |
#    | Browse     | Password123! |
#    | Concurrent | Password123! |

  #@SmokeTest
  #Scenario Outline: Users should be able to login using valid credentials
   # Given I navigate to Login page
    #When I login as "<User Name>" with password "<Password>"
    #Then I should not be able to login

  #Examples:
   # | User Name  | Password     |
    #| Admin      |              |
    #| Browse     | Password123! |
    #| Concurrent | Password123! |