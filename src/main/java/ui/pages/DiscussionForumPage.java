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
import ui.BasePageObject;

public class DiscussionForumPage extends BasePageObject {
    @FindBy(linkText = "General Discussion")
    private WebElement lnkGeneralDiscussion;

    public ForumPage clickGeneralLink() {
        lnkGeneralDiscussion.click();
        return new ForumPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
