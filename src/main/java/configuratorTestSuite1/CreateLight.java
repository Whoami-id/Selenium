
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateLight {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;
    // Finds correct element

    @FindBy(xpath = "//li[@data-target='template/lights']")
    WebElement lightIcon;

    @FindBy(id = "newLight")
    WebElement createNewLightType;

    @FindBy(className = "itemDescription")
    WebElement newLight;

    @FindBy(id = "lightname")
    WebElement lightName;

    @FindBy(id = "light-function-type")
    WebElement lightFunctionType;

    @FindBy(id = "matnumber")
    WebElement lightArticleNumber;

    @FindBy(id = "descriptiontext")
    WebElement lightDescriptionText;

    @FindBy(id = "light-type")
    WebElement lightType;

    @FindBy(id = "unit")
    WebElement lightUnit;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    /**
     * Constructor
     *
     * @param driver
     */
    public CreateLight(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on light icon
     */
    public void clickOnLightIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(lightIcon))
                .click();
    }

    /**
     * Clicks on create new Type
     */
    public void clickOnCreateNewType() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(createNewLightType)).click();
    }

    /**
     * Clicks on created light
     */
    public void clickOnCreatedLight() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(newLight))
                .click();
    }

    /**
     * Sets light name
     */
    public void setLightName() {
        final WebElement name = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(lightName));
        name.clear();
        name.sendKeys(propertyFile.getLightName());
    }

    /**
     * Selects Function type
     */
    public void selectFunctionType() {
        final WebElement functionType = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(lightFunctionType));
        final Select select = new Select(functionType);
        select.selectByVisibleText(propertyFile.getLightFunctionType());
    }

    /**
     * Sets articleNr.
     */
    public void setArticleNumber() {
        final WebElement articleNr = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(lightArticleNumber));
        articleNr.clear();
        articleNr.sendKeys(propertyFile.getLightArticleNumber());
    }

    /**
     * Sets Description Text
     */
    public void setDescriptionText() {
        final WebElement description = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(lightDescriptionText));
        description.clear();
        description.sendKeys(propertyFile.getLightDescriptionText());
    }

    /**
     * Selects light type
     */
    public void selectLightType() {
        final WebElement type = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(lightType));
        final Select select = new Select(type);
        select.selectByVisibleText(propertyFile.getLightType());
    }

    /**
     * Sets light unit
     */
    public void setUnit() {
        final WebElement unit = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(lightUnit));
        unit.clear();
        unit.sendKeys(propertyFile.getLightUnit());
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
     * Gets Light name
     *
     * @return lightName
     */
    public String getValueFromInputFieldLightName() {
        return lightName.getAttribute("value");
    }

    /**
     * Gets Light Functions Type
     *
     * @return functionType
     */
    public String getValueFromSelectLightFunctionType() {
        final WebElement functionType = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(lightFunctionType));
        return new Select(functionType).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Light Article number
     *
     * @return articleNumber
     */
    public String getValueFromInputFieldLightArticleNumber() {
        return lightArticleNumber.getAttribute("value");
    }

    /**
     * Gets Light description
     *
     * @return descriptionText
     */
    public String getValueFromInputFieldLightDescriptionText() {
        return lightDescriptionText.getAttribute("value");
    }

    /**
     * Gets Light type
     *
     * @return lightType
     */
    public String getValueFromSelectLightType() {
        final WebElement type = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(lightType));
        return new Select(type).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Light unit
     *
     * @return lightUnit
     */
    public String getValueFromInputFieldLightUnit() {
        return lightUnit.getAttribute("value");
    }

    /**
     * Creates light and abort
     */
    public void createLightAndAbort() {
        setLightName();
        selectFunctionType();
        setArticleNumber();
        setDescriptionText();
        selectLightType();
        setUnit();
        clickOnAbortChanges();
    }

    /**
     * Creates Light and save
     */
    public void createLightAndSave() {
        setLightName();
        selectFunctionType();
        setArticleNumber();
        setDescriptionText();
        selectLightType();
        setUnit();
        clickOnSaveChanges();

    }
}
