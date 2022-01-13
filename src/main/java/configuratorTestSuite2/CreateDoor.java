
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateDoor extends Base {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds Correct element */
    @FindBy(xpath = "//li[@data-target='template/doors']")
    private WebElement doorIcon;

    @FindBy(id = "newDoor")
    private WebElement createNewType;

    @FindBy(className = "itemDescription")
    private WebElement newType;

    @FindBy(id = "doorname")
    private WebElement doorName;

    @FindBy(id = "door-material-type")
    private WebElement doorMaterialType;

    @FindBy(id = "door-security-type")
    private WebElement doorSecurityType;

    @FindBy(id = "door-opening-type")
    private WebElement doorOpeningType;

    @FindBy(id = "door-category-type")
    private WebElement doorCategoryType;

    @FindBy(id = "door-control-type")
    private WebElement doorControlType;

    @FindBy(id = "door-lock-type")
    private WebElement doorLockType;

    @FindBy(id = "door-opening-side-type")
    private WebElement doorOpeningSideType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    @FindBy(xpath = "//div[@class='spinner input double left']//div[@class='spinner-up spinner-button']")
    private WebElement SpinnerWidhtUpButton;

    @FindBy(xpath = "//div[@class='spinner input double right']//div[@class='spinner-up spinner-button']")
    private WebElement SpinnerHeightUpButton;

    @FindBy(xpath = "//input[@id='spinner-door-width']")
    private WebElement InputFieldSpinnerWidth;

    @FindBy(xpath = "//input[@id='spinner-door-height']")
    private WebElement InputFieldSpinnerHeight;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public CreateDoor(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on door icon
     */
    public void clickOnDoorIcon() {
        click(doorIcon, 20);
    }

    /**
     * Clicks on Create door type
     */
    public void clickOnCreateDoorType() {
        click(createNewType, 20);
    }

    /**
     * Clicks on created door
     */

    public void clickOnCreatedDoor() {
        click(newType, 20);
    }

    /**
     * Sets the door name
     */
    public void setDoorName() {
        type(doorName, 20, propertyFile.getDoorName());
    }

    /**
     * Selects the Material type
     */
    public void selectDoorMaterialType() {
        select(doorMaterialType, 20, propertyFile.getDoorMaterial());
    }

    /**
     * Selects the Door Security Type
     */
    public void selectDoorSecurityType() {
        select(doorSecurityType, 20, propertyFile.getDoorSecurity());
    }

    /**
     * Selects the Door opening type
     */
    public void selectDoorOpeningType() {
        select(doorOpeningType, 20, propertyFile.getDoorType());
    }

    /**
     * Selects the Door category type
     */
    public void selectDoorCategoryType() {
        select(doorCategoryType, 20, propertyFile.getDoorCategory());
    }

    /**
     * Selects the Door control type
     */
    public void selectDoorControlType() {
        select(doorControlType, 20, propertyFile.getDoorControlType());
    }

    /**
     * Selects the Door look type
     */
    public void selectDoorLookType() {
        select(doorLockType, 20, propertyFile.getDoorLockType());
    }

    /**
     * Selects the Door side opening type
     */
    public void selectDoorOpeningSideType() {
        select(doorOpeningSideType, 20, propertyFile.getDoorOpeningSideType());
    }

    /**
     * Clicks on Save Button
     */
    public void clickOnSaveChanges() {
        click(save, 20);
    }

    /**
     * Clicks on Abort Button
     */
    public void clickOnAbortChanges() {
        click(abort, 20);
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerWidthUpButton() {
        spinner(SpinnerWidhtUpButton, 4, 20);
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerHeightUpButton() {
        spinner(SpinnerHeightUpButton, 4, 20);
    }

    /**
     * Gets value from door Name
     *
     * @return doorName
     */
    public String getValueFromInputFieldDoorName() {
        return getValueFromInputField(doorName);
    }

    /**
     * Gets value form DoorMaterial
     *
     * @return doorMaterial
     */
    public String getValueFromSelectDoorMaterialType() {
        return getValueFromDropDownMenu(doorMaterialType);
    }

    /**
     * Gets value from door security type
     *
     * @return doorSecurityType
     */
    public String getValueFromSelecteDoorSecurityType() {
        return getValueFromDropDownMenu(doorSecurityType);
    }

    /**
     * Gets value form Door opening type
     *
     * @return doorOpeningType
     */
    public String getValueFromSelectDoorOpeningType() {
        return getValueFromDropDownMenu(doorOpeningType);
    }

    /**
     * Gets value from door category
     *
     * @return doorCategory
     */
    public String getValueFormSelectDoorCatergory() {
        return getValueFromDropDownMenu(doorCategoryType);
    }

    /**
     * Gets value from Door control type
     *
     * @return doorControlType
     */
    public String getValueFromSelectDoorControlType() {
        return getValueFromDropDownMenu(doorControlType);
    }

    /**
     * Gets value from door look type
     *
     * @return doorLookType
     */
    public String getValueFromSelectDoorLookType() {
        return getValueFromDropDownMenu(doorLockType);
    }

    /**
     * Gets value from door opening side type
     *
     * @return doorOpeningSideType
     */
    public String getValueFromSelectDoorOpeningSideType() {
        return getValueFromDropDownMenu(doorOpeningSideType);
    }

    /**
     * Gets value form spinner width
     *
     * @return value
     */
    public String getValueFromSpinnerWidth() {
        return getValueFromInputField(InputFieldSpinnerWidth);
    }

    /**
     * Gets Value from spinner height
     *
     * @return value
     */
    public String getValueFromSpinnerHeight() {
        return getValueFromInputField(InputFieldSpinnerHeight);
    }

    /**
     * Creates Door and abort
     *
     */
    public void createDoorAndAbort() {
        setDoorName();
        selectDoorMaterialType();
        clickOnSpinnerWidthUpButton();
        clickOnSpinnerHeightUpButton();
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
     *
     */
    public void createDoorAndSave() {
        setDoorName();
        selectDoorMaterialType();
        clickOnSpinnerWidthUpButton();
        clickOnSpinnerHeightUpButton();
        selectDoorSecurityType();
        selectDoorOpeningType();
        selectDoorCategoryType();
        selectDoorControlType();
        selectDoorLookType();
        selectDoorOpeningSideType();
        clickOnSaveChanges();
    }

}
