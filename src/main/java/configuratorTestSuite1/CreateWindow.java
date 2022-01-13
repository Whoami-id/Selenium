
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateWindow {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    // Finds correct element
    @FindBy(xpath = "//li[@data-target='template/windows']")
    WebElement windowsIcon;

    @FindBy(id = "newWindow")
    WebElement createType;

    @FindBy(className = "itemDescription")
    WebElement newWindow;

    @FindBy(id = "windowname")
    WebElement windowName;

    @FindBy(id = "window-opening-type")
    WebElement windowOpeningType;

    @FindBy(id = "glazing-type")
    WebElement glazingType;

    @FindBy(id = "window-contact")
    WebElement windowContactNo;

    @FindBy(id = "window-contact")
    WebElement windowContactJa;

    @FindBy(id = "window-control-type")
    WebElement windowControlType;

    @FindBy(id = "window-open-detection-type")
    WebElement windowOpenDetectionType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    /**
     * Constructor form CreateWindow Class
     *
     * @param driver
     */
    public CreateWindow(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on Windowicon
     */
    public void clickOnWindowIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(windowsIcon))
                .click();
    }

    /**
     * Clicks on create new Window
     */
    public void clickOnCreateWindowType() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(createType))
                .click();
    }

    /**
     * Clicks on created Window
     */
    public void clickOnCreatedWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(newWindow))
                .click();
    }

    /**
     * Writes Windowname in input field
     */
    public void setWindowName() {
        final WebElement nameOfWindow = new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(windowName));
        nameOfWindow.clear();
        nameOfWindow.sendKeys(propertyFile.getWindowName());
    }

    /**
     * Selects Windowtype from drop down menu
     */
    public void selectWindowType() {
        final WebElement TypeOfWindow = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(windowOpeningType));
        final Select select = new Select(TypeOfWindow);
        select.selectByVisibleText(propertyFile.getWindowType());
    }

    /**
     * Selects Galzingtype form drop down menu
     */
    public void selectGalazinType() {
        final WebElement TypeOfGlazinWindow = new WebDriverWait(driver, Duration.ofSeconds(200))
                .until(ExpectedConditions.visibilityOf(glazingType));
        final Select select = new Select(TypeOfGlazinWindow);
        select.selectByVisibleText(propertyFile.getWindowGlazinType());
    }

    /**
     * Selects WindowContact form drop down menu
     */
    public void selectWindowContactNo() {
        final WebElement TypeOfWindowContactNo = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(windowContactNo));
        final Select select = new Select(TypeOfWindowContactNo);
        select.selectByVisibleText(propertyFile.getWindowContactNo());
    }

    /**
     * Selects WindowControtype
     */
    public void selectWindowControlType() {
        final WebElement TypeOfWindowControl = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(windowControlType));
        final Select select = new Select(TypeOfWindowControl);
        select.selectByVisibleText(propertyFile.getWindowControlType());
    }

    /**
     * Selects WindowOpeningDetectiontype
     */
    public void selectWindowOpenDetectionType() {
        final WebElement TypeOfWindowDetection = new WebDriverWait(driver, Duration.ofSeconds(70))
                .until(ExpectedConditions.elementToBeClickable(windowOpenDetectionType));
        final Select select = new Select(TypeOfWindowDetection);
        select.selectByVisibleText(propertyFile.getWindowOpenDetectionType());
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
    public void clickOndeleteWall() {
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
     * Creates Window and abort Changes
     *
     * @throws InterruptedException
     */
    public void createWindowAndAbort() throws InterruptedException {
        Thread.sleep(1000);
        setWindowName();
        Thread.sleep(1000);
        selectWindowType();
        Thread.sleep(1000);
        selectGalazinType();
        Thread.sleep(1000);
        selectWindowContactNo();
        Thread.sleep(1000);
        selectWindowControlType();
        Thread.sleep(1000);
        clickOnAbortChanges();
        Thread.sleep(1000);
    }

    /**
     * Creates Window and save changes
     *
     * @throws InterruptedException
     */
    public void createWindowAndSave() throws InterruptedException {
        setWindowName();
        Thread.sleep(1000);
        selectWindowType();
        Thread.sleep(1000);
        selectGalazinType();
        Thread.sleep(1000);
        selectWindowContactNo();
        Thread.sleep(1000);
        selectWindowControlType();
        Thread.sleep(1000);
        clickOnSaveChanges();
        Thread.sleep(1000);
    }

    /**
     * Gets value form Windowname
     *
     * @return Windowname
     */
    public String getValueFromInputFieldWindowName() {
        return windowName.getAttribute("value");
    }

    /**
     * Gets value form WindowOpeningtype
     *
     * @return WindowOpeningtype
     */
    public String getValueFeomSelecteWindowOpeningType() {
        final WebElement TypeOfWindow = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(windowOpeningType));
        return new Select(TypeOfWindow).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value from Glazingtype
     *
     * @return Glazingtype
     */
    public String getValueFromSelecteGlazingType() {
        final WebElement TypeOfGlazinWindow = new WebDriverWait(driver, Duration.ofSeconds(200))
                .until(ExpectedConditions.visibilityOf(glazingType));
        return new Select(TypeOfGlazinWindow).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value from WindowContact
     *
     * @return WindowConatact
     */
    public String getValueFromSelecteWindowContactNo() {
        final WebElement TypeOfWindowContactNo = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(windowContactNo));
        return new Select(TypeOfWindowContactNo).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value form WindowControltyep
     *
     * @return WindwoControltyep
     */
    public String getValueFromSelecteWindowControlType() {
        final WebElement TypeOfWindowControl = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.elementToBeClickable(windowControlType));
        return new Select(TypeOfWindowControl).getFirstSelectedOption().getText().trim();
    }

}
