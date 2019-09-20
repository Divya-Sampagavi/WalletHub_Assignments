package utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObjects {

	WebDriver driver;

	@FindBy(xpath = locators.BUTTON_WRITEAREVIEW_XPATH)
	public WebElement writeAReviewButton;

	@FindBy(css = locators.REVIEWSTARTS_CSS)
	public List<WebElement> reviewStars;

	@FindBy(css = locators.HIGHLIGHTEDSTARS_CSS)
	public List<WebElement> highlightedStars;

	@FindBy(css = locators.LINK_LOGIN_CSS)
	public WebElement lnk_login;

	@FindBy(xpath = locators.TXT_USERNAME_XPATH)
	public WebElement txt_userName;

	@FindBy(xpath = locators.TXT_PASSWORD_XPATH)
	public WebElement txt_password;

	@FindBy(css = locators.BUTTON_LOGIN_CSS)
	public WebElement btn_Login;

	@FindBy(className = locators.DROPDOWN_COMPANY_CLASSNAME)
	public WebElement dropdown_Company;

	@FindBy(css = locators.LIST_DROPDOWN_CSS)
	public List<WebElement> lst_dropdownValues;

	@FindBy(xpath = locators.TEXT_COMMENTS_XPATH)
	public WebElement txt_Comments;

	@FindBy(xpath = locators.BUTTON_SUBMIT_XPATH)
	public WebElement btn_Submit;

	@FindBy(xpath = locators.BUTTON_CONTINUE_XPATH)
	public WebElement btn_Continue;

	@FindBy(xpath = locators.BUTTON_EDITPROFILE_XPATH)
	public WebElement btn_EditProfile;

	@FindBy(css = locators.TXT_FBEMAILID_CSS)
	public WebElement txt_fbEmailID;

	@FindBy(css = locators.TXT_FBPWD_CSS)
	public WebElement txt_fbPWD;

	@FindBy(css = locators.BUTTON_FB_LOGIN_CSS)
	public WebElement btn_fbLogin;

	@FindBy(xpath = locators.TXT_MESSAGE_XPATH)
	public WebElement txt_fbMessage;

	@FindBy(xpath = locators.TXT_CREATEPOST_XPATH)
	public WebElement txt_createPost;

	@FindBy(css = locators.BUTTON_FBPOST)
	public WebElement btn_Post;

	@FindBy(xpath = locators.STATUS_MESSAGE_XPATH)
	public WebElement statusMessage;

	@FindBy(xpath = locators.FB_LOGOUT_XPATH)
	public WebElement fb_logoutMenu;

	@FindBy(css = locators.FB_LOGOUTOPTION_CSS)
	public WebElement fb_logoutOption;

	public pageObjects(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
