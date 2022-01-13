
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBlinds extends Base {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds Correct element */
    private @FindBy(xpath = "//li[@data-target='template/blinds']") WebElement blindIcon;

    @FindBy(id = "newBlind")
    private WebElement createType;

    @FindBy(className = "itemDescription")
    private WebElement newBlind;

    @FindBy(id = "blindname")
    private WebElement blindName;

    @FindBy(id = "shading-type")
    private WebElement shadingType;

    @FindBy(className = "checkbox-span")
    private WebElement switchable;

    @FindBy(id = "shading-color-type")
    private WebElement shadingColorType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    /**
     * Constructor from Class
     *
     * @param driver
     */
    public CreateBlinds(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on Blind icon
     */
    public void clickOnBlindIcon() {
        click(blindIcon, 20);
    }

    /**
     * Clicks on create new Blind
     */
    public void clickOnCreateNewType() {
        click(createType, 20);
    }

    /**
     * Clicks on created Blind
     */
    public void clickOnCreatedBlind() {
        click(newBlind, 20);
    }

    /**
     * Write BlindName in input field
     */
    public void setBlindName() {
        type(blindName, 20, propertyFile.getBlindName());
    }

    /**
     * Selects shading type from drop down menu
     */
    public void selectShadingType() {
        select(shadingType, 20, propertyFile.getShadingType());
    }

    /**
     * Clicks on switchable
     */
    public void clickOnSwitchable() {
        click(switchable, 20);
    }

    /**
     * Selects shadingColortype
     */
    public void selectShadingColorType() {
        select(shadingColorType, 20, propertyFile.getShadingColor());
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
     * Gets value from Blind name
     *
     * @return Blind name
     */
    public String getValueFromInputFieldBlindsName() {
        return getValueFromInputField(blindName);
    }

    /**
     * Gets value from shading type
     *
     * @return shading type
     */
    public String getValeuFromSelectShadingType() {
        return getValueFromDropDownMenu(shadingType);
    }

    /**
     * Gets value from shading color
     *
     * @return shading color
     */
    public String getValueFromSelectColor() {
        return getValueFromDropDownMenu(shadingColorType);
    }

    /**
     * Creates Blind and aborts changes
     */
    public void createBlindAndAbortChanges() {
        setBlindName();
        selectShadingType();
        clickOnSwitchable();
        selectShadingColorType();
        clickOnAbortChanges();
    }

    /**
     * Creates Blind and saves changes
     */
    public void createBlindAndSaveChanges() {
        setBlindName();
        selectShadingType();
        clickOnSwitchable();
        selectShadingColorType();
        clickOnSaveChanges();
    }

}
