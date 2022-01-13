
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateVentilation extends Base {
    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='template/ventilations']")
    private WebElement ventilationIcon;

    @FindBy(id = "newVentilation")
    private WebElement createNewType;

    @FindBy(xpath = "//div[@class='itemDescription']")
    private WebElement newVentilation;

    @FindBy(id = "ventilationname")
    private WebElement ventilationName;

    @FindBy(id = "usage-type")
    private WebElement usageType;

    @FindBy(id = "system-type")
    private WebElement systemType;

    @FindBy(id = "manufacturer-type")
    private WebElement ventilationManufacturer;

    @FindBy(xpath = "//select[@id='model-type']")
    private WebElement modelType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    /**
     * Constructor the Class
     *
     * @param driver
     */
    public CreateVentilation(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on Ventilation icon
     */
    public void clickOnVentilationIcon() {
        click(ventilationIcon, 20);
    }

    /**
     * Clicks on Create new type
     */
    public void clickOnCreateNewType() {
        click(createNewType, 20);
    }

    /**
     * Clicks on created Ventilation
     */
    public void clickOnCreatedVentilation() {
        click(newVentilation, 20);
    }

    /**
     * Sets Ventilation name
     */
    public void setVentilationName() {
        type(ventilationName, 20, propertyFile.getVentilationName());
    }

    /**
     * Selects Ventilation usage type
     */
    public void selectVentilationUsageType() {
        select(usageType, 20, propertyFile.getVentilationUsage());
    }

    /**
     * Selects Ventilation System
     */
    public void selectVentilationSystem() {
        select(systemType, 20, propertyFile.getVentilationSystem());
    }

    /**
     * Selects Ventilation manufacturer
     */
    public void selectVentilationManufacturer() {
        select(ventilationManufacturer, 20, propertyFile.getVentilationManufacturer());
    }

    /**
     * Selects Ventilation model
     */
    public void selectVentilatoinModel() {
        select(modelType, 20, propertyFile.getVentilationModel());
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
     * Gets Ventilations Name
     *
     * @return VentilationName
     */
    public String getValueFromInputFieldVentilationName() {
        return getValueFromInputField(ventilationName);
    }

    /**
     * Gets Ventilation usage type
     *
     * @return usageType
     */
    public String getValueFromSelectVentilationUsageType() {
        return getValueFromDropDownMenu(usageType);
    }

    /**
     * Gets Ventilation system
     *
     * @return ventilationSystem
     */
    public String getValueFromSelectVentilationSystem() {
        return getValueFromDropDownMenu(systemType);
    }

    /**
     * Gets Ventilation Manufacturer
     *
     * @return ventilation manufacturer
     */
    public String getValueFromSelectVentilationManufacturer() {
        return getValueFromDropDownMenu(ventilationManufacturer);
    }

    /**
     * Gets Ventilation model
     *
     * @return Ventilation model
     */
    public String getValueFromSelectVentilationModel() {
        return getValueFromDropDownMenu(modelType);
    }

    /**
     * Creates Ventilation and abort
     */
    public void createVentilationAndAboirtChanges() {
        setVentilationName();
        selectVentilationUsageType();
        selectVentilationSystem();
        selectVentilationManufacturer();
        selectVentilatoinModel();
        clickOnAbortChanges();
    }

    /**
     * Creates Ventilation and Save
     */
    public void createVentilationAndSaveChanges() {
        setVentilationName();
        selectVentilationUsageType();
        selectVentilationSystem();
        selectVentilationManufacturer();
        selectVentilatoinModel();
        clickOnSaveChanges();
    }

}
