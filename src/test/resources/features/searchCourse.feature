@SearchCourse
Feature: Search any course
  Search any course that successfully and unsuccessfully

  @SmokeTest
  Scenario: Search any course when a user don't login.
    Given I navigate to Main Page
    When I search a course as "JavaScript"
    Then obtain a "JavaScript" list course.

  @SmokeTest
  Scenario: Search any course but that don't is present in the list.
    Given I navigate to Main Page
    When I search a course as "Qwerty"
    Then do not obtain "Qwerty" none course.

  Scenario: Enroll for a course.
    Given I navigate to Main Page
    And I login as "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
    And I search a course as "Algorithms: Design and Analysis, Part 1"

    When I wish to enroll in the course
    And Sign the Coursera Honor Code.

    Then I am enrolled in the course
    #And the user receive the e-mail of course.