/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/28/15
 * Time: 17:30 PM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class ForumPage extends BasePageObject {
    @FindBy(linkText = "Last updated")
    private WebElement lnkLastUpdated;

    @FindBy(xpath = "//span[contains(text(), 'Welcome to Algorithms, Part II')]")
    private WebElement lnkWelcomeCourse;

    @FindBy(xpath = "//a[contains(@class, 'course-forum-thread-showmore btn')]")
    private WebElement btnShowMore;

    @FindBy(xpath = "//a[contains(@class, 'course-forum-threads-new-button')]")
    private WebElement btnNewPost;

    public ForumPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public ForumEditPage clickWelcomeCourseLink(String topicForum) {
        btnShowMore.click();
        lnkWelcomeCourse.click();
        return new ForumEditPage();
    }

    public NewForumPage clickNewPostButton() {
        btnNewPost.click();
        return new NewForumPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(lnkLastUpdated));
    }
}