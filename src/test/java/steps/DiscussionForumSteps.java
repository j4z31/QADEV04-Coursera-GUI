/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/28/15
 * Time: 17:35 PM
 * To change this template use File | Settings | File Templates.
 */
package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.pages.*;

import static org.testng.Assert.assertTrue;

public class DiscussionForumSteps {
    private CoursePage coursePage;
    private DiscussionForumPage discussionForumPage;
    private ForumPage forumPage;
    private ForumEditPage forumEditPage;
    private NewForumPage newForumPage;

    @When("^I navigate to Discussions Page$")
    public void iNavigateToDiscussionsPage() {
        coursePage = new CoursePage();
        discussionForumPage = coursePage
                            .clickDiscussionForumLink();
        forumPage = discussionForumPage
                    .clickGeneralLink();
    }

    @And("^I search \"(.*?)\"$")
    public void iSearch(String introduceYourself) {
        forumEditPage = forumPage
                        .clickWelcomeCourseLink(introduceYourself);
    }

    @Then("^I post my presentation in the course \"(.*?)\".$")
    public void iPostMyPresentationInTheCourse(String presentation) {
        forumEditPage = forumEditPage
                        .clickScrollIndicator()
                        .setNewPresentation(presentation)
                        ;
    }

    @And("^I create a new publication with \"(.*?)\" and \"(.*?)\".$")
    public void iCreateANewPublicationWithAnd(String title, String content) {
        forumEditPage = forumPage
                        .clickNewPostButton()
                        .setNewPost(title, content)
                        .clickPostAnonymousCheckBox()
                        .clickCreateNewPostButton()
                        ;
    }

    @Then("^the new publication should be in the list of Course Discussions with \"(.*?)\" and \"(.*?)\".$")
    public void theNewPublicationShouldBeInTheListOfCourseDiscussionsWithAnd(String title, String content) {
        assertTrue(forumEditPage.isForumTitlePresent(title), "Title Forum is Displayed.");
    }
}