
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateHeater extends Base {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds correct elements */
    @FindBy(xpath = "//li[@data-target='template/heaters']")
    private WebElement heaterIcon;

    @FindBy(id = "newHeater")
    private WebElement newHeaterType;

    @FindBy(xpath = "//div[@class='itemDescription']")
    private WebElement newHeater;

    @FindBy(id = "heatername")
    private WebElement heaterName;

    @FindBy(id = "heater-type")
    private WebElement heaterType;

    @FindBy(xpath = "//select[@id='heaterStyle']")
    private WebElement heaterStyle;

    @FindBy(id = "heater-actuator-type")
    private WebElement heaterActuatorType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    @FindBy(xpath = "(//div[@class='spinner input double left']//div[@class='spinner-up spinner-button'])[1]")
    private WebElement spinnerWidthUpButton;

    @FindBy(xpath = "(//div[@class='spinner input double right']//div[@class='spinner-up spinner-button'])[1]")
    private WebElement spinnerDepthUpButton;

    @FindBy(xpath = "(//div[@class='spinner input']//div[@class='spinner-down spinner-button'])[2]")
    private WebElement spinnerHeightDownButton;

    @FindBy(xpath = "(//div[@class='spinner input double left']//div[@class='spinner-up spinner-button'])[2]")
    private WebElement spinnerUnitPriceUpButton;

    @FindBy(xpath = "(//div[@class='spinner input double right']//div[@class='spinner-up spinner-button'])[2]")
    private WebElement spinnerInstallationsPriceUpButton;

    @FindBy(xpath = "//input[@id='spinnerHeaterWidth']")
    private WebElement inputFieldHeaterWidth;

    @FindBy(xpath = "//input[@id='spinnerHeaterDepth']")
    private WebElement inputFieldHeaterDepth;

    @FindBy(xpath = "//input[@id='spinnerHeaterHeight']")
    private WebElement inputFieldHeaterHeight;

    @FindBy(xpath = "//input[@id='spinnerHeaterUnitPrice']")
    private WebElement inputFieldHeaterUnitPrice;

    @FindBy(xpath = "//input[@id='spinnerHeaterInstallationPrice']")
    private WebElement inputFieldHeaterInstallationsPrice;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public CreateHeater(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on heater Icon
     */
    public void clickOnHeaterIcon() {
        click(heaterIcon, 20);

    }

    /**
     * Clicks on create new type
     */
    public void clickOnCreateNewType() {
        click(newHeaterType, 20);
    }

    /**
     * Clicks on created type
     */
    public void clickOnCreatedType() {
        click(newHeater, 20);
    }

    /**
     * Sets the Heater name
     */
    public void setHeaterName() {
        type(heaterName, 20, propertyFile.getHeaterName());
    }

    /**
     * Selects heater type
     */
    public void selectHeaterType() {
        select(heaterType, 20, propertyFile.getHeaterType());
    }

    /**
     * Selects Heater Style
     */
    public void selectHeaterStyle() {
        select(heaterStyle, 20, propertyFile.getHeaterStyle());
    }

    /**
     * Selects Heater actuator type
     */
    public void selectHeaterActuatorType() {
        select(heaterActuatorType, 20, propertyFile.getHeaterActuatorType());
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
     * Clicks on spinner width
     */
    public void clickOnSpinnerWidthUpButton() {
        spinner(spinnerWidthUpButton, 4, 20);
    }

    /**
     * Clicks on spinner depth
     */
    public void clickOnSpinnerDepthUpButton() {
        spinner(spinnerDepthUpButton, 6, 20);
    }

    /**
     * Clicks on spinner height
     */
    public void clickOnSpinnerHeightDownButton() {
        spinner(spinnerHeightDownButton, 6, 20);
    }

    /**
     * Clicks on spinner unit price
     */
    public void clickOnSpinnerUnitPriceUpButton() {
        spinner(spinnerUnitPriceUpButton, 6, 20);
    }

    /**
     * Clicks on spinner installations price
     */
    public void clickOnSpinnerInstallationsPriceUpButton() {
        spinner(spinnerInstallationsPriceUpButton, 6, 20);
    }

    /**
     * Gets value from Heater name
     *
     * @return Heater name
     */
    public String getValueFromInpuFieldHeaterName() {
        return getValueFromInputField(heaterName);
    }

    /**
     * Gets value from Heater type
     *
     * @return Heater type
     */
    public String getValueFromSelectHeaterType() {
        return getValueFromDropDownMenu(heaterType);
    }

    /**
     * Gets value from Heater Style
     *
     * @return Heater Style
     */
    public String getValueFromSelectHeaterStyle() {
        return getValueFromDropDownMenu(heaterStyle);
    }

    /**
     * Gets value form Heater Actuator
     *
     * @return Heater Actuator
     */
    public String getValueFromSelecHeaterActuatorType() {
        return getValueFromDropDownMenu(heaterActuatorType);
    }

    /**
     * Gets value from spinner width
     *
     * @return value
     */
    public String getValueFromSpinnerWidth() {
        return getValueFromInputField(inputFieldHeaterWidth);
    }

    /**
     * Gets value from spinner depth
     *
     * @return value
     */
    public String getValueFromSpinnerDepth() {
        return getValueFromInputField(inputFieldHeaterDepth);
    }

    /**
     * Gets value form spinner height
     *
     * @return value
     */
    public String getValueFromSpinnerHeight() {
        return getValueFromInputField(inputFieldHeaterHeight);
    }

    /**
     * Gets value from spinner unit price
     *
     * @return value
     */
    public String getValueFromSpinnerUnitPrice() {
        return getValueFromInputField(inputFieldHeaterUnitPrice);
    }

    /**
     * Gets value from spinner installations price
     *
     * @return value
     */
    public String getValueFromSpinnerInstallationsPrice() {
        return getValueFromInputField(inputFieldHeaterInstallationsPrice);
    }

    /**
     * Creates Heater and abort
     */
    public void createHeaterAndAbort() {
        setHeaterName();
        selectHeaterStyle();
        selectHeaterType();
        clickOnSpinnerWidthUpButton();
        clickOnSpinnerDepthUpButton();
        clickOnSpinnerHeightDownButton();
        clickOnSpinnerUnitPriceUpButton();
        clickOnSpinnerInstallationsPriceUpButton();
        selectHeaterActuatorType();
        clickOnAbortChanges();
    }

    /**
     * Creates Heater and save
     */
    public void createHeaterAndSave() {
        setHeaterName();
        selectHeaterStyle();
        selectHeaterType();
        clickOnSpinnerWidthUpButton();
        clickOnSpinnerDepthUpButton();
        clickOnSpinnerHeightDownButton();
        clickOnSpinnerUnitPriceUpButton();
        clickOnSpinnerInstallationsPriceUpButton();
        selectHeaterActuatorType();
        clickOnSaveChanges();
    }

}
