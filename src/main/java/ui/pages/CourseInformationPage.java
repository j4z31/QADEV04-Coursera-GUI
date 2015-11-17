package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by SUDO on 17/11/2015.
 */
public class CourseInformationPage extends BasePageObject {
    @FindBy(xpath = "//a/button")
    private WebElement enrollButton;

    @FindBy(xpath = "//a/button")
    private WebElement goToCourseButton;

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

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(enrollButton));
    }
}