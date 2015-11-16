/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/12/15
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class CoursesPage extends BasePageObject {
    @FindBy(xpath = "//span[contains(@data-reactid,'.0.1.0.1.1.2.0.0')]")
    private WebElement courseSearched;

    @FindBy(xpath = "//p[contains(@data-reactid, '.0.1.0.1.1.2.0.0')]")
    private WebElement messageCourseNotFound;

    public CoursesPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public boolean coursesFinds(String nameCourse) {
        return (courseSearched.getText().equalsIgnoreCase("You searched for "+nameCourse+"."));
    }

    public boolean notCourseFind(String course) {
        return (messageCourseNotFound.getText().equalsIgnoreCase("No Results found"));
    }

    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOf());
    }
}

