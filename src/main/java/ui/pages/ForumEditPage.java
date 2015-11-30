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
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class ForumEditPage extends BasePageObject {
    @FindBy(className = "course-forum-bottom-scroll-indicator")
    private WebElement scrollIndicator;

    @FindBy(xpath = "//iframe[contains(@class, 'wysihtml5-sandbox')]")
    private WebElement iframePost;

    @FindBy(xpath = "//button[contains(@class, 'course-forum-post-edit-save')]")
    private WebElement btnAddPost;

    public ForumEditPage clickScrollIndicator() {
        scrollIndicator.click();
        return this;
    }

    public ForumEditPage setNewPresentation(String presentation) {
        driver.switchTo().frame(iframePost);
        WebElement txtPost = driver.findElement
                (By.xpath("//body[contains(@class, 'coursera-wysihtml5-rich-editor ')]"));
        txtPost.sendKeys(presentation);

        driver.switchTo().defaultContent();
        btnAddPost.click();

        return this;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(scrollIndicator));
    }
}
