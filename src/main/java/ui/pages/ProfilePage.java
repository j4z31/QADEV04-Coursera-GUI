/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/28/15
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
package ui.pages;

import common.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ui.BasePageObject;

import java.util.concurrent.TimeUnit;

public class ProfilePage extends BasePageObject {
    @FindBy(name = "privacy")
    private WebElement privacy;
    Select drpPrivacy;

    @FindBy(xpath = "//button[contains(@data-success-message, 'Saved!')]")
    private WebElement btnSaveProfile;

    @FindBy(xpath = "//div[contains(@class, 'coursera-profile-editor-gender control-group')]")
    private WebElement profileGender;

    @FindBy(name = "birthday_month")
    private WebElement drpMonth;

    @FindBy(name = "birthday_day")
    private WebElement drpDay;

    @FindBy(name = "birthday_year")
    private WebElement drpYear;

    @FindBy(name = "bio")
    private WebElement txtBio;

    @FindBy(className = "image-selector-image")
    private WebElement imgPhoto;

    public ProfilePage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public ProfilePage setPrivacyAccount(String privacyAccount) {
        initializeDropDown(privacy, privacyAccount);
        return this;
    }

    public ProfilePage setGender(String gender) {
        String byElement = "//label[contains(@class, 'radio inline') and contains(text(), '"+gender+"')]";
        if (CommonMethods.isElementPresent(By.xpath(byElement))){
            profileGender.findElement(By.xpath(byElement)).click();
            return this;
        }
        return new ProfilePage();
    }

    public boolean isProfileSaved() {
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return btnSaveProfile.getText().equalsIgnoreCase("Saved!")
                || btnSaveProfile.getText().equalsIgnoreCase("Saving...")
                || btnSaveProfile.getText().equalsIgnoreCase("Save Changes");
    }

    public ProfilePage setBirthday(String month, String day, String year) {
        setMonth(month);
        setDay(day);
        setYear(year);
        return this;
    }

    public ProfilePage setAboutMe(String aboutMe) {
        txtBio.sendKeys(aboutMe);
        return this;
    }

    private void setMonth(String month) {
        initializeDropDown(drpMonth, month);
    }

    private void setDay(String day) {
        initializeDropDown(drpDay, day);
    }

    private void setYear(String year) {
        initializeDropDown(drpYear, year);
    }

    private void initializeDropDown(WebElement dropDown, String value) {
        drpPrivacy = new Select(dropDown);
        drpPrivacy.selectByVisibleText(value);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(imgPhoto));
    }
}
