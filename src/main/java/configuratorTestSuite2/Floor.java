
package configuratorTestSuite2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Floor extends Base {
    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    /* Finds correct Elements */

    @FindBy(xpath = "//li[@data-target='buildingplanning/floors']")
    private WebElement floorIcon;

    @FindBy(xpath = "//div[@class='itemDescription']")
    WebElement newEG;

    @FindBy(xpath = "//div[@class='spinner input double left']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerFloorHeightUpButton;

    @FindBy(xpath = "//span[@class='button quad centerleft yellow']")
    private WebElement copy;

    @FindBy(xpath = "//span[@class='button quad centerright yellow']")
    private WebElement abort;

    @FindBy(xpath = "//span[@class='button quad right green']")
    private WebElement save;

    @FindBy(xpath = "(//input[@name='floorHeight'])[1]")
    private WebElement inputFieldSpinnerFloorHeightEG;

    @FindBy(xpath = "//span[@class='description wide' and contains(text(),'1. OG')]")
    private WebElement firstOG;

    @FindBy(xpath = "//div[@class='listItem active']//*[@class='button quad left red deletebtn']")
    private WebElement firstOGDelete;

    @FindBy(xpath = "//div[@class='listItem active']//*[@name='floorHeight']")
    private WebElement inpuFiedSpinnerFloorHeightFirstOG;

    @FindBy(id = "popup-button-ok")
    private WebElement confirmDelete;

    private final By countOfFloors = By.className("listItem");

    private final By activeFloor = By.xpath("//div[@class='listItem active']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public Floor(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on floor icon
     */
    public void clickOnFloorIcon() {
        click(floorIcon, 20);
    }

    /**
     * Clicks on EG
     */
    public void clickOnCreatedEG() {
        click(newEG, 20);
    }

    /**
     * Clicks on spinner up button
     */
    public void clickOnSpinnerFloorHeightUpButton() {
        spinner(spinnerFloorHeightUpButton, 4, 20);
    }

    /**
     * Clicks on abort
     */
    public void clickOnAbort() {
        click(abort, 20);
    }

    /**
     * Clicks on copy
     */
    public void clickOnCopy() {
        click(copy, 20);
    }

    /**
     * Clicks on save
     */
    public void clickOnSave() {
        click(save, 20);
    }

    /**
     * Clicks on first OG
     */
    public void clickOnFirstOG() {
        click(firstOG, 20);
    }

    public void clickOnDeleteFirstOG() {
        click(firstOGDelete, 20);
    }

    /**
     * Confirms delete
     */
    public void clickOnConfrimDelete() {
        click(confirmDelete, 20);
    }

    /**
     * Gets value from spinner
     *
     * @return floor height
     */
    public String getValueFromSpinnerFloorHeightEG() {
        return getValueFromInputField(inputFieldSpinnerFloorHeightEG);
    }

    /**
     * Gets value from spinner
     *
     * @return floor height
     */
    public String getValueFromSpinnerFloorHeightFirstOG() {
        return getValueFromInputField(inpuFiedSpinnerFloorHeightFirstOG);
    }

    /**
     * Gets count of floors
     *
     * @return count of floors
     */
    public int getCountOfFloorBeforeDeleting() {
        final Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(4));
        return wait.until(driver -> driver.findElements(countOfFloors)).size();
    }

    /**
     * Gets count of floors after deleting
     *
     * @return count of floors
     */
    public int getCountOfFloorAfterDeleting() {
        final Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(4));
        final WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(activeFloor));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(webElement)));
        return wait.until(driver -> driver.findElements(countOfFloors)).size();
    }

}
