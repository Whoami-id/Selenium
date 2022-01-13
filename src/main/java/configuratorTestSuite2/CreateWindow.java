
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateWindow extends Base {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='template/windows']")
    private WebElement windowsIcon;

    @FindBy(id = "newWindow")
    private WebElement createType;

    @FindBy(xpath = "//div[@class='itemDescription']")
    private WebElement newWindow;

    @FindBy(id = "windowname")
    private WebElement windowName;

    @FindBy(xpath = "//select[@id='window-opening-type']")
    private WebElement windowOpeningType;

    @FindBy(id = "glazing-type")
    private WebElement glazingType;

    @FindBy(id = "window-contact")
    private WebElement windowContactNo;

    @FindBy(id = "window-contact")
    private WebElement windowContactJa;

    @FindBy(id = "window-control-type")
    private WebElement windowControlType;

    @FindBy(id = "window-open-detection-type")
    private WebElement windowOpenDetectionType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abortChanges;

    @FindBy(xpath = "//div[@class='spinner input double left']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerWidthUpButton;

    @FindBy(xpath = "//div[@class='spinner input double right']//div[@class='spinner-up spinner-button']")
    private WebElement spinnerHeightUpButton;

    @FindBy(xpath = "//div[@class='spinner input']//div[@class='spinner-down spinner-button']")
    private WebElement spinnerUValueDownButton;

    @FindBy(xpath = "//input[@id='spinner-window-width']")
    private WebElement inputFieldSpinnerWidth;

    @FindBy(xpath = "//input[@id='spinner-window-height']")
    private WebElement inputFieldSpinnerHeight;

    @FindBy(xpath = "//input[@id='spinner-window-uvalue']")
    private WebElement inputFieldSpinnerUValue;

    /**
     * Constructor the Class
     *
     * @param driver
     */
    public CreateWindow(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on Window icon
     */
    public void clickOnWindowIcon() {
        click(windowsIcon, 20);
    }

    /**
     * Clicks on create new Window
     */
    public void clickOnCreateWindowType() {
        click(createType, 20);
    }

    /**
     * Clicks on created Window
     */
    public void clickOnCreatedWindow() {
        click(newWindow, 20);
    }

    /**
     * Writes Window name in input field
     */
    public void setWindowName() {
        type(windowName, 20, propertyFile.getWindowName());
    }

    /**
     * Selects Window type from drop down menu
     */
    public void selectWindowType() {
        select(windowOpeningType, 20, propertyFile.getWindowType());
    }

    /**
     * Selects Glazing type form drop down menu
     */
    public void selectGalazinType() {
        select(glazingType, 20, propertyFile.getWindowGlazinType());
    }

    /**
     * Selects WindowContact form drop down menu
     */
    public void selectWindowContactNo() {
        select(windowContactNo, 20, propertyFile.getWindowContactNo());
    }

    /**
     * Selects WindowControtype
     */
    public void selectWindowControlType() {
        select(windowControlType, 20, propertyFile.getWindowControlType());
    }

    /**
     * Selects WindowOpeningDetectiontype
     */
    public void selectWindowOpenDetectionType() {
        select(windowOpenDetectionType, 20, propertyFile.getWindowOpenDetectionType());
    }

    /**
     * Clicks on Save Button
     */
    public void clickOnSave() {
        click(save, 20);
    }

    /**
     * Clicks on Abort Button
     */
    public void clickOnAbort() {
        click(abortChanges, 20);
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerWidthUpButton() {
        spinner(spinnerWidthUpButton, 3, 20);
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerHeightUpButton() {
        spinner(spinnerHeightUpButton, 4, 20);
    }

    /**
     * Clicks on spinner
     */
    public void clickOnSpinnerUValueDownButton() {
        spinner(spinnerUValueDownButton, 3, 20);
    }

    /**
     * Gets value form Window name
     *
     * @return Window name
     */
    public String getValueFromInputFieldWindowName() {
        return getValueFromInputField(windowName);
    }

    /**
     * Gets value form WindowOpeningtype
     *
     * @return WindowOpeningtype
     */
    public String getValueFeomSelecteWindowOpeningType() {
        return getValueFromDropDownMenu(windowOpeningType);
    }

    /**
     * Gets value from Glazing type
     *
     * @return Glazing type
     */
    public String getValueFromSelecteGlazingType() {
        return getValueFromDropDownMenu(glazingType);
    }

    /**
     * Gets value from WindowContact
     *
     * @return WindowConatact
     */
    public String getValueFromSelecteWindowContactNo() {
        return getValueFromDropDownMenu(windowContactNo);
    }

    /**
     * Gets value form WindowControltyep
     *
     * @return WindwoControltyep
     */
    public String getValueFromSelecteWindowControlType() {
        return getValueFromDropDownMenu(windowControlType);
    }

    /**
     * Gets Value from spinner width
     *
     * @return value
     */
    public String getValueFromSpinnerWidth() {
        return getValueFromInputField(inputFieldSpinnerWidth);
    }

    /**
     * Gets Value from spinner lenght
     *
     * @return value
     */
    public String getValueFromSpinnerHeight() {
        return getValueFromInputField(inputFieldSpinnerHeight);
    }

    /**
     * Gets Value from spinner u-value
     *
     * @return value
     */
    public String getValueFromSpinnerUValue() {
        return getValueFromInputField(inputFieldSpinnerUValue);
    }

    /**
     * Creates Window and abort Changes
     *
     * @throws InterruptedException
     */
    public void createWindowAndAbort() {
        setWindowName();
        selectWindowType();
        clickOnSpinnerWidthUpButton();
        clickOnSpinnerHeightUpButton();
        selectGalazinType();
        selectWindowContactNo();
        selectWindowControlType();
        clickOnSpinnerUValueDownButton();
        clickOnAbort();
    }

    /**
     * Creates Window and save changes
     *
     * @throws InterruptedException
     */
    public void createWindowAndSave() {
        setWindowName();
        selectWindowType();
        clickOnSpinnerWidthUpButton();
        clickOnSpinnerHeightUpButton();
        selectGalazinType();
        selectWindowContactNo();
        selectWindowControlType();
        clickOnSpinnerUValueDownButton();
        clickOnSave();
    }

}
