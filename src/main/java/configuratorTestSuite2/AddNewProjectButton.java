
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewProjectButton extends Base {

    WebDriver driver;

    // Finds correct element
    @FindBy(id = "newProject")
    private WebElement newProject;

    /**
     * Constructor the Class
     *
     * @param driver
     */
    public AddNewProjectButton(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on AddNewProjectButton
     */
    public void clickOnAddNewProject() {
        click(newProject, 20);
    }

}
