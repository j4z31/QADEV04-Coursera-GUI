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
import ui.pages.CoursePage;
import ui.pages.DiscussionForumPage;
import ui.pages.ForumEditPage;
import ui.pages.ForumPage;

public class DiscussionForumSteps {
    private CoursePage coursePage;
    private DiscussionForumPage discussionForumPage;
    private ForumPage forumPage;
    private ForumEditPage forumEditPage;

    @When("^I navigate to Discussions Page$")
    public void iNavigateToDiscussionsPage() {
        coursePage = new CoursePage();
        discussionForumPage = coursePage.clickDiscussionForumLink();
    }

    @And("^I search \"(.*?)\"$")
    public void iSearch(String introduceYourself) {
        forumPage = discussionForumPage.clickGeneralLink();
        forumEditPage = forumPage.clickWelcomeCourseLink();
    }

    @Then("^I post my presentation in the course \"(.*?)\".$")
    public void iPostMyPresentationInTheCourse(String presentation) {
        forumEditPage = forumEditPage
                .clickScrollIndicator()
                .setNewPresentation(presentation);
    }
}
