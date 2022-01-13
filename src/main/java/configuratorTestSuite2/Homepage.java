
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Base {
    final WebDriver driver;

    /** finds the correct element */
    @FindBy(xpath = "//span[text()='Konfigurator starten']")
    private WebElement startConfiguration;

    /**
     * Constructor the Class
     *
     * @param driver which starts ChromeDriver
     */
    public Homepage(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on configuration button
     *
     * @throws InterruptedException
     */
    public void clickConfigurationButton() {
        click(startConfiguration, 10);
    }
}
