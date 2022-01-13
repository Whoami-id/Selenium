
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateWall extends Base {
    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds correct element */
    @FindBy(id = "newWall")
    private WebElement crateType;

    @FindBy(xpath = "//div[@id='wallTemplates']//div[@class='itemDescription']")
    private WebElement newInsideWall;

    @FindBy(xpath = "//div[@id='wallTemplates']/div[1]/div[1]")
    private WebElement newOuterWall;

    @FindBy(id = "wallName")
    private WebElement wallNameInside;

    @FindBy(xpath = "//div[@id='wallTemplates']/div[1]/div[2]/div[1]/input")
    private WebElement wallNameOuter;

    @FindBy(xpath = "//select[@id='masonryType']")
    private WebElement masonryTypeInside;

    @FindBy(xpath = "//div[@id='wallTemplates']/div[1]/div[2]/div[3]/div/select")
    private WebElement masonryTypeOuter;

    @FindBy(xpath = "//select[@id='installationType']")
    private WebElement installationTypeInside;

    @FindBy(xpath = "//div[@id='wallTemplates']/div[1]/div[2]/div[5]/div/select")
    private WebElement installationTypeOuter;

    @FindBy(xpath = "//select[@id='wallType']")
    private WebElement wallTypeInside;

    @FindBy(xpath = "//div[@id='wallTemplates']/div[1]/div[2]/div[2]/div/select")
    private WebElement wallTypeOuter;

    @FindBy(xpath = "//select[@id='fireResistanceType']")
    private WebElement fireResistanceTypeInside;

    @FindBy(xpath = "//div[@id='wallTemplates']/div[1]/div[2]/div[6]/div/select")
    private WebElement fireResistanceTypeOuter;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement saveInsideWall;

    @FindBy(xpath = "//div[@id='wallTemplates']/div[1]/div[2]/div[7]/span[3]")
    private WebElement saveOuterWall;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abortInsideWall;

    @FindBy(xpath = "//div[@id='wallTemplates']/div[1]/div[2]/div[7]/span[2]")
    private WebElement abortOuterWall;

    @FindBy(xpath = "(//div[@class='spinner input masonry brick-size-value brick-size-spinner double left']//div[@class='spinner-up spinner-button'])[1]")
    private WebElement WallThicknessSpinnerUpButtonInsideWall;

    @FindBy(xpath = "(//div[@class='spinner input masonry brick-size-value brick-size-spinner double left']//div[@class='spinner-down spinner-button'])[1]")
    private WebElement WallThicknessSpinnerDownButtonInsideWall;

    @FindBy(xpath = "(//div[@class='spinner input masonry brick-size-value brick-size-spinner double left']//div[@class='spinner-up spinner-button'])[1]")
    private WebElement WallThicknessSpinnerUpButtonOutsideWall;

    @FindBy(xpath = "(//div[@class='spinner input masonry brick-size-value brick-size-spinner double left']//div[@class='spinner-down spinner-button'])[1]")
    private WebElement WallThicknessSpinnerDownButtonOutsideWall;

    @FindBy(xpath = "(//div[@class='spinner input uValue double right']//div[@class='spinner-up spinner-button'])[1]")
    private WebElement UValueSpinnerUpButtonOutsideWall;

    @FindBy(xpath = "(//div[@class='spinner input uValue double right']//div[@class='spinner-down spinner-button'])[1]")
    private WebElement UValueSpinnerDownButtonOutsideWall;

    @FindBy(xpath = "(//input[@id='spinnerBrickSize'])[1]")
    private WebElement spinnerInputFieldWallThicknessInsideWall;

    @FindBy(xpath = "(//input[@id='spinnerBrickSize'])[1]")
    private WebElement spinnerInputFieldWallThicknessOutsideWall;

    @FindBy(xpath = "(//input[@id='spinnerWallUvalue'])[1]")
    private WebElement spinnerInputFieldWallUValueOutsideWall;

    /**
     * Constructor the Class
     *
     * @param driver
     */
    public CreateWall(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on create new Wall Button
     */
    public void clickOnCreateWallType() {
        click(crateType, 20);
    }

    /**
     * Clicks on created Wall
     */
    public void clickOnCreatedInsideWall() {
        click(newInsideWall, 20);
    }

    /**
     * Clicks on created Wall
     */
    public void clickOnCreatedOuterWall() {
        click(newOuterWall, 20);
    }

    /**
     * Sets Wall name in input field
     */
    public void setInsideWallName() {
        type(wallNameInside, 20, propertyFile.getWallName20());
    }

    /**
     * Sets outer wall name
     */
    public void setOuterWallName() {
        type(wallNameOuter, 20, propertyFile.getWallName21());
    }

    /**
     * Selects Masonry type form drop down menu
     */
    public void selectInsideWallMasonryType() {
        select(masonryTypeInside, 20, propertyFile.getMasonryType());
    }

    /**
     * Selects Masonry type form drop down menu
     */
    public void selectOuterWallMasonryType() {
        select(masonryTypeOuter, 20, propertyFile.getMasonryType());
    }

    /**
     * Selects Installation type from drop down menu
     */
    public void selectInsideWallInstallationType() {
        select(installationTypeInside, 20, propertyFile.getInstallationType());
    }

    /**
     * Selects Installation type from drop down menu
     */
    public void selectOuterWallInstallationType() {
        select(installationTypeOuter, 20, propertyFile.getInstallationType());
    }

    /**
     * Selects Wall type from drop down menu
     */
    public void selectInsideWallType() {
        select(wallTypeInside, 20, propertyFile.getWallTypeInside());
    }

    /**
     * Selects Walltype from drop down menu
     */
    public void selectOuterWallType() {
        select(wallTypeOuter, 20, propertyFile.getWallTypeOuter());
    }

    /**
     * Selects FireResistancetype from drop down menu
     */
    public void selectInsideWallFireResistanceType() {
        select(fireResistanceTypeInside, 20, propertyFile.getFireResistanceType());
    }

    /**
     * Selects FireResistancetype from drop down menu
     */
    public void selectOuterWallFireResistanceType() {
        select(fireResistanceTypeOuter, 40, propertyFile.getFireResistanceType());

    }

    /**
     * Clicks on Save Button
     */
    public void clickOnSaveInsideWall() {
        click(saveInsideWall, 20);
    }

    /**
     * Clicks on Save Button
     */
    public void clickOnSaveOuterWall() {
        click(saveOuterWall, 20);
    }

    /**
     * Clicks on Abort Button
     */
    public void abortInsideWall() {
        click(abortInsideWall, 20);
    }

    /**
     * Clicks on Abort Button
     */
    public void abortOuterWall() {
        click(abortOuterWall, 20);
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerUpButtonForWallThicknessInsideWall() {
        spinner(WallThicknessSpinnerUpButtonInsideWall, 3, 20);
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerUpButtonForWallThicknessOutsideWall() {
        spinner(WallThicknessSpinnerUpButtonOutsideWall, 3, 20);
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerDownButtonForUValueOutsideWall() {
        spinner(UValueSpinnerDownButtonOutsideWall, 2, 20);
    }

    /**
     * Checks spinner max value
     */
    public void checkSpinnerMaxValue() {
        spinnerMaxValue(spinnerInputFieldWallThicknessInsideWall, propertyFile.getSpinnerMaxValueToCheck(), 20);
    }

    /**
     * Checks spinner min value
     */
    public void checkSpinnerMinValue() {
        spinnerMinValue(spinnerInputFieldWallThicknessInsideWall, propertyFile.getSpinnerMinValueToCheck(), 20);
    }

    /**
     * Gets entered Wall name
     *
     * @return wall name
     */
    public String getValueFromInputFieldInsideWallName() {
        return getValueFromInputField(wallNameInside);
    }

    /**
     * Gets entered Wall name
     *
     * @return wall name
     */
    public String getValueFromInputFieldOuterWallName() {
        return getValueFromInputField(wallNameOuter);
    }

    /**
     * Gets value from Masonry type
     *
     * @return MasonryType
     */
    public String getValueFromSelectMasonryInsideWallType() {
        return getValueFromDropDownMenu(masonryTypeInside);

    }

    /**
     * Gets value from Masonry type
     *
     * @return MasonryType
     */
    public String getValueFromSelectMasonryOuterWallType() {
        return getValueFromDropDownMenu(masonryTypeOuter);
    }

    /**
     * Gets value from Installation type
     *
     * @return Installation type
     */
    public String getValueFromSelectInstallationInsideWallType() {
        return getValueFromDropDownMenu(installationTypeInside);
    }

    /**
     * Gets value from Installation type
     *
     * @return Installation type
     */
    public String getValueFromSelectInstallationOuterWallType() {
        return getValueFromDropDownMenu(installationTypeOuter);
    }

    /**
     * Gets value form Wall type
     *
     * @return Wall type
     */
    public String getValueFromSelectInsideWallType() {
        return getValueFromDropDownMenu(wallTypeInside);
    }

    /**
     * Gets value from Wall type
     *
     * @return Wall type
     */
    public String getValueFromSelectOuterWallType() {
        return getValueFromDropDownMenu(wallTypeOuter);
    }

    /**
     * Gets value FireResistancetype
     *
     * @return FireResistancetype
     */
    public String getValueFromSelecteFireResistanceInsideWallType() {
        return getValueFromDropDownMenu(fireResistanceTypeInside);
    }

    /**
     * Gets value FireResistancetype
     *
     * @return FireResistancetype
     */
    public String getValueFromSelecteFireResistanceOuterWallType() {
        return getValueFromDropDownMenu(fireResistanceTypeOuter);
    }

    /**
     * Gets value From spinner input
     *
     * @return value
     */
    public String getValueFromSpinnerForWallThicknessInsideWall() {
        return getValueFromInputField(spinnerInputFieldWallThicknessInsideWall);
    }

    /**
     * Gets value From spinner input
     *
     * @return value
     */
    public String getValueFromSpinnerForWallThicknessOutsideWall() {
        return getValueFromInputField(spinnerInputFieldWallThicknessOutsideWall);
    }

    /**
     * Gets value From spinner input
     *
     * @return value
     */
    public String getValueFromSpinnerForWallUValueOutsideWall() {
        return getValueFromInputField(spinnerInputFieldWallUValueOutsideWall);
    }

    /**
     * Creates Wall and abort changes
     *
     */
    public void createInsideWallAndAbortIt() {
        setInsideWallName();
        selectInsideWallMasonryType();
        selectInsideWallInstallationType();
        selectInsideWallType();
        clickOnSpinnerUpButtonForWallThicknessInsideWall();
        selectInsideWallFireResistanceType();
        abortInsideWall();
    }

    /**
     * Creates Wall and Save changes
     *
     */
    public void createInsideWallAndSaveIt() {
        setInsideWallName();
        selectInsideWallMasonryType();
        selectInsideWallInstallationType();
        selectInsideWallType();
        clickOnSpinnerUpButtonForWallThicknessInsideWall();
        selectInsideWallFireResistanceType();
        clickOnSaveInsideWall();
    }

    /**
     * Creates Wall and abort changes
     *
     */
    public void createOuterWallAndAbortIt() {
        setOuterWallName();
        selectOuterWallMasonryType();
        selectOuterWallInstallationType();
        selectOuterWallType();
        clickOnSpinnerUpButtonForWallThicknessOutsideWall();
        clickOnSpinnerDownButtonForUValueOutsideWall();
        selectOuterWallFireResistanceType();
        abortOuterWall();
    }

    /**
     * Creates Wall and Save changes
     *
     */
    public void createOuterWallAndSaveIt() {
        setOuterWallName();
        selectOuterWallMasonryType();
        selectOuterWallInstallationType();
        selectOuterWallType();
        clickOnSpinnerUpButtonForWallThicknessOutsideWall();
        clickOnSpinnerDownButtonForUValueOutsideWall();
        selectOuterWallFireResistanceType();
        clickOnSaveOuterWall();
    }

    /**
     * Verifies max value
     */
    public void checkMaxValueForSpinner() {
        checkSpinnerMaxValue();
        clickOnSaveInsideWall();
        clickOnCreatedInsideWall();
    }

    /**
     * Verifies max value
     */
    public void checkMinValueForSpinner() {
        checkSpinnerMinValue();
        clickOnSaveInsideWall();
        clickOnCreatedInsideWall();
    }

}
