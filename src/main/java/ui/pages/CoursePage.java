/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/17/15
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class CoursePage extends BasePageObject {
    @FindBy(xpath = "//a[contains(@class, 'course-topbanner-name')]")
    private WebElement courseName;

    //@FindBy(xpath = "//a[contains(@data-ab-user-convert, 'navclick_Discussion_Forums')]")
    @FindBy(partialLinkText = "Forums")
    private WebElement lnkDiscussionForum;

    public CoursePage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public boolean isCourseNamePresent(String nameCourse) {
        return courseName.getText().equalsIgnoreCase(nameCourse);
    }

    public DiscussionForumPage clickDiscussionForumLink() {
        lnkDiscussionForum.click();
        return new DiscussionForumPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(courseName));
    }
}