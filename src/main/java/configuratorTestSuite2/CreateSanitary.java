
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateSanitary extends Base {

    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='template/sanitaries']")
    private WebElement sanitaryIcon;

    @FindBy(id = "newSanitary")
    private WebElement createNewSanitaryType;

    @FindBy(className = "itemDescription")
    private WebElement newSanitary;

    @FindBy(id = "sanitaryName")
    private WebElement sanitaryName;

    @FindBy(id = "sanitaryVariant")
    private WebElement sanitaryVariant;

    @FindBy(id = "sanitaryMatNumber")
    private WebElement sanitaryArticleNr;

    @FindBy(id = "sanitaryDescriptionText")
    private WebElement sanitaryDescription;

    @FindBy(id = "sanitaryMsrType")
    private WebElement sanitaryType;

    @FindBy(id = "sanitaryUnit")
    private WebElement sanitaryUnit;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    @FindBy(xpath = "//div[@class='spinner input double left']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerUnitPriceUpButton;

    @FindBy(xpath = "//div[@class='spinner input double right']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerInstallationsPriceUpButton;

    @FindBy(xpath = "//input[@id='sanitaryUnitPrice']")
    private WebElement inputFieldUnitPrice;

    @FindBy(xpath = "//input[@id='sanitaryInstallationPrice']")
    private WebElement inputFieldInstallationsPrice;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public CreateSanitary(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on Sanitary icon
     */
    public void clickOnSensorIcon() {
        click(sanitaryIcon, 30);
    }

    /**
     * Clicks on create new Type
     */
    public void clickOnCreateNewType() {
        click(createNewSanitaryType, 20);
    }

    /**
     * Clicks on Created type
     */
    public void clickOnCreatedType() {
        click(newSanitary, 20);
    }

    /**
     * Sets Sanitary name
     */
    public void setSanitaryName() {
        type(sanitaryName, 20, propertyFile.getSanitaryName());
    }

    /**
     * Selects Sanitary Variant
     */
    public void selectSanitayVariant() {
        select(sanitaryVariant, 20, propertyFile.getSanitaryVariant());
    }

    /**
     * Sets Sanitary ArticleNr
     */
    public void setSanitaryArticleNr() {
        type(sanitaryArticleNr, 20, propertyFile.getSanitaryArticleNr());
    }

    /**
     * Sets Sanitary Description
     */
    public void setSanitaryDescription() {
        type(sanitaryDescription, 20, propertyFile.getSanitaryDescription());
    }

    /**
     * Selects Sanitary Type
     */
    public void selectSanitayType() {
        select(sanitaryType, 20, propertyFile.getSanitaryType());
    }

    /**
     * Sets Sanitary unit
     */
    public void setSanitaryUnit() {
        type(sanitaryUnit, 20, propertyFile.getSanitaryUnit());
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
     * Clicks on spinner
     */
    public void clickOnSpinnerUnitPriceUpButton() {
        spinner(spinnerUnitPriceUpButton, 6, 20);
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerInstallationsPriceUpButton() {
        spinner(spinnerInstallationsPriceUpButton, 6, 20);
    }

    /**
     * Gets Sanitary name
     *
     * @return name
     */
    public String getValueFromInputFieldName() {
        return getValueFromInputField(sanitaryName);
    }

    /**
     * Gets selected variant
     *
     * @return variant
     */
    public String getValueFromSelectSanitaryVarinat() {
        return getValueFromDropDownMenu(sanitaryVariant);
    }

    /**
     * Gets Sanitary ArticleNr
     *
     * @return ArticleNr
     */
    public String getValueFromInputFieldArticleNr() {
        return getValueFromInputField(sanitaryArticleNr);
    }

    /**
     * Gets Sanitary description
     *
     * @return description
     */
    public String getValueFromInputFieldDescription() {
        return getValueFromInputField(sanitaryDescription);
    }

    /**
     * Gets selected Sanitary Type
     *
     * @return type
     */
    public String getValueFromSelectSanitaryType() {
        return getValueFromDropDownMenu(sanitaryType);
    }

    /**
     * Gets Sanitary unit
     *
     * @return unit
     */
    public String getValueFromInputFieldUnit() {
        return getValueFromInputField(sanitaryUnit);
    }

    /**
     * Gets value from spinner unit price
     *
     * @return value
     */
    public String getValueFromSpinnerSanitaryUnitPrice() {
        return getValueFromInputField(inputFieldUnitPrice);
    }

    /**
     * Gets value from spinner installations price
     *
     * @return price
     */
    public String getValueFromSpinnerSanitaryInstallationsPrice() {
        return getValueFromInputField(inputFieldInstallationsPrice);
    }

    /**
     * Creates Sanitary and Abort
     */
    public void createSanitaryAndAbor() {
        setSanitaryName();
        selectSanitayType();
        selectSanitayVariant();
        setSanitaryDescription();
        setSanitaryUnit();
        setSanitaryArticleNr();
        clickOnSpinnerUnitPriceUpButton();
        clickOnSpinnerInstallationsPriceUpButton();
        clickOnAbortChanges();
    }

    /**
     * Creates Sanitary and Save
     */
    public void createSanitaryAndSave() {
        setSanitaryName();
        selectSanitayType();
        selectSanitayVariant();
        setSanitaryDescription();
        setSanitaryUnit();
        setSanitaryArticleNr();
        clickOnSpinnerUnitPriceUpButton();
        clickOnSpinnerInstallationsPriceUpButton();
        clickOnSaveChanges();
    }
}
