
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateLight extends Base {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='template/lights']")
    private WebElement lightIcon;

    @FindBy(id = "newLight")
    private WebElement createNewLightType;

    @FindBy(xpath = "//div[@class='itemDescription']")
    private WebElement newLight;

    @FindBy(id = "lightname")
    private WebElement lightName;

    @FindBy(xpath = "//select[@id='light-function-type']")
    private WebElement lightFunctionType;

    @FindBy(id = "matnumber")
    private WebElement lightArticleNumber;

    @FindBy(id = "descriptiontext")
    private WebElement lightDescriptionText;

    @FindBy(xpath = "//select[@id='light-type']")
    private WebElement lightType;

    @FindBy(id = "unit")
    private WebElement lightUnit;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    @FindBy(xpath = "(//div[@class='spinner input double left']//div[@class='spinner-up spinner-button'])[1]")
    private WebElement spinnerLengthUpButton;

    @FindBy(xpath = "(//div[@class='spinner input double right']//div[@class='spinner-up spinner-button'])[1]")
    private WebElement spinnerWidthUpButton;

    @FindBy(xpath = "(//div[@class='spinner input double left']//div[@class='spinner-up spinner-button'])[2]")
    private WebElement spinnerUnitPriceUpButton;

    @FindBy(xpath = "(//div[@class='spinner input double right']//div[@class='spinner-up spinner-button'])[2]")
    private WebElement spinnerInstallationsPrice;

    @FindBy(xpath = "//input[@id='spinner-light-length']")
    private WebElement inputFieldSpinnerLenght;

    @FindBy(xpath = "//input[@id='spinner-light-width']")
    private WebElement inputFieldSpinnerWidth;

    @FindBy(xpath = "//input[@id='spinner-light-unit-price']")
    private WebElement inputFieldSpinnerUnitPrice;

    @FindBy(xpath = "//input[@id='spinner-light-installation-price']")
    private WebElement inputFieldSpinnerInstallationsPrice;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public CreateLight(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on light icon
     */
    public void clickOnLightIcon() {
        click(lightIcon, 20);
    }

    /**
     * Clicks on create new Type
     */
    public void clickOnCreateNewType() {
        click(createNewLightType, 20);
    }

    /**
     * Clicks on created light
     */
    public void clickOnCreatedLight() {
        click(newLight, 20);
    }

    /**
     * Sets light name
     */
    public void setLightName() {
        type(lightName, 20, propertyFile.getLightName());
    }

    /**
     * Selects Function type
     */
    public void selectFunctionType() {
        select(lightFunctionType, 20, propertyFile.getLightFunctionType());
    }

    /**
     * Sets articleNr.
     */
    public void setArticleNumber() {
        type(lightArticleNumber, 20, propertyFile.getLightArticleNumber());
    }

    /**
     * Sets Description Text
     */
    public void setDescriptionText() {
        type(lightDescriptionText, 20, propertyFile.getLightDescriptionText());
    }

    /**
     * Selects light type
     */
    public void selectLightType() {
        select(lightType, 20, propertyFile.getLightType());
    }

    /**
     * Sets light unit
     */
    public void setUnit() {
        type(lightUnit, 20, propertyFile.getLightUnit());
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
     * Clicks on spinner length
     */
    public void clickOnSpinnerLengthUpButton() {
        spinner(spinnerLengthUpButton, 6, 20);
    }

    /**
     * Clicks on spinner width
     */
    public void clickOnSpinnerWidthUpButton() {
        spinner(spinnerWidthUpButton, 6, 20);
    }

    /**
     * Clicks on spinner unit price
     */
    public void clickOnSpinnerUnitPricehUpButton() {
        spinner(spinnerUnitPriceUpButton, 6, 20);
    }

    /**
     * Clicks on spinner installations price
     */
    public void clickOnSpinnerInstallationsPricehUpButton() {
        spinner(spinnerInstallationsPrice, 6, 20);
    }

    /**
     * Gets Light name
     *
     * @return lightName
     */
    public String getValueFromInputFieldLightName() {
        return getValueFromInputField(lightName);
    }

    /**
     * Gets Light Functions Type
     *
     * @return functionType
     */
    public String getValueFromSelectLightFunctionType() {
        return getValueFromDropDownMenu(lightFunctionType);
    }

    /**
     * Gets Light Article number
     *
     * @return articleNumber
     */
    public String getValueFromInputFieldLightArticleNumber() {
        return getValueFromInputField(lightArticleNumber);
    }

    /**
     * Gets Light description
     *
     * @return descriptionText
     */
    public String getValueFromInputFieldLightDescriptionText() {
        return getValueFromInputField(lightDescriptionText);
    }

    /**
     * Gets Light type
     *
     * @return lightType
     */
    public String getValueFromSelectLightType() {
        return getValueFromDropDownMenu(lightType);
    }

    /**
     * Gets Light unit
     *
     * @return lightUnit
     */
    public String getValueFromInputFieldLightUnit() {
        return getValueFromInputField(lightUnit);
    }

    /**
     * Gets value from spinner length
     *
     * @return value
     */
    public String getValueFromSpinnerLength() {
        return getValueFromInputField(inputFieldSpinnerLenght);
    }

    /**
     * Gets Value from sinner width
     *
     * @return value
     */
    public String getValueFromSpinnerWidth() {
        return getValueFromInputField(inputFieldSpinnerWidth);
    }

    /**
     * Gets value from spinner Unit price
     *
     * @return value
     */
    public String getValueFromSpinnerUnitPrice() {
        return getValueFromInputField(inputFieldSpinnerUnitPrice);
    }

    /**
     * Gets value from spinner installations price
     *
     * @return value
     */
    public String getValueFromSpinnerInstallationsPrice() {
        return getValueFromInputField(inputFieldSpinnerInstallationsPrice);
    }

    /**
     * Creates light and abort
     */
    public void createLightAndAbort() {
        setLightName();
        clickOnSpinnerLengthUpButton();
        clickOnSpinnerWidthUpButton();
        selectFunctionType();
        setUnit();
        setDescriptionText();
        selectLightType();
        setArticleNumber();
        clickOnSpinnerUnitPricehUpButton();
        clickOnSpinnerInstallationsPricehUpButton();
        clickOnAbortChanges();
    }

    /**
     * Creates Light and save
     */
    public void createLightAndSave() {
        setLightName();
        clickOnSpinnerLengthUpButton();
        clickOnSpinnerWidthUpButton();
        selectFunctionType();
        setUnit();
        setDescriptionText();
        setArticleNumber();
        selectLightType();
        clickOnSpinnerUnitPricehUpButton();
        clickOnSpinnerInstallationsPricehUpButton();
        clickOnSaveChanges();
    }
}
