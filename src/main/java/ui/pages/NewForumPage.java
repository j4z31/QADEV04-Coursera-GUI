/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/29/15
 * Time: 17:30 PM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class NewForumPage extends BasePageObject {
    @FindBy(id = "course-forum-thread-new-title-input")
    private WebElement txtNewTitle;

    @FindBy(xpath = "//iframe[contains(@class, 'wysihtml5-sandbox')]")
    private WebElement iframePost;

    @FindBy(xpath = "//input[contains(@name, 'anonymous')]")
    private WebElement cbxPostAnonymous;

    @FindBy(xpath = "(//button[@type='submit'])[6]")
    private WebElement btnCreateNewPost;

    public NewForumPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public NewForumPage setNewPost(String newTitle, String newContent) {
        setTxtNewTitle(newTitle);
        setTxtNewContent(newContent);
        return this;
    }

    public NewForumPage clickPostAnonymousCheckBox() {
        cbxPostAnonymous.click();
        return this;
    }

    public ForumEditPage clickCreateNewPostButton() {
        btnCreateNewPost.click();
        return new ForumEditPage();
    }

    private void setTxtNewTitle(String newTitle) {
        txtNewTitle.sendKeys(newTitle);
    }

    private void setTxtNewContent(String content) {
        driver.switchTo().frame(iframePost);
        WebElement txtContent = driver.findElement
                (By.xpath("//body[contains(@class, 'coursera-wysihtml5-rich-editor ')]"));
        txtContent.sendKeys(content);
        driver.switchTo().defaultContent();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(btnCreateNewPost));
    }
}
