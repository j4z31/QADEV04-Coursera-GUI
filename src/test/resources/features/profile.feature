@EditProfile
Feature: Edit Profile
  A test that verify a user can edit your profile.

  Background:
    Given I navigate to Main Page
    And I login like "Jhasmany.Quiroz@fundacion-jala.org" with password "1c7hu57&7"
    And I navigate to Profile Page

  Scenario: Edit my profile of my account: Privacy and Gender.
    When I modified the privacy of my account with "The Coursera community."
    And I modified my gender with "Male"
    Then I view my profile updated.

  Scenario: See the Course Certificate Account
    When I navigate to Certificate Settings
    Then I do not have any certificate

  Scenario: Edit my profile of my account: Birthday and About Me.
    When I modified my birthday with the date "January", "18" of "1990"
    And I tell you something about my "Hi my name is Jhasmany, I like all the related to web development and mobile."
    Then I view my profile updated.