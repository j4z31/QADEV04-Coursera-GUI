@SearchCourse
Feature: Search any course
  Search any course that successfully and unsuccessfully

  Background:
    Given I navigate to Main Page
    And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"

  @SmokeTest
  Scenario: Search any course when a user logout.
    Given I want to close session
      And I should logout successfully.
    When I navigate to Main Page
      And I search a course as "JavaScript"
    Then obtain a "JavaScript" list course.

  @SmokeTest
  Scenario: Search any course when a user login.
    When I search a course like "JavaScript"
    Then obtain a "JavaScript" list course.

  @SmokeTest
  Scenario: Search any course but that don't is present in the list.
    When I search a course like "Qwerty"
    Then do not obtain "Qwerty" none course.

  Scenario: Enroll for a course.
    And I search a course like "Algorithms, Part II"
    When I wish to enroll in the course "Algorithms, Part II"
    Then go to the course enrolled.
    #And the user receive the e-mail of course.

  Scenario: Unenroll for a course
      And I search a course like "Algorithms, Part II"
      And I wish to enroll in the course "Algorithms, Part II"
      And go to the course enrolled.
    When I navigate to Home Page
      And I selected the course to unenroll "Algorithms, Part II"
    Then the registered course "Algorithms, Part II" should not be present.

  Scenario: View information about Course enroll.
    And I search a course like "Algorithms, Part II"
    And I wish to enroll in the course "Algorithms, Part II"
    And I navigate to Home Page
    When I selected the course to unenroll "Algorithms, Part II"
    Then I see the view information about the course.

  Scenario: Presented in the course forum.
      And I search a course like "Algorithms, Part II"
      And I wish to enroll in the course "Algorithms, Part II"
      And go to the course enrolled.
    When I navigate to Discussions Page
      And I search the words "Please introduce yourself here"
    Then I post my presentation in the course.

  Scenario: Post a question in the discussion forum.
      And I search a course like "Algorithms, Part II"
      And I wish to enroll in the course "Algorithms, Part II"
      And go to the course enrolled.
    When I navigate to Discussions Page
      And I create a new publication
    Then the new publication should be in the list of Course Discussions.

    Scenario: Response a question in the list of Discussions.
        And I search a course like "Algorithms, Part II"
        And I wish to enroll in the course "Algorithms, Part II"
        And go to the course enrolled.
      When I navigate to Discussions Page
        And I create a new publication
        And I navigate to the new publication
      Then I write a comment in the publication.