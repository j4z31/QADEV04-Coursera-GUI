@SearchCourse
Feature: Search any course
  Search any course that successfully and unsuccessfully

  @SmokeTest
  Scenario: Search any course when a user don't login.
    Given I navigate to Main Page
    When I search a course as "JavaScript"
    Then obtain a JavaScript's list course.