package ui.pages;

import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;

/**
 * Created by SUDO on 17/11/2015.
 */
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