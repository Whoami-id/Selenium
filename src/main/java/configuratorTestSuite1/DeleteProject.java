
package configuratorTestSuite1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteProject {
    WebDriver driver;

    // Finds correct element
    @FindBy(id = "account")
    WebElement account;

    @FindBy(xpath = "//span[contains(@class,'description wide')and contains(text(),'aleonOffice')]")
    WebElement actuellProject;

    @FindBy(id = "deleteProject")
    WebElement loadProject;

    @FindBy(id = "popup-button-ok")
    WebElement confirmDelete;

    /**
     * Constructor from GoToAccount Class
     */
    public DeleteProject(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks to go to account at the top
     */
    public void goToAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(account))
                .click();
    }

    /**
     * Clicks on current Project
     */
    public void clickOnCurrentProject() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(actuellProject))
                .click();
    }

    /**
     * Clicks on delete Project
     */
    public void clickOnDeleteProject() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(loadProject))
                .click();
    }

    /**
     * Clicks to confirm delete Project
     */
    public void clickOnJaToConfirmDelete() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(confirmDelete))
                .click();
    }

    /**
     * Deletes a Project
     */
    public void deleteCreatedProject() {
        clickOnCurrentProject();
        clickOnDeleteProject();
        clickOnJaToConfirmDelete();
    }

    /**
     * Gets count of projects before deleting
     *
     * @return count of projects
     */
    public int getProjectCount() {
        final Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        final WebElement element = driver.findElement(By.className("listItem"));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
        return wait.until(driver -> driver.findElements(By.className("listItem")).size());
    }

    /**
     * Gets Name of projects
     *
     * @return name of projects
     */
    public List<WebElement> getProjectsName() {
        final Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        return wait.until(driver -> driver.findElements(By.xpath("//span[@class='description wide']")));
    }

}
