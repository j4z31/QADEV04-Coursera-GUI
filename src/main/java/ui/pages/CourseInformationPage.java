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

public class CourseInformationPage extends BasePageObject {
    @FindBy(xpath = "//button[contains(@data-js-action, 'joinForFree')]")
    private WebElement enrollButton;

    @FindBy(xpath = "//a[contains(@class, 'c-spark-cdp-modal-cta')]/button")
    private WebElement goToCourseButton;

    @FindBy(xpath = "//h1[contains(@class, 'display-3-text')]")
    private  WebElement titleCourseEnroll;

    public CourseInformationPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public CourseInformationPage clickEnrollButtonSuccessful() {
        enrollButton.click();
        return this;
    }

    public CoursePage clickGoToCourseSuccessfull() {
        goToCourseButton.click();
        return new CoursePage();
    }

    public boolean isTitleCoursePresent(String titleCourse) {
        return titleCourseEnroll.getText().equalsIgnoreCase(titleCourse);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOf(enrollButton));
    }
}
