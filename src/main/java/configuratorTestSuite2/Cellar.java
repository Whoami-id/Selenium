
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cellar extends Base {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds correct Elements */
    @FindBy(xpath = "//li[@data-target='buildingplanning/cellar']")
    private WebElement cellarIcon;

    @FindBy(xpath = "//li[@data-target='buildingplanning/floors']")
    private WebElement floorIcon;

    @FindBy(id = "cellarType")
    private WebElement cellarType;

    @FindBy(id = "heatingType")
    private WebElement heatingType;

    @FindBy(id = "basePlateConcreteType")
    private WebElement basePlateConcreteType;

    @FindBy(id = "basePlateInsulationType")
    private WebElement basePlateInsulationType;

    @FindBy(xpath = "(//div[@class='spinner input']//div[@class='spinner-up spinner-button'])[2]")
    private WebElement spinnerUValueUpButton;

    @FindBy(xpath = "//div[@class='spinner input double left']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerNetAreaUpButton;

    @FindBy(xpath = "//div[@class='spinner input double right']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerFloorHeightUpButton;

    @FindBy(xpath = "//div[@class='spinner input basePlateThickness']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerThicknessBasePlateUpButton;

    @FindBy(xpath = "(//div[@class='spinner input']//div[@class='spinner-up spinner-button'])[1]")
    private WebElement spinnerInsulationThicknessUpButton;

    @FindBy(id = "spinner-cellar-uvalue")
    private WebElement inputFieldSpinnerUValue;

    @FindBy(id = "spinner-baseArea")
    private WebElement inputFieldSpinnerBaseArea;

    @FindBy(id = "spinner-cellar-floor-height")
    private WebElement inputFieldSpinnerFloorHeight;

    @FindBy(id = "spinner-basePlateThickness")
    private WebElement inputFieldSpinnerBasePlateThickness;

    @FindBy(id = "spinner-insulationThickness")
    private WebElement inputFieldSpinnerInsulationThickness;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public Cellar(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on cellar icon
     */
    public void clickOnCellarIcon() {
        click(cellarIcon, 20);
    }

    /**
     * Clicks on floor icon
     */
    public void clickOnFloorIcon() {
        click(floorIcon, 20);
    }

    /**
     * Selects cellar type
     */
    public void selectCellarType() {
        select(cellarType, 20, propertyFile.getCellarType());
    }

    /**
     * Selects cellar heating type
     */
    public void selectCellarHeatingType() {
        select(heatingType, 20, propertyFile.getCellarHeatingType());
    }

    /**
     * Selects concretes type
     */
    public void selectCellarBasePlateConcreteType() {
        select(basePlateConcreteType, 20, propertyFile.getCellarBasePlateConcreteType());
    }

    /**
     * Gets insulation type
     */
    public void selectCellarBasePlateInsulationType() {
        select(basePlateInsulationType, 20, propertyFile.getCellarBasePlateInsulationType());
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerUValueUpButton() {
        spinner(spinnerUValueUpButton, 3, 20);
    }

    /**
     * Clicks on spinner floor area
     */
    public void clickOnSpinnerNetFloorArea() {
        spinner(spinnerNetAreaUpButton, 8, 20);
    }

    /**
     * Clicks on spinner floor height
     */
    public void clickOnSpinnerFlooreHeight() {
        spinner(spinnerFloorHeightUpButton, 8, 20);
    }

    /**
     * Clicks on spinner thickness
     */
    public void clickOnSpinneThicknessBasePlate() {
        spinner(spinnerThicknessBasePlateUpButton, 2, 20);
    }

    /**
     * Clicks on spinner insulation thickness
     */
    public void clickOnSpinnerInsulationThickness() {
        spinner(spinnerInsulationThicknessUpButton, 3, 20);
    }

    /**
     * Gets value from cellar type
     *
     * @return cellar type
     */
    public String getValueFromSelctCellarType() {
        return getValueFromDropDownMenu(cellarType);
    }

    /**
     * Gets value from cellar heating type
     *
     * @return heating type
     */
    public String getValueFromSelctCellarHeatingType() {
        return getValueFromDropDownMenu(heatingType);
    }

    /**
     * Gets value from concrete type
     *
     * @return concrete types
     */
    public String getValueFromSelectBasePlateConcreteType() {
        return getValueFromDropDownMenu(basePlateConcreteType);
    }

    /**
     * Gets value from insulation type
     *
     * @return insulation type
     */
    public String getValueFromSelectBasePlateInsulationType() {
        return getValueFromDropDownMenu(basePlateInsulationType);
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
     * Gets value from spinner floor area
     *
     * @return floor area
     */
    public String getValueFromSpinnerNetFloorArea() {
        return getValueFromInputField(inputFieldSpinnerBaseArea);
    }

    /**
     * Gets value from spinner floor height
     *
     * @return floor height
     */
    public String getValueFromSpinnerFloorHeight() {
        return getValueFromInputField(inputFieldSpinnerFloorHeight);
    }

    /**
     * Gets value form spinner plate thickness
     *
     * @return plate thickness
     */
    public String getValueFromSpinnerBasePlateThickness() {
        return getValueFromInputField(inputFieldSpinnerBasePlateThickness);
    }

    /**
     * Gets value from spinner insulation thickness
     *
     * @return insulation thickness
     */
    public String getValueFromSinnerInsulationThickness() {
        return getValueFromInputField(inputFieldSpinnerInsulationThickness);
    }

    /**
     * Planing cellar
     *
     * @throws InterruptedException
     */
    public void planingCellar() {
        selectCellarType();
        selectCellarHeatingType();
        selectCellarBasePlateConcreteType();
        selectCellarBasePlateInsulationType();
        clickOnSpinnerUValueUpButton();
        clickOnSpinnerNetFloorArea();
        clickOnSpinnerFlooreHeight();
        clickOnSpinneThicknessBasePlate();
        clickOnSpinnerInsulationThickness();
    }
}
