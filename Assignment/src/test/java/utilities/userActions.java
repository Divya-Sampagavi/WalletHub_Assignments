package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import testRunner.testRunner;

public class userActions {
    Actions action = new Actions(testRunner.driver);

    // Method to click on any webelement
    public void clickElement(final WebElement element) {
        element.click();
    }

    // Method to enter value in the text fields
    public void sendKeysElement(final WebElement element, final String str) {
        element.sendKeys(str);
    }

    // Method to hover on any webelement
    public void hoverElement(final WebElement element) {
        action.moveToElement(element).perform();
    }

    // Method to check whether the webelement is present or no
    public boolean isPresent(final WebElement element) {
        return element.isDisplayed();
    }

    // Method to decode the password
    public String decodestr(final String encodedstr) {
        byte[] decodedstr = Base64.decodeBase64(encodedstr);
        return new String(decodedstr);
    }

    // Method to capture the screen
    public void captureScreen(final WebDriver driver) {
        File destination = null;
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String dest = System.getProperty("user.dir") + "//Screenshots//" + "screenShot" + System.currentTimeMillis() + ".png";
            destination = new File(dest);
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String filePath = destination.toString();
        String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
        Reporter.log(path);
    }

}
