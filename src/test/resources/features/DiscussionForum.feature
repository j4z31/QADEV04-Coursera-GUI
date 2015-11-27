#@DiscussionsForum
#Feature: Discussions Forum
#  A test that verify a user can write your doubts.
#
#  Scenario: Presented in the course forum.
#    Given I navigate to Main Page
#      And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
#      And I search a course like "Algorithms, Part II"
#      And I wish to enroll in the course "Algorithms, Part II"
#      And go to the course enrolled.
#    When I navigate to Discussions Page
#      And I search the words "Please introduce yourself here"
#    Then I post my presentation in the course.
#
#  Scenario: Post a question in the discussion forum.
#    Given I navigate to Main Page
#      And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
#      And I search a course like "Algorithms, Part II"
#      And I wish to enroll in the course "Algorithms, Part II"
#      And go to the course enrolled.
#    When I navigate to Discussions Page
#      And I create a new publication
#    Then the new publication should be in the list of Course Discussions.
#
#  Scenario: Response a question in the list of Discussions.
#    Given I navigate to Main Page
#      And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
#      And I search a course like "Algorithms, Part II"
#      And I wish to enroll in the course "Algorithms, Part II"
#      And go to the course enrolled.
#    When I navigate to Discussions Page
#      And I create a new publication
#      And I navigate to the new publication
#    Then I write a comment in the publication.