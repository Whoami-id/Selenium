
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Roof extends Base {

    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    /* Finds correct Elements */
    @FindBy(xpath = "//li[@data-target='buildingplanning/roof']")
    private WebElement roofIcon;

    @FindBy(xpath = "//li[@data-target='buildingplanning/air-conditioning']")
    private WebElement airIcon;

    @FindBy(id = "roofshape")
    private WebElement roofShape;

    @FindBy(id = "heatingType")
    private WebElement heatingType;

    @FindBy(xpath = "(//div[@class='spinner input double left']//div[@class='spinner-up spinner-button'])[1]")
    private WebElement spinnerRoofPitchUpButton;

    @FindBy(xpath = "(//div[@class='spinner input double right']//div[@class='spinner-up spinner-button'])[1]")
    private WebElement spinnerroofHeightUpButton;

    @FindBy(id = "insulationType")
    private WebElement insulationType;

    @FindBy(xpath = "//div[@class='spinner input']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerUvalueUpButton;

    @FindBy(id = "spinner-roof-pitch")
    private WebElement inputFieldSpinnerRoofPitch;

    @FindBy(id = "spinner-roof-floor-height")
    private WebElement inputFieldSpinnerRoofHeight;

    @FindBy(id = "spinner-roof-uvalue")
    private WebElement inputFieldSpinnerUValue;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public Roof(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on roof icon
     */
    public void clickOnRoofIcon() {
        click(roofIcon, 20);
    }

    /**
     * Clicks on air icon
     */
    public void clickOnAirIcon() {
        click(airIcon, 20);
    }

    /**
     * Selects roof shape
     */
    public void selectRoofShape() {
        select(roofShape, 20, propertyFile.getRoofShape());
    }

    /**
     * Selects roof heating
     */
    public void selectRoofHeating() {
        select(heatingType, 20, propertyFile.getRoofHeating());
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerRoofPitchUpButton() {
        spinner(spinnerRoofPitchUpButton, 4, 20);
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerRoofHeight() {
        spinner(spinnerroofHeightUpButton, 4, 20);
    }

    /**
     * Selects roof insulation type
     */
    public void selectRoofInsulationType() {
        select(insulationType, 20, propertyFile.getRoofInsulationType());
    }

    /**
     * clicks on spinner
     */
    public void clickOnSpinnerUValueUButton() {
        spinner(spinnerUvalueUpButton, 4, 20);
    }

    /**
     * Gets roof shape
     *
     * @return roof shape
     */
    public String getValueFromSelectRoofShape() {
        return getValueFromDropDownMenu(roofShape);
    }

    /**
     * Gets value from heating type
     *
     * @return heating type
     */
    public String getValueFromSelectRoofHeating() {
        return getValueFromDropDownMenu(heatingType);
    }

    /**
     * Gets value from spinner roof pitch
     *
     * @return roof pitch
     */
    public String getValueFromSpinnerRoofPitch() {
        return getValueFromInputField(inputFieldSpinnerRoofPitch);
    }

    /**
     * Gets value from spinner roof height
     *
     * @return roof height
     */
    public String getValueFromSpinnerRoofHeight() {
        return getValueFromInputField(inputFieldSpinnerRoofHeight);
    }

    /**
     * Gets value from insulation type
     *
     * @return insulation type
     */
    public String getValueFromSelectRoofInsulationType() {
        return getValueFromDropDownMenu(insulationType);
    }

    /**
     * Gets value from spinner u value
     *
     * @return u value
     */
    public String getValueFromSpinnerUValue() {
        return getValueFromInputField(inputFieldSpinnerUValue);
    }

    /**
     * Planing roof
     */
    public void planingRoof() {
        selectRoofShape();
        selectRoofHeating();
        clickOnSpinnerRoofPitchUpButton();
        clickOnSpinnerRoofHeight();
        getValueFromSelectRoofInsulationType();
        clickOnSpinnerUValueUButton();
    }
}
