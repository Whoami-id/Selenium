
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Base {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds the correct element */
    @FindBy(id = "user")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@id='doLogin']")
    private WebElement loingButton;

    @FindBy(xpath = "//span[text()='Login fehlgeschlagen']")
    private WebElement failedMessage;

    /**
     * Constructor form Login Class
     *
     * @param driver which starts ChromeDriver
     */
    public Login(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Writes Email in input field
     */
    public void setEmail() {
        type(email, 20, propertyFile.getEmail());
    }

    /**
     * Writes Password in input field
     */
    public void setPassword() {
        type(password, 10, propertyFile.getPassword());
    }

    /**
     * Clicks on login Button
     */
    public void clickLogin() {
        click(loingButton, 20);

    }

    /**
     * Gets entered Email form input field
     *
     * @return Email
     */
    public String getEnteredEmail() {
        return getValueFromInputField(email);
    }

    /**
     * Gets entered Password form input field
     *
     * @return Password
     */
    public String getEnteredPassword() {
        return getValueFromInputField(password);
    }

    /**
     * logs in with your data
     *
     * @throws InterruptedException
     *
     */
    public void loginWithYourAccount() {
        setEmail();
        setPassword();
        clickLogin();
    }
}
