@Login
Feature: Login
  Test successfully and unsuccessfully login and logout

  @SmokeTest
  Scenario: Users should be able to login using valid credentials
    Given I navigate to Login page
    When I login as "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
    Then I should login successfully.

  @SmokeTest
  Scenario: Users should be able to logout
    Given I navigate to Login page
      And I login as "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
      And I should login successfully.

    When I want to close session

    Then I should logout successfully.

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