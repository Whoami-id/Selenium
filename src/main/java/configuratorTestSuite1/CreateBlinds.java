
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateBlinds {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    // Finds Correct element
    @FindBy(xpath = "//li[@data-target='template/blinds']")
    WebElement windowsIcon;

    @FindBy(id = "newBlind")
    WebElement createType;

    @FindBy(className = "itemDescription")
    WebElement newBlind;

    @FindBy(id = "blindname")
    WebElement blindName;

    @FindBy(id = "shading-type")
    WebElement shadingType;

    @FindBy(className = "checkbox-span")
    WebElement switchable;

    @FindBy(id = "shading-color-type")
    WebElement shadingColorType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    /**
     * Constructor from Blinds Class
     *
     * @param driver
     */
    public CreateBlinds(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on Blindicon
     */
    public void clickOnBlindIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(windowsIcon))
                .click();
    }

    /**
     * Clicks on create new Blind
     */
    public void clickOnCreateNewType() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(createType))
                .click();
    }

    /**
     * Clicks on created Blind
     */
    public void clickOnCreatedBlind() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(newBlind))
                .click();
    }

    /**
     * Write BlindName in input field
     */
    public void setBlindName() {
        final WebElement nameOfBlind = new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(blindName));
        nameOfBlind.clear();
        nameOfBlind.sendKeys(propertyFile.getBlindName());
    }

    /**
     * Selects shadingtype from drop down menu
     */
    public void selectShadingType() {
        final WebElement TypeOfShading = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(shadingType));
        final Select select = new Select(TypeOfShading);
        select.selectByVisibleText(propertyFile.getShadingType());
    }

    /**
     * Clicks on Switchable
     */
    public void clickOnSwitchable() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(switchable))
                .click();
    }

    /**
     * Selects shadingColortype
     */
    public void selectShadingColorType() {
        final WebElement TypeOfShadingColor = new WebDriverWait(driver, Duration.ofSeconds(70))
                .until(ExpectedConditions.elementToBeClickable(shadingColorType));
        final Select select = new Select(TypeOfShadingColor);
        select.selectByVisibleText(propertyFile.getShadingColor());
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
    public void clickOnDeleteBlind() {
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
     * Gets value from Blindname
     *
     * @return Blindname
     */
    public String getValueFromInputFieldBlindsName() {
        return blindName.getAttribute("value");
    }

    /**
     * Gets value from shadingtype
     *
     * @return shadingtype
     */
    public String getValeuFromSelectShadingType() {

        final WebElement typeOfShading = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(shadingType));
        return new Select(typeOfShading).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value from shadingcolor
     *
     * @return shadingcolor
     */
    public String getValueFromSelectColor() {
        final WebElement TypeOfShadingColor = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(shadingColorType));
        return new Select(TypeOfShadingColor).getFirstSelectedOption().getText().trim();
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
