
package configuratorTestSuite2;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.netty.handler.timeout.TimeoutException;

public class DeleteProject extends Base {
    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();
    final String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

    /** Finds correct element */
    @FindBy(id = "account")
    private WebElement account;

    @FindBy(xpath = "//div[@class='listItem active']//*[@id='deleteProject']")
    private WebElement loadProject;

    @FindBy(id = "popup-button-ok")
    private WebElement confirmDelete;

    private final By currentProject = By.xpath("//span[contains(@class,'description wide')and contains(text(),'"
            + propertyFile.getProjectName() + date + "')]");

    private final By countOfProjects = By.className("listItem");

    private final By nameOfProjects = By.xpath("//span[@class='description wide']");

    private final By acitveProject = By.xpath("//div[@class='listItem active']");

    /**
     * Constructor from GoToAccount Class
     */
    public DeleteProject(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks to go to account at the top
     */
    public void goToAccount() {
        click(account, 30);
    }

    /**
     * Clicks on current Project
     */
    public void clickOnCurrentProject() {
        click(currentProject, 30);

    }

    /**
     * Clicks on delete Project
     */
    public void clickOnDeleteProject() {
        click(loadProject, 30);
    }

    /**
     * Clicks to confirm delete Project
     */
    public void clickOnJaToConfirmDelete() {
        click(confirmDelete, 50);
    }

    /**
     * Gets count of projects before deleting
     *
     * @return count of projects
     */
    public int getProjectCountBeforeDeleting() {
        final Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        return wait.until(driver -> driver.findElements(countOfProjects).size());
    }

    /**
     * Gets Name of projects
     *
     * @return name of projects
     */
    public List<WebElement> getProjectsName() {
        final Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(TimeoutException.class);
        return wait.until(driver -> driver.findElements(nameOfProjects));
    }

    /**
     * Gets count of projects after deleting
     *
     * @return count of projects
     */
    public int getProjectCountAfterDeleting() {
        final Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(TimeoutException.class);
        final WebElement element = driver.findElement(acitveProject);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
        return wait.until(driver -> driver.findElements(countOfProjects).size());
    }

    /**
     * Deletes a Project
     */
    public void deleteCreatedProject() {
        clickOnCurrentProject();
        clickOnDeleteProject();
        clickOnJaToConfirmDelete();
    }

}
