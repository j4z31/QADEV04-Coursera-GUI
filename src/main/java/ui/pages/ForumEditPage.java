/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/28/15
 * Time: 20:30 PM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

import java.util.concurrent.TimeUnit;

public class ForumEditPage extends BasePageObject {
    @FindBy(className = "course-forum-bottom-scroll-indicator")
    private WebElement scrollIndicator;

    @FindBy(xpath = "//iframe[contains(@class, 'wysihtml5-sandbox')]")
    private WebElement iframePost;

    @FindBy(xpath = "//input[contains(@name, 'anonymous')]")
    private WebElement cbxPostAnonymous;

    @FindBy(xpath = "//button[contains(@class, 'course-forum-post-edit-save')]")
    private WebElement btnAddPost;

    @FindBy(xpath = "//div[contains(@class, 'course-forum-thread-title')]")
    private WebElement forumTitle;

    public ForumEditPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public ForumEditPage clickScrollIndicator() {
        scrollIndicator.click();
        scrollIndicator.click();
        return this;
    }

    public ForumEditPage clickPostAnonymousCheckBox() {
        cbxPostAnonymous.click();
        return this;
    }

    public ForumEditPage setNewPresentation(String presentation) {
        driver.switchTo().frame(iframePost);
        WebElement txtPost = driver.findElement
                (By.xpath("//body[contains(@class, 'coursera-wysihtml5-rich-editor ')]"));
        txtPost.sendKeys(presentation);

        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        cbxPostAnonymous.click();
        btnAddPost.click();

        return this;
    }

    public boolean isForumTitlePresent(String title) {
        return forumTitle.getText().equalsIgnoreCase(title);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(scrollIndicator));
    }
}
