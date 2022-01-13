
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateVentilation {
    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;
    // Finds correct element

    @FindBy(xpath = "//li[@data-target='template/ventilations']")
    WebElement ventilationIcon;

    @FindBy(id = "newVentilation")
    WebElement createNewType;

    @FindBy(className = "itemDescription")
    WebElement newAccessControl;

    @FindBy(id = "ventilationname")
    WebElement ventilationName;

    @FindBy(id = "usage-type")
    WebElement usageType;

    @FindBy(id = "system-type")
    WebElement systemType;

    @FindBy(id = "manufacturer-type")
    WebElement ventilationManufacturer;

    @FindBy(id = "model-type")
    WebElement modelType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    /**
     * Constructor for Class
     *
     * @param driver
     */
    public CreateVentilation(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on Ventilation icon
     */
    public void clickOnVentilationIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(ventilationIcon)).click();
    }

    /**
     * Clicks on Create new type
     */
    public void clickOnCreateNewType() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(createNewType))
                .click();
    }

    /**
     * Clicks on created Ventilation
     */
    public void clickOnCreatedVentilation() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(newAccessControl)).click();
    }

    /**
     * Sets Ventilation name
     */
    public void setVentilationName() {
        final WebElement name = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(ventilationName));
        name.clear();
        name.sendKeys(propertyFile.getVentilationName());
    }

    /**
     * Selects Ventilation usagetype
     */
    public void selectVentilationUsageType() {
        final WebElement type = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(usageType));
        final Select select = new Select(type);
        select.selectByVisibleText(propertyFile.getVentilationUsage());
    }

    /**
     * Selects Ventilation System
     */
    public void selectVentilationSystem() {
        final WebElement system = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(systemType));
        final Select select = new Select(system);
        select.selectByVisibleText(propertyFile.getVentilationSystem());
    }

    /**
     * Selects Ventilation manufacturer
     */
    public void selectVentilationManufacturer() {
        final WebElement manufacturer = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(ventilationManufacturer));
        final Select select = new Select(manufacturer);
        select.selectByVisibleText(propertyFile.getVentilationManufacturer());
    }

    /**
     * Selects Ventilation model
     */
    public void selectVentilatoinModel() {
        final WebElement model = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(modelType));
        final Select select = new Select(model);
        select.selectByVisibleText(propertyFile.getVentilationModel());
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
     * Gets Ventilations Name
     *
     * @return VentilationName
     */
    public String getValueFromInputFieldVentilationName() {
        return ventilationName.getAttribute("value");
    }

    /**
     * Gets Ventilation usage type
     *
     * @return usageType
     */
    public String getValueFromSelectVentilationUsageType() {
        final WebElement ventilationUsageType = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(usageType));
        return new Select(ventilationUsageType).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Ventilation system
     *
     * @return ventilationSystem
     */
    public String getValueFromSelectVentilationSystem() {
        final WebElement ventilationSystem = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(systemType));
        return new Select(ventilationSystem).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Ventilation Manufacturer
     *
     * @return ventilation manufacturer
     */
    public String getValueFromSelectVentilationManufacturer() {
        final WebElement manufacturer = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(ventilationManufacturer));
        return new Select(manufacturer).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Ventilation model
     *
     * @return Ventilation model
     */
    public String getValueFromSelectVentilationModel() {
        final WebElement model = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(modelType));
        return new Select(model).getFirstSelectedOption().getText().trim();
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
