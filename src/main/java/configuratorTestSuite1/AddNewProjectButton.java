
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewProjectButton {

    WebDriver driver;

    // Finds correct element
    @FindBy(id = "newProject")
    WebElement newProject;

    /**
     * Constructor from AddNewProjctButton Class
     *
     * @param driver
     */
    public AddNewProjectButton(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on AddNewProjectButton
     */
    public void clickOnAddNewProject() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(newProject))
                .click();
    }

}
