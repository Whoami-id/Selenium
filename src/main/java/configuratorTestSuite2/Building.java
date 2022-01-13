
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Building extends Base {
    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds correct Elements */

    @FindBy(id = "buildingplanning")
    private WebElement buildingplanning;

    @FindBy(id = "building-type")
    private WebElement buildingType;

    @FindBy(id = "building-situation")
    private WebElement buildingSituation;

    @FindBy(id = "building-shape")
    private WebElement buildingShape;

    @FindBy(xpath = "//div[@class='spinner input double left']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerNetFootAreaUPButton;

    @FindBy(id = "spinner-area")
    private WebElement InputFieldSpinnerNetFloorArea;

    @FindBy(xpath = "//li[@data-target='buildingplanning/housingunit']")
    private WebElement housingUnitIcon;

    @FindBy(xpath = "//li[@data-target='buildingplanning/building']")
    private WebElement buildingIcon;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public Building(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on building icon
     */
    public void clickOnBuildingIcon() {
        click(buildingIcon, 20);
    }

    /**
     * Clicks on housing unit icon
     */
    public void clickOnHousingUnitIcon() {
        click(housingUnitIcon, 20);
    }

    /**
     * Clicks on building planing icon
     */
    public void clickOnBuildingPlaningIcon() {
        click(buildingplanning, 40);
    }

    /**
     * Selects building type
     */
    public void selectBuildingType() {
        select(buildingType, 20, propertyFile.getBuildingType());
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerNetFloorAreaUPButto() {
        spinner(spinnerNetFootAreaUPButton, 6, 20);
    }

    /**
     * Selects building situation
     */
    public void selectBuildingSituation() {
        select(buildingSituation, 20, propertyFile.getBuildigSituation());
    }

    /**
     * Selects Building shape
     */
    public void selectBuildingShape() {
        select(buildingShape, 20, propertyFile.getBuildigShape());
    }

    /**
     * Gets value from select building type
     *
     * @return building type
     */
    public String getValueFromSelcteBuildingType() {
        return getValueFromDropDownMenu(buildingType);
    }

    /**
     * Gets value from spinner building net floor area
     *
     * @return net floor area
     */
    public String getValueFromSpinnerNetFloorArea() {
        return getValueFromInputField(InputFieldSpinnerNetFloorArea);
    }

    /**
     * Gets value from select building situation
     *
     * @return building situation
     */
    public String getValueFromSelectBuildindSituation() {
        return getValueFromDropDownMenu(buildingSituation);
    }

    /**
     * Gets value from building shape
     *
     * @return building shape
     */
    public String getValueFromSelectBuildingShape() {
        return getValueFromDropDownMenu(buildingShape);
    }

}
