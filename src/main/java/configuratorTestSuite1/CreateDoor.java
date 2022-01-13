
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateDoor {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    // Finds Correct element
    @FindBy(xpath = "//li[@data-target='template/doors']")
    WebElement doorIcon;

    @FindBy(id = "newDoor")
    WebElement createNewType;

    @FindBy(className = "itemDescription")
    WebElement newType;

    @FindBy(id = "doorname")
    WebElement doorName;

    @FindBy(id = "door-material-type")
    WebElement doorMaterialType;

    @FindBy(id = "door-security-type")
    WebElement doorSecurityType;

    @FindBy(id = "door-opening-type")
    WebElement doorOpeningType;

    @FindBy(id = "door-category-type")
    WebElement doorCategoryType;

    @FindBy(id = "door-control-type")
    WebElement doorControlType;

    @FindBy(id = "door-lock-type")
    WebElement doorLockType;

    @FindBy(id = "door-opening-side-type")
    WebElement doorOpeningSideType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    /**
     * Constructor which creates new door
     *
     * @param driver
     */
    public CreateDoor(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on door icon
     */
    public void clickOnDoorIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(doorIcon))
                .click();
    }

    /**
     * Clicks on Create door type
     */
    public void clickOnCreateDoorType() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(createNewType))
                .click();
    }

    /**
     * Clicks on created door
     */

    public void clickOnCreatedDoor() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(newType))
                .click();
    }

    /**
     * Sets the door name
     */
    private void setDoorName() {
        final WebElement nameOfDoor = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(doorName));
        nameOfDoor.clear();
        nameOfDoor.sendKeys(propertyFile.getDoorName());
    }

    /**
     * Selects the Material type
     */
    private void selectDoorMaterialType() {
        final WebElement materialType = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(doorMaterialType));
        final Select selectMaterialType = new Select(materialType);
        selectMaterialType.selectByVisibleText(propertyFile.getDoorMaterial());
    }

    /**
     * Selects the Door Security Type
     */
    private void selectDoorSecurityType() {
        final WebElement securityType = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(doorSecurityType));
        final Select selectSecurityType = new Select(securityType);
        selectSecurityType.selectByVisibleText(propertyFile.getDoorSecurity());
    }

    /**
     * Selects the Door oppening type
     */
    private void selectDoorOpeningType() {
        final WebElement doorType = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(doorOpeningType));
        final Select doorOpenningType = new Select(doorType);
        doorOpenningType.selectByVisibleText(propertyFile.getDoorType());
    }

    /**
     * Selects the Door category type
     */
    private void selectDoorCategoryType() {
        final WebElement doorCategory = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(doorCategoryType));
        final Select doorCategoryType = new Select(doorCategory);
        doorCategoryType.selectByVisibleText(propertyFile.getDoorCategory());
    }

    /**
     * Selects the Door control type
     */
    private void selectDoorControlType() {
        final WebElement doorControl = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(doorControlType));
        final Select doorControlType = new Select(doorControl);
        doorControlType.selectByVisibleText(propertyFile.getDoorControlType());
    }

    /**
     * Selects the Door look type
     */
    private void selectDoorLookType() {
        final WebElement doorLook = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(doorLockType));
        final Select doorLookType = new Select(doorLook);
        doorLookType.selectByVisibleText(propertyFile.getDoorLockType());
    }

    /**
     * Selects the Door side opening type
     */
    private void selectDoorOpeningSideType() {
        final WebElement doorOpeningSide = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(doorOpeningSideType));
        final Select doorOpeningSideType = new Select(doorOpeningSide);
        doorOpeningSideType.selectByVisibleText(propertyFile.getDoorOpeningSideType());
    }

    /**
     * Clicks on Save Button
     */
    public void clickOnSaveChanges() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(save)).click();
    }

    /**
     * Clicks on Delete Button
     */
    public void clickOnDelete() {
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(delete))
                .click();
    }

    /**
     * Clicks on Abort Button
     */
    public void clickOnAbortChanges() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(abortChanges))
                .click();
    }

    /**
     * Gets value from door Name
     *
     * @return doorName
     */
    public String getValueFromInputFieldDoorName() {
        return doorName.getAttribute("value");
    }

    /**
     * Gets value form DoorMaterial
     *
     * @return doorMaterial
     */
    public String getValueFromSelectDoorMaterialType() {
        final WebElement doorMaterial = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(doorMaterialType));
        return new Select(doorMaterial).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value from door security type
     *
     * @return doorSecurityType
     */
    public String getValueFromSelecteDoorSecurityType() {
        final WebElement doorSecurity = new WebDriverWait(driver, Duration.ofSeconds(200))
                .until(ExpectedConditions.visibilityOf(doorSecurityType));
        return new Select(doorSecurity).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value form Door opening type
     *
     * @return doorOpeningType
     */
    public String getValueFromSelectDoorOpeningType() {
        final WebElement doorOpening = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(doorOpeningType));
        return new Select(doorOpening).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value from door category
     *
     * @return doorCategory
     */
    public String getValueFormSelectDoorCatergory() {
        final WebElement doorCategory = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(doorCategoryType));
        return new Select(doorCategory).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value from Door control type
     *
     * @return doorControlType
     */
    public String getValueFromSelectDoorControlType() {
        final WebElement doorControl = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.elementToBeClickable(doorControlType));
        return new Select(doorControl).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value from door look type
     *
     * @return doorLookType
     */
    public String getValueFromSelectDoorLookType() {
        final WebElement doorLock = new WebDriverWait(driver, Duration.ofSeconds(70))
                .until(ExpectedConditions.elementToBeClickable(doorLockType));
        return new Select(doorLock).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets valeu from door opening side type
     *
     * @return doorOpeningSideType
     */
    public String getValueFromSelectDoorOpeningSideType() {
        final WebElement doorOpeningSide = new WebDriverWait(driver, Duration.ofSeconds(70))
                .until(ExpectedConditions.elementToBeClickable(doorOpeningSideType));
        return new Select(doorOpeningSide).getFirstSelectedOption().getText().trim();

    }

    /**
     * Creates Door and abort
     */
    public void createDoorAndAbort() {
        setDoorName();
        selectDoorMaterialType();
        selectDoorSecurityType();
        selectDoorOpeningType();
        selectDoorCategoryType();
        selectDoorControlType();
        selectDoorLookType();
        selectDoorOpeningSideType();
        clickOnAbortChanges();

    }

    /**
     * Creates Door and save
     */
    public void createDoorAndSave() {
        setDoorName();
        selectDoorMaterialType();
        selectDoorSecurityType();
        selectDoorOpeningType();
        selectDoorCategoryType();
        selectDoorControlType();
        selectDoorLookType();
        selectDoorOpeningSideType();
        clickOnSaveChanges();
    }
}
