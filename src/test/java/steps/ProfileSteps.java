/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/28/15
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */
package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.PageTransporter;
import ui.pages.CertificatePage;
import ui.pages.ProfilePage;

import static org.testng.Assert.assertTrue;

public class ProfileSteps {
    private static PageTransporter pageTransporter = PageTransporter.getInstance();
    private ProfilePage profilePage;
    private CertificatePage certificatePage;

    @And("^I navigate to Profile Page$")
    public void iNavigateToProfilePage() {
        profilePage = pageTransporter.navigateToAccountProfilePage();
    }


    @When("^I modified the privacy of my account with \"(.*?)\"$")
    public void iModifiedThePrivacyOfMyAccount(String privacyAccount) {
        profilePage = profilePage
                        .setPrivacyAccount(privacyAccount);
    }

    @And("^I modified my gender with \"(.*?)\"$")
    public void iModifiedMyGenderWith(String gender) {
        profilePage.setGender(gender);
    }

    @Then("^I view my profile updated.$")
    public void iViewMyProfileUpdated() {
        assertTrue(profilePage.isProfileSaved(), "Profile Updated!!!");
    }


    @When("^I modified my birthday with the date \"(.*?)\", \"(.*?)\" of \"(.*?)\"$")
    public void iModifiedMyBirthdayWithTheDateOf(String month, String day, String year) {
        profilePage = profilePage.setBirthday(month, day, year);
    }

    @And("^I tell you something about my \"(.*?)\"$")
    public void iTellYouSomethingAboutMy(String aboutMe) {
        profilePage = profilePage.setAboutMe(aboutMe);
    }

    @When("^I navigate to Certificate Settings$")
    public void iNavigateToCertificateSettings() {
        certificatePage = pageTransporter.navigateCertificatePage();
    }

    @Then("^I do not have any certificate$")
    public void iDoNotHaveAnyCertificate() {
        assertTrue(certificatePage.notCertificatePresent(), "Don't exists certificates.");
    }
}
