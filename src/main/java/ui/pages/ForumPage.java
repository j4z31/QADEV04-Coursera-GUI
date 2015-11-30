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
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class ForumPage extends BasePageObject {
    @FindBy(linkText = "Last updated")
    private WebElement lnkLastUpdated;

    @FindBy(linkText = "Welcome to Algorithms, Part II")
    private WebElement lnkWelcomeCourse;

    public ForumEditPage clickWelcomeCourseLink() {
        lnkWelcomeCourse.click();
        return new ForumEditPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(lnkLastUpdated));
    }
}