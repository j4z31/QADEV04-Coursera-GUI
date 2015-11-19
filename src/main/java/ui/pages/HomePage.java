/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/11/15
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

public class HomePage extends BasePageObject {
    @FindBy(linkText = "Institutions")
    @CacheLookup
    private WebElement linkText;

    @FindBy(xpath = "(//input[@value=''])[2]")
    private  WebElement searchCatalog;

    @FindBy(css = "i.cif-search.c-search-icon")
    private WebElement searchIcon;

    @FindBy(xpath = "//a[contains(@data-popup-bind-open, 'click')]")
    private  WebElement authenticatedDropdownBtn;

    @FindBy(xpath = "//button[contains(@class, 'bt3-btn-link')]")
    private  WebElement signOutBtn;

    @FindBy(xpath = "//div[contains(@class, 'dashboard-has-enrollment')]")
    private WebElement dashboardEnrollment;

    public HomePage(){
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public boolean isPartnersDisplayed() {
        return (linkText.getText().equalsIgnoreCase("Institutions"))? true : false;
    }

    public HomePage setSearchCourseInput (String searchCourse) {
        searchCatalog.clear();
        searchCatalog.sendKeys(searchCourse);
        return this;
    }

    public CoursesPage clickSearchButton() {
        searchIcon.click();
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

    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(dashboardEnrollment));
    }
}