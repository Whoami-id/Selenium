
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AirConditioning extends Base {
    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    /* Finds correct Elements */
    @FindBy(xpath = "//li[@data-target='buildingplanning/air-conditioning']")
    private WebElement airIcon;

    @FindBy(xpath = "//li[@data-target='buildingplanning/photovoltaic']")
    private WebElement photovoltaicIcon;

    @FindBy(id = "ventilation-system")
    private WebElement ventilationSystem;

    @FindBy(id = "popup-button-ok")
    private WebElement confirm;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public AirConditioning(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on air icon
     */
    public void clickOnAirConditioningIcon() {
        click(airIcon, 20);
    }

    /**
     * Clicks on photovoltaic icon
     */
    public void clickOnPhotovoltaicIcon() {
        click(photovoltaicIcon, 20);
    }

    /**
     * Selects ventilation system
     */
    public void SelectVentilationSystem() {
        select(ventilationSystem, 20, propertyFile.getAirVentilationSystem());
    }

    /**
     * Clicks on confirm
     */
    public void clickOnConfirm() {
        click(confirm, 20);
    }

    /**
     * Gets value from ventilation system
     *
     * @return ventilation system
     */
    public String getValueFromSelectVentilationSystem() {
        return getValueFromDropDownMenu(ventilationSystem);
    }

}
