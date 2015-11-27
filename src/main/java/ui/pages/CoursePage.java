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
import ui.BasePageObject;

public class CoursePage extends BasePageObject {
    @FindBy(xpath = "//a[contains(@class, 'course-topbanner-name')]")
    private WebElement courseName;

    public CoursePage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public boolean isCourseNamePresent(String nameCourse) {
        return courseName.getText().equalsIgnoreCase(nameCourse);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOf(linkText));
    }
}