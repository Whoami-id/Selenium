
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HousingUnit extends Base {

    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    /** Finds correct Elements */

    @FindBy(xpath = "//li[@data-target='buildingplanning/housingunit']")
    private WebElement housingUnitIcon;

    @FindBy(id = "newHousingUnit")
    private WebElement createType;

    @FindBy(xpath = "//div[@class='itemDescription']")
    private WebElement newHousingUnit;

    @FindBy(id = "housingunitdescription")
    private WebElement housingUnitDescription;

    @FindBy(xpath = "//div[@class='spinner input double left']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerNetUsingAreaUpButton;

    @FindBy(xpath = "//div[@class='spinner input double right']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerResidentsUpButton;

    @FindBy(xpath = "//input[@class='spinner changeable double left']")
    private WebElement InputFieldSpinnerUsingArea;

    @FindBy(xpath = "//input[@class='spinner changeable double right']")
    private WebElement InputFieldSinnerResidents;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public HousingUnit(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on housing unit icon
     */
    public void clickOnHousingUnitIcon() {
        click(housingUnitIcon, 20);
    }

    /**
     * Clicks on create type
     */
    public void clickOnCreateNewType() {
        click(createType, 20);
    }

    /**
     * Clicks on created type
     */
    public void clickOnCreatedType() {
        click(newHousingUnit, 20);
    }

    /**
     * Sets Housing unit description
     */
    public void setHousingUnitDescription() {
        type(housingUnitDescription, 20, propertyFile.getHousingUnitDescription());
    }

    /**
     * Clicks on spinner housing unit net area
     */
    public void clickOnSpinnerHousingUnitNetUsingAreaUpButton() {
        spinner(spinnerNetUsingAreaUpButton, 10, 20);
    }

    /**
     * Clicks on spinner residents
     */
    public void clickOnSpinnerResidentsUpButton() {
        spinner(spinnerResidentsUpButton, 5, 20);
    }

    /**
     * Clicks on abort button
     */
    public void clickOnAbortButton() {
        click(abort, 20);
    }

    /**
     * Clicks on save button
     */
    public void clickOnSaveButton() {
        click(save, 20);
    }

    /**
     * Get value from input field
     *
     * @return value
     */
    public String getValueFromInputFieldDescription() {
        return getValueFromInputField(housingUnitDescription);
    }

    /**
     * Get value from input field
     *
     * @return value
     */
    public String getValueFromInputFieldSpinnerNetUsingArea() {
        return getValueFromInputField(InputFieldSpinnerUsingArea);
    }

    /**
     * Get value from input field
     *
     * @return value
     */
    public String getValueFromInputFieldSpinnerResidents() {
        return getValueFromInputField(InputFieldSinnerResidents);
    }

    /**
     * Planing housing unit and abort
     */
    public void planingHousingUnitAndAbort() {
        setHousingUnitDescription();
        clickOnSpinnerHousingUnitNetUsingAreaUpButton();
        clickOnSpinnerResidentsUpButton();
        clickOnAbortButton();
    }

    /**
     * Planing housing unit and save
     */
    public void planingHousingUnitAndSave() {
        setHousingUnitDescription();
        clickOnSpinnerHousingUnitNetUsingAreaUpButton();
        clickOnSpinnerResidentsUpButton();
        clickOnSaveButton();
    }
}
