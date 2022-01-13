
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateHeater {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    // Finds correct elements
    @FindBy(xpath = "//li[@data-target='template/heaters']")
    WebElement heaterIcon;

    @FindBy(id = "newHeater")
    WebElement newHeaterType;

    @FindBy(className = "itemDescription")
    WebElement newHeater;

    @FindBy(id = "heatername")
    WebElement heaterName;

    @FindBy(id = "heater-type")
    WebElement heaterType;

    @FindBy(id = "heater-style")
    WebElement heaterStyle;

    @FindBy(id = "heater-actuator-type")
    WebElement heaterActuatorType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    /**
     * Constructor ha one parameter
     *
     * @param driver
     */
    public CreateHeater(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on heater Icon
     */
    public void clickOnHeaterIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(heaterIcon))
                .click();

    }

    /**
     * Clicks on create new type
     */
    public void clickOnCreateNewType() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(newHeaterType))
                .click();
    }

    /**
     * Click on created type
     */
    public void clickOnCreatedType() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(newHeater))
                .click();
    }

    /**
     * Sets the Heater name
     */
    public void setHeaterName() {
        final WebElement name = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(heaterName));
        name.clear();
        name.sendKeys(propertyFile.getHeaterName());
    }

    /**
     * Selects heater type
     */
    public void selectHeaterType() {
        final WebElement type = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(heaterType));
        final Select select = new Select(type);
        select.selectByVisibleText(propertyFile.getHeaterType());
    }

    /**
     * Selects Heater Style
     */
    public void selectHeaterStyle() {
        final WebElement style = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(heaterStyle));
        final Select select = new Select(style);
        select.selectByVisibleText(propertyFile.getHeaterStyle());
    }

    /**
     * Selects Heater actuator type
     */
    public void selectHeaterActuatorType() {
        final WebElement actuator = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(heaterActuatorType));
        final Select select = new Select(actuator);
        select.selectByVisibleText(propertyFile.getHeaterActuatorType());
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
     * Gets value from Heater name
     *
     * @return Heater name
     */
    public String getValueFromInpuFieldHeaterName() {
        return heaterName.getAttribute("value");
    }

    /**
     * Gets value from Heater type
     *
     * @return Heater type
     */
    public String getValueFromSelectHeaterType() {
        final WebElement type = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(heaterType));
        return new Select(type).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value from Heater Style
     *
     * @return Heater Style
     */
    public String getValueFromSelectHeaterStyle() {
        final WebElement style = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(heaterStyle));
        return new Select(style).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value form Heater Actuator
     *
     * @return Heater Actuator
     */
    public String getValueFromSelecHeaterActuatorType() {
        final WebElement actuator = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(heaterActuatorType));
        return new Select(actuator).getFirstSelectedOption().getText().trim();
    }

    /**
     * Creates Heater and abort
     */
    public void createHeaterAndAbort() {
        setHeaterName();
        selectHeaterType();
        selectHeaterStyle();
        selectHeaterActuatorType();
        clickOnAbortChanges();
    }

    /**
     * Creates Heater and save
     */
    public void createHeaterAndSave() {
        setHeaterName();
        selectHeaterType();
        selectHeaterStyle();
        selectHeaterActuatorType();
        clickOnSaveChanges();
    }

}
