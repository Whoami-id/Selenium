
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
    WebDriver driver;

    // finds the correct element
    @FindBy(xpath = "//span[text()='Konfigurator starten']")
    WebElement startConfiguration;

    /**
     * Constructor from Homepage Class
     *
     * @param driver which starts ChromeDriver
     */
    public Homepage(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * clicks on Button to go to loginpage
     */
    public void clickConfigurationButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(startConfiguration)).click();

    }
}
