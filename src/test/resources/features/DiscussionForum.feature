@DiscussionsForum
Feature: Discussions Forum
  A test that verify a user can write your doubts.

  Background:
    Given I navigate to Main Page
      And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
      And I search a course like "Algorithms, Part II"
      And I wish to enroll in the course "Algorithms, Part II"
      And go to the course enrolled "Algorithms, Part II".
    When I navigate to Discussions Page

  Scenario: Presented in the course forum.
      And I search "Welcome to Algorithms, Part II"
    Then I post my presentation in the course "Hi my name is Jhasmany, I am from Cochabamba - Bolivia.".

  Scenario: Post a question in the discussion forum.
      And I create a new publication.
    Then the new publication should be in the list of Course Discussions.

  Scenario: Response a question in the list of Discussions.
      And I create a new publication
      And I navigate to the new publication.
    Then I write a comment in the publication.