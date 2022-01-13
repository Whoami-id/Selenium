
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateElectric {
    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    // Finds correct element
    @FindBy(xpath = "//li[@data-target='template/electrics']")
    WebElement electricIcon;

    @FindBy(id = "newElectric")
    WebElement createNewElectricType;

    @FindBy(className = "itemDescription")
    WebElement newElectric;

    @FindBy(id = "electricname")
    WebElement electricName;

    @FindBy(id = "electrics-execution-type")
    WebElement electricsExecutionType;

    @FindBy(id = "electrics-orientation-type")
    WebElement electricsOrientationType;

    @FindBy(id = "electrics-manufacturer")
    WebElement electricsManufacturer;

    @FindBy(id = "electrics-frame-range-type")
    WebElement electricsFrameRangeType;

    @FindBy(id = "electrics-frame-model-type")
    WebElement electricsFrameModelType;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    @FindBy(xpath = "//span[@data-index='1']")
    WebElement emptyIconOne;

    @FindBy(xpath = "//span[@data-index='2']")
    WebElement emptyIconTwo;

    @FindBy(xpath = "//span[@data-index='3']")
    WebElement emptyIconThree;

    @FindBy(id = "application")
    WebElement application;

    @FindBy(id = "execution")
    WebElement execution;

    @FindBy(id = "application-model")
    WebElement applicationModel;

    @FindBy(id = "switchable")
    WebElement switchable;

    @FindBy(id = "separateCircuit")
    WebElement separateCircuit;

    @FindBy(id = "connectionType")
    WebElement connectionType;

    /**
     * Constructor
     *
     * @param driver
     */
    public CreateElectric(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on electric icon
     */
    public void clickOnElectricIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(electricIcon))
                .click();
    }

    /**
     * Clicks on create new type
     */
    public void clickOnCreateNewType() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(createNewElectricType)).click();
    }

    /**
     * Creates on created type
     */
    public void clickOnCreatedElectric() {
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(newElectric))
                .click();
    }

    /**
     * Sets electric name
     */
    public void setElectricName() {
        final WebElement name = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(electricName));
        name.clear();
        name.sendKeys(propertyFile.getElectricName());

    }

    /**
     * Selects electrics execution type
     */
    public void selectElectricsExecutionType() {
        final WebElement executionType = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricsExecutionType));
        final Select select = new Select(executionType);
        select.selectByVisibleText(propertyFile.getElectricExecutionType());
    }

    /**
     * Selects electrics orientation type
     */
    public void selectElectricsOrientationType() {
        final WebElement orientationType = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricsOrientationType));
        final Select select = new Select(orientationType);
        select.selectByVisibleText(propertyFile.getElectricOrientationType());
    }

    /**
     * Selects electrics ,manufacturer
     */
    public void selectElectricsManufacturer() {
        final WebElement manufacturer = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricsManufacturer));
        final Select select = new Select(manufacturer);
        select.selectByVisibleText(propertyFile.getElectricManufacturer());
    }

    /**
     * Selects electrics frame range type
     */
    public void selectElectricsFrameRangeType() {
        final WebElement frameRangeType = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricsFrameRangeType));
        final Select select = new Select(frameRangeType);
        select.selectByVisibleText(propertyFile.getElectricFrameRangeType());
    }

    /**
     * Selects electrics frame model type
     */
    public void selectElectricsFrameModelType() {
        final WebElement frameModel = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricsFrameModelType));
        final Select select = new Select(frameModel);
        select.selectByVisibleText(propertyFile.getElectricFrameModelType());
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
    public void clickOnDelete() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(delete))
                .click();
    }

    /**
     * Clicks on Abort Button
     */
    public void clickOnAbortChanges() {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(abortChanges))
                .click();
    }

    /**
     * Gets electric name
     *
     * @return electric name
     */
    public String getValueFormInputFieldName() {
        return electricName.getAttribute("value");
    }

    /**
     * Gets electric Execution type
     *
     * @return electric Execution type
     */
    public String getValueFromSelectExecutionType() {
        final WebElement executionType = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricsExecutionType));
        return new Select(executionType).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets electric Orientation type
     *
     * @return electric orientation type
     */
    public String getValueFromSelectOrientationType() {
        final WebElement orientationType = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricsOrientationType));
        return new Select(orientationType).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets electric Manufacturer
     *
     * @return electric manufacturer
     */
    public String getValueFromSelectManufacturer() {
        final WebElement manufacturer = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricsManufacturer));
        return new Select(manufacturer).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets electric Fram Range Type
     *
     * @return electric Fram Range Type
     */
    public String getValueFromSelectFramRangeType() {
        final WebElement frameRangeType = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricsFrameRangeType));
        return new Select(frameRangeType).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets electric Fram Model Type
     *
     * @return electric Fram Model Type
     */
    public String getValueFromSelectFramModelType() {
        final WebElement frameModel = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricsFrameModelType));
        return new Select(frameModel).getFirstSelectedOption().getText().trim();
    }

    /**
     * Clicks on icon one
     */
    public void clickOnemptyIconOne() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(emptyIconOne))
                .click();
    }

    /**
     * Clicks on icon two
     */
    public void clickOnemptyIconTwo() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(emptyIconTwo))
                .click();
    }

    /**
     * Clicks on icon three
     */
    public void clickOnemptyIconThree() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(emptyIconThree))
                .click();
    }

    /**
     * Selects Socket Application
     */
    public void selectApplication() {
        final WebElement app = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(application));
        final Select select = new Select(app);
        select.selectByVisibleText(propertyFile.getSocketApplication());
    }

    /**
     * Selects socket one Execution
     */
    public void selectSocketOneExecution() {
        final WebElement exec = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(execution));
        final Select select = new Select(exec);
        select.selectByVisibleText(propertyFile.getSocketOneExecution());
    }

    /**
     * Selects socket Two Execution
     */
    public void selectSocketTwoExecution() {
        final WebElement exec2 = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(execution));
        final Select select = new Select(exec2);
        select.selectByVisibleText(propertyFile.getSocketTwoExecution());
    }

    /**
     * Selects socket Three Execution
     */
    public void selectSocketThreeExecution() {
        final WebElement exec3 = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(execution));
        final Select select = new Select(exec3);
        select.selectByVisibleText(propertyFile.getSocketThreeExecution());
    }

    /**
     * Selects Socket Applicaion model
     */
    public void selectApplicationModel() {
        final WebElement appModel = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(applicationModel));
        final Select select = new Select(appModel);
        select.selectByVisibleText(propertyFile.getSocketApplicationModel());
    }

    /**
     * Selects Socket Switchable
     */
    public void selectSwitchable() {
        final WebElement switchElectric = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(switchable));
        final Select select = new Select(switchElectric);
        select.selectByVisibleText(propertyFile.getSocketSwitchable());
    }

    /**
     * Selects Socket SeparatCircuit
     */
    public void selectSeparateCircuit() {
        final WebElement separateCircuitElectric = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(separateCircuit));
        final Select select = new Select(separateCircuitElectric);
        select.selectByVisibleText(propertyFile.getSocketSeparateCircuit());
    }

    /**
     * Selects Socket connection
     */
    public void selectConnectionType() {
        final WebElement connectionTypeElectric = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(connectionType));
        final Select select = new Select(connectionTypeElectric);
        select.selectByVisibleText(propertyFile.getSocketConnectionType());
    }

    /**
     * Gets Application
     *
     * @return Application
     */
    public String getValueFromSelectApplication() {
        final WebElement app = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(application));
        return new Select(app).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Socket one Execution
     *
     * @return Execution
     */
    public String getValueFromSelectSocketOneExecution() {
        final WebElement exec = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(execution));
        return new Select(exec).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Socket two Execution
     *
     * @return Execution
     */
    public String getValueFromSelectSocketTwoeExecution() {
        final WebElement exec2 = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(execution));
        return new Select(exec2).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Socket three Execution
     *
     * @return Execution
     */
    public String getValueFromSelectSocketThreeExecution() {
        final WebElement exec3 = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(execution));
        return new Select(exec3).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Application Model
     *
     * @return Application Model
     */
    public String getValueFromSelectApplicationModel() {
        final WebElement appModel = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(applicationModel));
        return new Select(appModel).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Switchable
     *
     * @return switchable
     */
    public String getValueFromSelectSwitchable() {
        final WebElement switchElectric = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(switchable));
        return new Select(switchElectric).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets separateCircuite
     *
     * @return separateCircuite
     */
    public String getValueFromSelectSeparateCircuit() {
        final WebElement separateCircuitElectric = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(separateCircuit));
        return new Select(separateCircuitElectric).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Connection
     *
     * @return Connection
     */
    public String getValueFromSelectConnection() {
        final WebElement connectionTypeElectric = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(connectionType));
        return new Select(connectionTypeElectric).getFirstSelectedOption().getText().trim();
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
        clickOnAbortChanges();
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
        clickOnSaveChanges();
    }

    /**
     * Creates Socket two and three and abort
     */
    public void createSocketTwoAndAbort() {
        selectApplication();
        selectSocketOneExecution();
        selectApplicationModel();
        selectSwitchable();
        selectSeparateCircuit();
        selectConnectionType();
        clickOnAbortChanges();
    }

    /**
     * Creates Socket two and three and save
     */
    public void createSocketTwoAndSave() {
        selectApplication();
        selectSocketOneExecution();
        selectApplicationModel();
        selectSwitchable();
        selectSeparateCircuit();
        selectConnectionType();
        clickOnSaveChanges();
    }

}
