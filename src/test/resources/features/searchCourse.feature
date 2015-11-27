@SearchCourse
Feature: Search any course
  Search any course that successfully and unsuccessfully.

  @SmokeTest
  Scenario: Search any course when a user login.
    Given I navigate to Main Page
    And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
    When I search a course like "JavaScript"
    Then obtain a "JavaScript" list course.

  @SmokeTest
  Scenario: Search any course but that don't is present in the list.
    Given I navigate to Main Page
    And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
    When I search a course like "Qwerty"
    Then do not obtain "Qwerty" none course.

  Scenario: Enroll for a course.
    Given I navigate to Main Page
    And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
    And I search a course like "Algorithms, Part II"
    When I wish to enroll in the course "Algorithms, Part II"
    Then go to the course enrolled "Algorithms, Part II".
    #And the user receive the e-mail of course.

  Scenario: Unenroll for a course
    Given I navigate to Main Page
    And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
    And I search a course like "Algorithms, Part II"
    And I wish to enroll in the course "Algorithms, Part II"
    And go to the course enrolled "Algorithms, Part II".
    When I navigate to Home Page
    And I selected the course to unenroll "Algorithms, Part II"
    Then the registered course "Algorithms, Part II" should not be present.

  Scenario: View information about Course enroll.
    Given I navigate to Main Page
    And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
    And I search a course like "Algorithms, Part II"
    And I wish to enroll in the course "Algorithms, Part II"
    And I navigate to Home Page
    When I selected the course to unenroll "Algorithms, Part II"
    Then I see the view information about the course.

  @SmokeTest
  Scenario: Search any course when a user logout.
    Given I want to close session
    And I should logout successfully.
    When I navigate to Main Page
    And I search a course as "JavaScript"
    Then obtain a "JavaScript" list course.