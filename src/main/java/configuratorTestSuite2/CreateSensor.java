
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateSensor extends Base {

    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='template/sensors']")
    private WebElement sensorIcon;

    @FindBy(id = "newSensor")
    private WebElement createNewSensorType;

    @FindBy(xpath = "//div[@class='itemDescription']")
    private WebElement newSensor;

    @FindBy(id = "sensorname")
    private WebElement sensorName;

    @FindBy(id = "category-type")
    private WebElement sensorCategory;

    @FindBy(id = "connection-type")
    private WebElement sensorConnection;

    @FindBy(id = "mounting-type")
    private WebElement sensorMounting;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public CreateSensor(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on Sensor icon
     */
    public void clickOnSensorIcon() {
        click(sensorIcon, 30);
    }

    /**
     * Clicks on create new Type
     */
    public void clickOnCreateNewType() {
        click(createNewSensorType, 30);
    }

    /**
     * Clicks on Created type
     */
    public void clickOnCreatedType() {
        click(newSensor, 30);
    }

    /**
     * Sets Sensor name
     */
    public void setSensorName() {
        type(sensorName, 20, propertyFile.getSensorName());
    }

    /**
     * Selects sensor category
     */
    public void selectSensorCategory() {
        select(sensorCategory, 20, propertyFile.getSensorCategory());
    }

    /**
     * Selects Sensor Connection
     */
    public void selectSensorConnection() {
        select(sensorConnection, 20, propertyFile.getSensorConnection());
    }

    /**
     * Selects Sensor Mounting
     */
    public void selectSensorMounting() {
        select(sensorMounting, 30, propertyFile.getSensorMounting());
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
     * Gets Sensor name
     *
     * @return sensorName
     */
    public String getValueFromInputFieldSensorName() {
        return getValueFromInputField(sensorName);
    }

    /**
     * Gets Sensor category
     *
     * @return sensorCategory
     */
    public String getValueFromSelectSensorCategory() {
        return getValueFromDropDownMenu(sensorCategory);
    }

    /**
     * Gets Sensor connection
     *
     * @return sensorConnection
     */
    public String getValueFromSelectSensorConnection() {
        return getValueFromDropDownMenu(sensorConnection);
    }

    /**
     * Gets SensorMounting type
     *
     * @return sensorMountingType
     */
    public String getValueFromSelectSensorMountingType() {
        return getValueFromDropDownMenu(sensorMounting);

    }

    /**
     * Create sensor and abort
     */
    public void createSensorAndAbort() {
        setSensorName();
        selectSensorCategory();
        selectSensorConnection();
        selectSensorMounting();
        clickOnAbortChanges();
    }

    /**
     * Create sensor and save
     */
    public void createSensorAndSave() {
        setSensorName();
        selectSensorCategory();
        selectSensorConnection();
        selectSensorMounting();
        clickOnSaveChanges();
    }
}
