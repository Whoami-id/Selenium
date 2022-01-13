
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSanitary {

    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    // Finds correct element
    @FindBy(xpath = "//li[@data-target='template/sanitaries']")
    WebElement sanitaryIcon;

    @FindBy(id = "newSanitary")
    WebElement createNewSanitaryType;

    @FindBy(className = "itemDescription")
    WebElement newSanitary;

    @FindBy(id = "sanitaryName")
    WebElement sanitaryName;

    @FindBy(id = "sanitaryVariant")
    WebElement sanitaryVariant;

    @FindBy(id = "sanitaryMatNumber")
    WebElement sanitaryArticleNr;

    @FindBy(id = "sanitaryDescriptionText")
    WebElement sanitaryDescription;

    @FindBy(id = "sanitaryMsrType")
    WebElement sanitaryType;

    @FindBy(id = "sanitaryUnit")
    WebElement sanitaryUnit;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    public CreateSanitary(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on Sanitary icon
     */
    public void clickOnSensorIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(sanitaryIcon))
                .click();
    }

    /**
     * Clicks on create new Type
     */
    public void clickOnCreateNewType() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(createNewSanitaryType)).click();
    }

    /**
     * Clicks on Created type
     */
    public void clickOnCreatedType() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(newSanitary))
                .click();
    }

    /**
     * Sets Sanitary name
     */
    public void setSanitaryName() {
        final WebElement name = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sanitaryName));
        name.clear();
        name.sendKeys(propertyFile.getSanitaryName());
    }

    /**
     * Selects Sanitary Variant
     */
    public void selectSanitayVariant() {
        final WebElement variant = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sanitaryVariant));
        final Select select = new Select(variant);
        select.selectByVisibleText(propertyFile.getSanitaryVariant());
    }

    /**
     * Sets Sanitary ArticleNr
     */
    public void setSanitaryArticleNr() {
        final WebElement articleNr = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sanitaryArticleNr));
        articleNr.clear();
        articleNr.sendKeys(propertyFile.getSanitaryArticleNr());
    }

    /**
     * Sets Sanitary Description
     */
    public void setSanitaryDescription() {
        final WebElement description = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sanitaryDescription));
        description.clear();
        description.sendKeys(propertyFile.getSanitaryDescription());
    }

    /**
     * Selects Sanitary Type
     */
    public void selectSanitayType() {
        final WebElement type = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sanitaryType));
        final Select select = new Select(type);
        select.selectByVisibleText(propertyFile.getSanitaryType());
    }

    /**
     * Sets Sanitary unit
     */
    public void setSanitaryUnit() {
        final WebElement unit = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sanitaryUnit));
        unit.clear();
        unit.sendKeys(propertyFile.getSanitaryUnit());
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
     * Gets Sanitary name
     *
     * @return name
     */
    public String getValueFromInputFieldName() {
        return sanitaryName.getAttribute("value");
    }

    /**
     * Gets selected variant
     *
     * @return variant
     */
    public String getValueFromSelectSanitaryVarinat() {
        final WebElement variant = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sanitaryVariant));
        return new Select(variant).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Sanitary ArticleNr
     *
     * @return ArticleNr
     */
    public String getValueFromInputFieldArticleNr() {
        return sanitaryArticleNr.getAttribute("value");
    }

    /**
     * Gets Sanitary description
     *
     * @return description
     */
    public String getValueFromInputFieldDescription() {
        return sanitaryDescription.getAttribute("value");
    }

    /**
     * Gets selected Sanitary Type
     *
     * @return type
     */
    public String getValueFromSelectSanitaryType() {
        final WebElement type = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(sanitaryType));
        return new Select(type).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Sanitary unit
     *
     * @return unit
     */
    public String getValueFromInputFieldUnit() {
        return sanitaryUnit.getAttribute("value");
    }

    /**
     * Creates Sanitary and Abort
     */
    public void createSanitaryAndAbor() {
        setSanitaryName();
        selectSanitayType();
        selectSanitayVariant();
        setSanitaryArticleNr();
        setSanitaryDescription();
        setSanitaryUnit();
        clickOnAbortChanges();
    }

    /**
     * Creates Sanitary and Save
     */
    public void createSanitaryAndSave() {
        setSanitaryName();
        selectSanitayType();
        selectSanitayVariant();
        setSanitaryArticleNr();
        setSanitaryDescription();
        setSanitaryUnit();
        clickOnSaveChanges();
    }

}
