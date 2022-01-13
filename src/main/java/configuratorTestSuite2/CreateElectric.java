
package configuratorTestSuite2;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

public class CreateElectric extends Base {
    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='template/electrics']")
    private WebElement electricIcon;

    @FindBy(xpath = "//span[@id='newElectric']")
    private WebElement createNewElectricType;

    @FindBy(xpath = "//div[@class='itemDescription']")
    private WebElement newElectric;

    @FindBy(id = "electricname")
    private WebElement electricName;

    @FindBy(xpath = "//select[@id='electrics-execution-type']")
    private WebElement electricsExecutionType;

    @FindBy(id = "electrics-orientation-type")
    private WebElement electricsOrientationType;

    @FindBy(id = "electrics-manufacturer")
    private WebElement electricsManufacturer;

    @FindBy(id = "electrics-frame-range-type")
    private WebElement electricsFrameRangeType;

    @FindBy(id = "electrics-frame-model-type")
    private WebElement electricsFrameModelType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    @FindBy(xpath = "//span[@data-index='1']")
    private WebElement emptyIconOne;

    @FindBy(xpath = "//span[@data-index='2']")
    private WebElement emptyIconTwo;

    @FindBy(xpath = "//span[@data-index='3']")
    private WebElement emptyIconThree;

    @FindBy(xpath = "//select[@id='application']")
    private WebElement application;

    @FindBy(xpath = "//select[@id='execution']")
    private WebElement execution;

    @FindBy(id = "application-model")
    private WebElement applicationModel;

    @FindBy(xpath = "//select[@id='switchable']")
    private WebElement switchable;

    @FindBy(id = "separateCircuit")
    private WebElement separateCircuit;

    @FindBy(id = "connectionType")
    private WebElement connectionType;

    @FindBy(xpath = "//div[@class='slotconfig']//*[@class='button triple right green']")
    private WebElement saveCommitment;

    @FindBy(xpath = "//div[@class='slotconfig']//*[@class='button triple center yellow']")
    private WebElement abortCommitment;

    /**
     * Constructor
     *
     * @param driver
     */
    public CreateElectric(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on electric icon
     */
    public void clickOnElectricIcon() {
        click(electricIcon, 20);
    }

    /**
     * Clicks on create new type
     */
    public void clickOnCreateNewType() {
        click(createNewElectricType, 20);
    }

    /**
     * Creates on created type
     */
    public void clickOnCreatedElectric() {
        click(newElectric, 40);
    }

    /**
     * Sets electric name
     */
    public void setElectricName() {
        type(electricName, 20, propertyFile.getElectricName());

    }

    /**
     * Selects electrics execution type
     */
    public void selectElectricsExecutionType() {
        select(electricsExecutionType, 20, propertyFile.getElectricExecutionType());
    }

    /**
     * Selects electrics orientation type
     */
    public void selectElectricsOrientationType() {
        select(electricsOrientationType, 20, propertyFile.getElectricOrientationType());
    }

    /**
     * Selects electrics ,manufacturer
     */
    public void selectElectricsManufacturer() {
        select(electricsManufacturer, 40, propertyFile.getElectricManufacturer());
    }

    /**
     * Selects electrics frame range type
     */
    public void selectElectricsFrameRangeType() {
        select(electricsFrameRangeType, 20, propertyFile.getElectricFrameRangeType());
    }

    /**
     * Selects electrics frame model type
     */
    public void selectElectricsFrameModelType() {
        select(electricsFrameModelType, 20, propertyFile.getElectricFrameModelType());
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
     * Gets electric name
     *
     * @return electric name
     */
    public String getValueFormInputFieldName() {
        return getValueFromInputField(electricName);
    }

    /**
     * Gets electric Execution type
     *
     * @return electric Execution type
     */
    public String getValueFromSelectExecutionType() {
        return getValueFromDropDownMenu(electricsExecutionType);
    }

    /**
     * Gets electric Orientation type
     *
     * @return electric orientation type
     */
    public String getValueFromSelectOrientationType() {
        return getValueFromDropDownMenu(electricsOrientationType);
    }

    /**
     * Gets electric Manufacturer
     *
     * @return electric manufacturer
     */
    public String getValueFromSelectManufacturer() {
        return getValueFromDropDownMenu(electricsManufacturer);
    }

    /**
     * Gets electric Fram Range Type
     *
     * @return electric Fram Range Type
     */
    public String getValueFromSelectFramRangeType() {
        return getValueFromDropDownMenu(electricsFrameRangeType);
    }

    /**
     * Gets electric Fram Model Type
     *
     * @return electric Fram Model Type
     */
    public String getValueFromSelectFramModelType() {
        return getValueFromDropDownMenu(electricsFrameModelType);
    }

    /**
     * Clicks on icon one
     */
    public void clickOnemptyIconOne() {
        click(emptyIconOne, 30);
    }

    /**
     * Clicks on icon two
     */
    public void clickOnemptyIconTwo() {
        click(emptyIconTwo, 30);
    }

    /**
     * Clicks on icon three
     */
    public void clickOnemptyIconThree() {
        click(emptyIconThree, 30);
    }

    /**
     * Selects Socket Application
     */
    public void selectApplication() {
        select(application, 20, propertyFile.getSocketApplication());
    }

    /**
     * Selects socket one Execution
     */
    public void selectSocketOneExecution() {
        select(execution, 20, propertyFile.getSocketOneExecution());
    }

    /**
     * Selects socket Two Execution
     */
    public void selectSocketTwoExecution() {
        select(execution, 20, propertyFile.getSocketTwoExecution());
    }

    /**
     * Selects Socket Application model
     */
    public void selectApplicationModel() {
        select(applicationModel, 20, propertyFile.getSocketApplicationModel());
    }

    /**
     * Selects Socket Switchable
     */
    public void selectSwitchable() {
        select(switchable, 20, propertyFile.getSocketSwitchable());
    }

    /**
     * Selects Socket SeparatCircuit
     */
    public void selectSeparateCircuit() {
        select(separateCircuit, 20, propertyFile.getSocketSeparateCircuit());
    }

    /**
     * Selects Socket connection
     */
    public void selectConnectionType() {
        select(connectionType, 20, propertyFile.getSocketConnectionType());
    }

    /**
     * Clicks on save Commitment
     */
    public void clickOnSaveCommitment() {
        click(saveCommitment, 30);
    }

    /**
     * Clicks on abort commitment
     */
    public void clickOnAbortCommitment() {
        click(abortCommitment, 30);
    }

    /**
     * Gets Application
     *
     * @return Application
     */
    public String getValueFromSelectApplication() {
        return getValueFromDropDownMenu(application);
    }

    /**
     * Gets Socket one Execution
     *
     * @return Execution
     */
    public String getValueFromSelectSocketOneExecution() {
        return getValueFromDropDownMenu(execution);
    }

    /**
     * Gets Socket two Execution
     *
     * @return Execution
     */
    public String getValueFromSelectSocketTwoExecution() {
        return getValueFromDropDownMenu(execution);
    }

    /**
     * Gets Application Model
     *
     * @return Application Model
     */
    public String getValueFromSelectApplicationModel() {
        return getValueFromDropDownMenu(applicationModel);
    }

    /**
     * Gets Switchable
     *
     * @return switchable
     */
    public String getValueFromSelectSwitchable() {
        return getValueFromDropDownMenu(switchable);
    }

    /**
     * Gets separateCircuite
     *
     * @return separateCircuite
     */
    public String getValueFromSelectSeparateCircuit() {
        return getValueFromDropDownMenu(separateCircuit);
    }

    /**
     * Gets Connection
     *
     * @return Connection
     */
    public String getValueFromSelectConnection() {
        return getValueFromDropDownMenu(connectionType);
    }

    /**
     * Creates Electric and abort
     */
    public void createElectricAndAbort() {
        setElectricName();
        selectElectricsExecutionType();
        selectElectricsOrientationType();
        selectElectricsManufacturer();
        selectElectricsFrameRangeType();
        selectElectricsFrameModelType();
        clickOnAbortChanges();

    }

    /**
     * Creates Electric and save
     */
    public void createElectricAndSave() {
        setElectricName();
        selectElectricsExecutionType();
        selectElectricsOrientationType();
        selectElectricsManufacturer();
        selectElectricsFrameRangeType();
        selectElectricsFrameModelType();
        clickOnSaveChanges();
    }

    /**
     * Creates Socket one and abort
     */
    public void createSocketOneAndAbort() {
        selectApplication();
        selectSocketOneExecution();
        selectApplicationModel();
        selectSwitchable();
        selectSeparateCircuit();
        selectConnectionType();
        clickOnAbortCommitment();
    }

    /**
     * Creates Socket one and save
     */
    public void createSocketOneAndSave() {
        selectApplication();
        selectSocketOneExecution();
        selectApplicationModel();
        selectSwitchable();
        selectSeparateCircuit();
        selectConnectionType();
        clickOnSaveCommitment();
    }

    /**
     * Creates Socket two and three and abort
     */
    public void createSocketTwoAndAbort() {
        selectApplication();
        selectSocketTwoExecution();
        selectApplicationModel();
        selectSwitchable();
        selectSeparateCircuit();
        selectConnectionType();
        clickOnAbortCommitment();
    }

    /**
     * Creates Socket two and three and save
     */
    public void createSocketTwoAndSave() {
        selectApplication();
        selectSocketTwoExecution();
        selectApplicationModel();
        selectSwitchable();
        selectSeparateCircuit();
        selectConnectionType();
        clickOnSaveCommitment();
    }

    /**
     * Checks if page is loaded
     */
    public boolean waitUntilPageIsLoaded() {
        final FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5));
        final Function<WebDriver, Boolean> function = driver -> {
            final boolean pageIsLoaded = ((JavascriptExecutor) driver).executeScript("return document.readyState")
                    .equals("complete");
            if (pageIsLoaded == true) {
                return true;
            }
            return false;
        };
        return wait.until(function);
    }

}
