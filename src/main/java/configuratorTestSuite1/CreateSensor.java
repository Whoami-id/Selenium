
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSensor {

    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    // Finds correct element
    @FindBy(xpath = "//li[@data-target='template/sensors']")
    WebElement sensorIcon;

    @FindBy(id = "newSensor")
    WebElement createNewSensorType;

    @FindBy(className = "itemDescription")
    WebElement newSensor;

    @FindBy(id = "sensorname")
    WebElement sensorName;

    @FindBy(id = "category-type")
    WebElement sensorCategory;

    @FindBy(id = "connection-type")
    WebElement sensorConnection;

    @FindBy(id = "mounting-type")
    WebElement sensorMounting;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    public CreateSensor(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on Sensor icon
     */
    public void clickOnSensorIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(sensorIcon))
                .click();
    }

    /**
     * Clicks on create new Type
     */
    public void clickOnCreateNewType() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(createNewSensorType)).click();
    }

    /**
     * Clicks on Created type
     */
    public void clickOnCreatedType() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(newSensor))
                .click();
    }

    /**
     * Sets Sensor name
     */
    public void setSensorName() {
        final WebElement name = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sensorName));
        name.clear();
        name.sendKeys(propertyFile.getSensorName());
    }

    /**
     * Selects sensor category
     */
    public void selectSensorCategory() {
        final WebElement category = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sensorCategory));
        final Select select = new Select(category);
        select.selectByVisibleText(propertyFile.getSensorCategory());
    }

    /**
     * Selects Sensor Connection
     */
    public void selectSensorConnection() {
        final WebElement Connection = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sensorConnection));
        final Select select = new Select(Connection);
        select.selectByVisibleText(propertyFile.getSensorConnection());
    }

    /**
     * Selects Sensor Mounting
     */
    public void selectSensorMounting() {
        final WebElement mounting = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sensorMounting));
        final Select select = new Select(mounting);
        select.selectByVisibleText(propertyFile.getSensorMounting());
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
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(delete))
                .click();
    }

    /**
     * Clicks on Abort Button
     */
    public void clickOnAbortChanges() {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(abortChanges))
                .click();
    }

    /**
     * Gets Sensor name
     * 
     * @return sensorName
     */
    public String getValueFromInputFieldSensorName() {
        return sensorName.getAttribute("value");
    }

    /**
     * Gets Sensor category
     * 
     * @return sensorCategory
     */
    public String getValueFromSelectSensorCategory() {
        final WebElement category = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(sensorCategory));
        return new Select(category).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Sensor connection
     * 
     * @return sensorConnection
     */
    public String getValueFromSelectSensorConnection() {
        final WebElement connection = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(sensorConnection));
        return new Select(connection).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets SensorMounting type
     * 
     * @return sensorMountingType
     */
    public String getValueFromSelectSensorMountingType() {
        final WebElement sensorMountingType = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(sensorMounting));
        return new Select(sensorMountingType).getFirstSelectedOption().getText().trim();

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
