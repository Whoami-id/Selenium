
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Photovoltaic extends Base {

    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    /* Finds correct Elements */
    @FindBy(xpath = "//li[@data-target='buildingplanning/photovoltaic']")
    private WebElement photovoltaicIcon;

    @FindBy(id = "pv-plant-type")
    private WebElement pvPlantType;

    @FindBy(id = "popup-button-ok")
    private WebElement confirm;

    @FindBy(id = "add-pv-module")
    private WebElement addPvModule;

    @FindBy(xpath = "//div[@class='itemDescription']")
    private WebElement newPv;

    @FindBy(id = "module-type")
    private WebElement moduleType;

    @FindBy(id = "manufacturer-type")
    private WebElement manufacturerType;

    @FindBy(xpath = "//div[@class='spinner input double left']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerCountUpButton;

    @FindBy(id = "model-type")
    private WebElement modelType;

    @FindBy(id = "effective-power")
    private WebElement effectivePower;

    @FindBy(id = "spinner-number-of-modules")
    private WebElement inputFieldSpinnerNumberOfModules;

    @FindBy(xpath = "//span[@class='button triple left red']")
    private WebElement delete;

    @FindBy(xpath = "//span[@class='button triple center yellow']")
    private WebElement abort;

    @FindBy(xpath = "//span[@class='button triple right green']")
    private WebElement save;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public Photovoltaic(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on icon
     */
    public void clickOnPhotovoltaicIcon() {
        click(photovoltaicIcon, 20);
    }

    /**
     * Selects pv plant type
     */
    public void selectPvPlantType() {
        select(pvPlantType, 20, propertyFile.getPvPlantType());
    }

    /**
     * Clicks to confirm
     */
    public void clickOnConfrim() {
        click(confirm, 20);
    }

    /**
     * Clicks on add new pv
     */
    public void clickOnAddNewPv() {
        click(addPvModule, 20);
    }

    /**
     * Clicks on new pv
     */
    public void clickOnNewPv() {
        click(newPv, 20);
    }

    /**
     * Selects pv module
     */
    public void selectPvMudole() {
        select(moduleType, 20, propertyFile.getPvModuleType());
    }

    /**
     * Selects pv manufacturer
     */
    public void selectPvManufacturer() {
        select(manufacturerType, 20, propertyFile.getPvManufacturer());
    }

    /**
     * Click on spinner
     */
    public void clickOnSpinnerPvCount() {
        spinner(spinnerCountUpButton, 5, 20);
    }

    /**
     * Selects pv model
     */
    public void selectPvModel() {
        select(modelType, 20, propertyFile.getPvModel());
    }

    /**
     * Clicks on save
     */
    public void clickOnSave() {
        click(save, 20);
    }

    /**
     * Clicks on abort
     */
    public void clickOnAbort() {
        click(abort, 20);
    }

    /**
     * Gets value
     *
     * @return value
     */
    public String getValueFromSelectPvPlantType() {
        return getValueFromDropDownMenu(pvPlantType);
    }

    /**
     * Gets value
     *
     * @return value
     */
    public String getValueFromSelectPvModuleType() {
        return getValueFromDropDownMenu(moduleType);
    }

    /**
     * Gets value
     *
     * @return value
     */
    public String getValueFromSelectManufacturer() {
        return getValueFromDropDownMenu(manufacturerType);
    }

    /**
     * Gets value
     *
     * @return value
     */
    public String getValueFromSpinnerCount() {
        return getValueFromInputField(inputFieldSpinnerNumberOfModules);
    }

    /**
     * Gets value
     *
     * @return value
     */
    public String getValueFromSelectPvModel() {
        return getValueFromDropDownMenu(modelType);
    }

    /**
     * Gets value
     *
     * @return value
     */
    public String getValueFromPvPower() {
        return getValueFromInputField(effectivePower);
    }

    /**
     * Planing pv and abort
     */
    public void planingPvAndAbort() {
        selectPvMudole();
        selectPvManufacturer();
        selectPvModel();
        clickOnSpinnerPvCount();
        clickOnAbort();
    }

    /**
     * Planing pv and save
     */
    public void planingPvAndSave() {
        selectPvMudole();
        selectPvManufacturer();
        selectPvModel();
        clickOnSpinnerPvCount();
        clickOnSave();
    }

}
