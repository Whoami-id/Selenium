
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    // Finds the correct element
    @FindBy(id = "user")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "doLogin")
    WebElement loingButton;

    @FindBy(xpath = "//span[text()='Login fehlgeschlagen']")
    WebElement failedMessage;

    /**
     * Constructor form Login Class
     *
     * @param driver which starts ChromeDriver
     */
    public Login(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Writes Email in input field
     */
    public void setEmail() {
        final WebElement elementEmail = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(email));
        elementEmail.sendKeys(propertyFile.getEmail());
    }

    /**
     * Writes Password in input field
     */
    public void setPassword() {
        final WebElement elementPassword = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(password));
        elementPassword.sendKeys(propertyFile.getPassword());
    }

    /**
     * Clicks on login Button
     */
    public void clickLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(loingButton))
                .click();
    }

    /**
     * logs in with your data
     */
    public void loginWithYourAccount() {
        setEmail();
        setPassword();
        clickLogin();
    }

    /**
     * Gets entered Email form input field
     *
     * @return Email
     */
    public String getEnteredEmail() {
        return email.getAttribute("value");
    }

    /**
     * Gets entered Password form input field
     *
     * @return Password
     */
    public String getEnteredPassword() {
        return password.getAttribute("value");
    }

    /**
     * Gets message if login failed
     *
     * @return massage
     */
    public String getTextFromLoginFailed() {
        return failedMessage.getText();
    }

    /**
     * Check if login failed
     */
    public void checkIfLoginFailed() {
        if (getTextFromLoginFailed().equals("Login fehlgeschlagen")) {
            Assert.assertTrue(false);
        }
        Assert.assertFalse(getTextFromLoginFailed().equals("Login fehlgeschlagen"));

    }
}
