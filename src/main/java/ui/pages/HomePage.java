/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/11/15
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

import java.util.Iterator;
import java.util.List;

public class HomePage extends BasePageObject {
    @FindBy(linkText = "Institutions")
    @CacheLookup
    private WebElement linkText;

    @FindBy(xpath = "(//input[contains(@placeholder, 'Search catalog')])")
    private  WebElement searchInput;

    @FindBy(css = "i.cif-search.c-search-icon")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(@data-popup-bind-open, 'click')]")
    private  WebElement authenticatedDropdownBtn;

    @FindBy(xpath = "//button[contains(@class, 'bt3-btn-link')]")
    private  WebElement signOutBtn;

    @FindBy(xpath = "//div[contains(@class, 'dashboard-has-enrollment')]")
    private WebElement dashboardEnrollment;

    @FindBy(xpath = "//div[contains(@class, 'c-dashboard-membership-info-container')]")
    private WebElement containerInfoCourse;

    @FindBy(xpath = "//em[contains(@class, 'c-phoenix-dropdown-chevron')]")
    private WebElement dropDownListCourse;
    private String courseUnenroll;

    @FindBy(xpath = "//button[contains(@data-js, 'unenroll-confirm')]")
    private WebElement buttonUneneroll;

    public HomePage(){
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public boolean isPartnersDisplayed() {
        return (linkText.getText().equalsIgnoreCase("Institutions"))? true : false;
    }

    public HomePage setSearchCourseInput (String searchCourse) {
        searchInput.clear();
        searchInput.sendKeys(searchCourse);
        return this;
    }

    public CoursesPage clickSearchButton() {
        searchButton.click();
        return new CoursesPage();
    }

    public HomePage clickAuthenticatedDropdownButton() {
        authenticatedDropdownBtn.click();
        return new HomePage();
    }

    public LoginPage clickSignOutButton() {
        signOutBtn.click();
        return new LoginPage();
    }

    public HomePage searchCourse(String nameCourse) {
        dropDownListCourse.click();
        return this;
    }

    public HomePage titleCoursePresent(String nameCourse) {
        courseUnenroll = "//div[contains(@data-js, 'course-nameundefined') and contains(text(), '"+nameCourse+"')]";
        if (isElementPresent(By.xpath(courseUnenroll))) {
            return this;
        }
        return this;
    }

    public HomePage clickDropdownMenuCourse() {
        String element = courseUnenroll+"/ancestor::div[contains(@class, 'c-dashboard-membership-info-container')]//em[contains(@data-js, 'list-toggle')]";
        WebElement unenroll = containerInfoCourse.findElement(By.xpath(element));
        unenroll.click();
        //div[contains(@data-js, 'course-nameundefined') and contains(text(), 'Detección de objetos')]
        // /ancestor::div[contains(@class, 'c-dashboard-membership-info-container')]
        //em[contains(@data-js, 'list-toggle')]
        // /following-sibling::ul//a[contains(@data-js, 'leave-course')]
        element += "/following-sibling::ul//a[contains(@data-js, 'leave-course')]";
        unenroll = containerInfoCourse.findElement(By.xpath(element));
        unenroll.click();
        return this;
    }

    public HomePage clickButtonUnenroll() {
        buttonUneneroll.click();
        return this;
    }

    public boolean isCourseEnroll(String nameCourse) {
        boolean res;
        try {
            courseUnenroll = "//div[contains(@data-js, 'course-nameundefined') and contains(text(), '"+nameCourse+"')]";
            res = true;
        }catch(Exception error){
            res = false;
        }
        return res;
    }

    private boolean isElementPresent(By byElement) {
        try{
            return driver.findElement(byElement)!= null;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(dashboardEnrollment));
    }
}