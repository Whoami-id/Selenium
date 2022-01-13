
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateWall {
    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    // Finds correct element
    @FindBy(id = "newWall")
    WebElement crateType;

    @FindBy(className = "itemDescription")
    WebElement newWall;

    @FindBy(id = "wallName")
    WebElement wallName;

    @FindBy(id = "masonryType")
    WebElement masonryType;

    @FindBy(id = "installationType")
    WebElement installationType;

    @FindBy(id = "wallType")
    WebElement wallType;

    @FindBy(id = "fireResistanceType")
    WebElement fireResistanceType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    /**
     * Constructor form CreateWall Class
     *
     * @param driver
     */
    public CreateWall(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on create new Wall Button
     */
    public void clickOnCreateWallType() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(crateType))
                .click();
    }

    /**
     * Clicks on created Wall
     */
    public void clickOnCreatedWall() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(newWall))
                .click();
    }

    /**
     * Writes Wallname in input field
     */
    public void setWallName() {
        final WebElement nameOfWall = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(wallName));
        nameOfWall.clear();
        nameOfWall.sendKeys(propertyFile.getWallName());
    }

    /**
     * Selects Masonrytype form drop down menu
     */
    public void selectMasonryType() {
        final WebElement masonryTypeSelected = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(masonryType));
        final Select select = new Select(masonryTypeSelected);
        select.selectByVisibleText(propertyFile.getMasonryType());
    }

    /**
     * Selects Installationtype from drop down menu
     */
    public void selectInstallationType() {
        final WebElement installationTypeSelected = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(installationType));
        final Select select = new Select(installationTypeSelected);
        select.selectByVisibleText(propertyFile.getInstallationType());
    }

    /**
     * Selects Walltype from drop down menu
     */
    public void selectWallType() {
        final WebElement wallTypeSelected = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(wallType));
        final Select select = new Select(wallTypeSelected);
        select.selectByVisibleText(propertyFile.getWallType());
    }

    /**
     * Selects FireResistancetype from drop down menu
     */
    public void selectFireResistanceType() {
        final WebElement fireResistanceTypeSeletced = new WebDriverWait(driver, Duration.ofSeconds(70))
                .until(ExpectedConditions.elementToBeClickable(fireResistanceType));
        final Select select = new Select(fireResistanceTypeSeletced);
        select.selectByVisibleText(propertyFile.getFireResistanceType());
    }

    /**
     * Clicks on Save Button
     */
    public void clickOnSaveChanges() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(save)).click();
    }

    /**
     * Clicks on Delete Button
     */
    public void clickOndeleteWall() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(delete))
                .click();
    }

    /**
     * Clicks on Abort Button
     */
    public void abortChanges() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(abortChanges))
                .click();
    }

    /**
     * Creates Wall and abort changes
     *
     * @throws InterruptedException
     */
    public void createWallAndAbortIt() throws InterruptedException {
        Thread.sleep(1000);
        setWallName();
        Thread.sleep(1000);
        selectMasonryType();
        Thread.sleep(1000);
        selectInstallationType();
        Thread.sleep(1000);
        selectWallType();
        Thread.sleep(1000);
        selectFireResistanceType();
        Thread.sleep(1000);
        abortChanges();
        Thread.sleep(1000);
    }

    /**
     * Creates Wall and Save changes
     *
     * @throws InterruptedException
     */
    public void createWallAndSaveIt() throws InterruptedException {
        setWallName();
        Thread.sleep(1000);
        selectMasonryType();
        Thread.sleep(1000);
        selectInstallationType();
        Thread.sleep(1000);
        selectWallType();
        Thread.sleep(1000);
        selectFireResistanceType();
        Thread.sleep(1000);
        clickOnSaveChanges();
        Thread.sleep(1000);
    }

    /**
     * Gets entered Wallname
     *
     * @return wallname
     */
    public String getValueFromInputFieldWallName() {
        return wallName.getAttribute("value");
    }

    /**
     * Gets value from Masonrytype
     *
     * @return MasonryType
     */
    public String getValueFromSelectMasonryType() {
        final WebElement masonryTypeSelected = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(masonryType));
        return new Select(masonryTypeSelected).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value from Installationtype
     *
     * @return Installationtype
     */
    public String getValueFromSelectInstallationType() {
        final WebElement installationTypeSelected = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(installationType));
        return new Select(installationTypeSelected).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value form Walltype
     *
     * @return Walltype
     */
    public String getValueFromSelectWallType() {
        final WebElement wallTypeSelected = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(wallType));
        return new Select(wallTypeSelected).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value FireResistancetype
     *
     * @return FireResistancetype
     */
    public String getValueFromSelecteFireResistanceType() {
        final WebElement fireResistanceTypeSeletced = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(fireResistanceType));
        return new Select(fireResistanceTypeSeletced).getFirstSelectedOption().getText().trim();
    }

}
