package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testRunner.testRunner;
import utilities.pageObjects;
import utilities.userActions;

public class stepDefinition {
    WebDriver     driver   = testRunner.driver;
    pageObjects   homePage = new pageObjects(testRunner.driver);
    userActions   action   = new userActions();
    WebDriverWait wait     = new WebDriverWait(driver, 2000);

    // Assignment #1: Posting message in facebook
    @Given("^Navigate to the facebook url \"([^\"]*)\"$")
    public void navigate_to_the_facebook_url(final String fb_url) throws Throwable {
        driver.get(fb_url);
        action.captureScreen(driver);
    }

    @When("^Enter Credentials of facebook \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enter_Credentials_of_facebook_and(final String fb_emailID, final String fb_pwd) throws Throwable {
        action.sendKeysElement(homePage.txt_fbEmailID, fb_emailID);
        action.sendKeysElement(homePage.txt_fbPWD, action.decodestr(fb_pwd));
        action.captureScreen(driver);
        action.clickElement(homePage.btn_fbLogin);
        wait.until(ExpectedConditions.visibilityOf(homePage.fb_logoutMenu));
        action.captureScreen(driver);
    }

    @Then("^Post the status message Hello World\"([^\"]*)\"$")
    public void post_the_status_message_Hello_World(final String message) throws Throwable {
        action.clickElement(homePage.txt_fbMessage);
        action.sendKeysElement(homePage.txt_createPost, message);
        action.captureScreen(driver);
        action.clickElement(homePage.btn_Post);
        wait.until(ExpectedConditions.visibilityOf(homePage.statusMessage));
        Thread.sleep(1000);
        action.captureScreen(driver);
        Assert.assertEquals(homePage.statusMessage.getText(), message);
        action.clickElement(homePage.fb_logoutMenu);
        action.clickElement(homePage.fb_logoutOption);
        action.captureScreen(driver);
    }

    // Assignment #2: Submitting review for Health Insurance in Wallethub site
    @Given("^Navigate to the \"([^\"]*)\"$")
    public void navigate_to_the_URL(final String login_url) throws Throwable {
        driver.get(login_url);
        action.captureScreen(driver);
    }

    @When("^Enter Credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enter_Credentials(final String emailId, final String password) throws Throwable {
        action.sendKeysElement(homePage.txt_userName, emailId);
        action.sendKeysElement(homePage.txt_password, action.decodestr(password));
        action.captureScreen(driver);
        action.clickElement(homePage.btn_Login);
        action.captureScreen(driver);
        wait.until(ExpectedConditions.visibilityOf(homePage.btn_EditProfile));
    }

    @When("^Navigate to the trust insurance company \"([^\"]*)\"$")
    public void navigate_to_the_trust_insurance_company(final String url) throws Throwable {
        driver.get(url);
        action.captureScreen(driver);
    }

    @When("^Writing a Review with rating and selecting the section \"([^\"]*)\" and entering the comments \"([^\"]*)\"$")
    public void writing_a_Review(final int index, final String comments) throws Throwable {
        action.clickElement(homePage.writeAReviewButton);
        action.hoverElement(homePage.reviewStars.get(3));
        Assert.assertEquals(homePage.highlightedStars.size(), 4);
        action.clickElement(homePage.reviewStars.get(3));
        action.clickElement(homePage.dropdown_Company);
        action.clickElement(homePage.lst_dropdownValues.get(index));
        action.clickElement(homePage.txt_Comments);
        action.sendKeysElement(homePage.txt_Comments, comments);
        action.captureScreen(driver);
        action.clickElement(homePage.btn_Submit);
        wait.until(ExpectedConditions.visibilityOf(homePage.btn_Continue));
        action.captureScreen(driver);
        action.clickElement(homePage.btn_Continue);
        action.captureScreen(driver);
    }

    @Then("^Check the review feed in profile \"([^\"]*)\"$")
    public void check_the_review_feed_in_profile(final String profile_url) throws Throwable {
        driver.get(profile_url);
        action.captureScreen(driver);
    }
}
