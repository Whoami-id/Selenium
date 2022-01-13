
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateElectricPlus {

    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    // Finds correct element
    @FindBy(xpath = "//li[@data-target='template/electricplus']")
    WebElement electricPlusIcon;

    @FindBy(id = "newElectroPlus")
    WebElement createNewElectricPlusType;

    @FindBy(className = "itemDescription")
    WebElement newElectricPlus;

    @FindBy(id = "electroplusname")
    WebElement electricPlusName;

    @FindBy(id = "category-type")
    WebElement electricPlusCategory;

    @FindBy(id = "component-type")
    WebElement electricPlusComponent;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    /**
     * Constructor
     *
     * @param driver
     */
    public CreateElectricPlus(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on Electricplus icon
     */
    public void clickOnElectricPlusIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(electricPlusIcon)).click();
    }

    /**
     * Clicks on create new Type
     */
    public void clickOnCreateNewType() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(createNewElectricPlusType)).click();
    }

    /**
     * Clicks on Created type
     */
    public void clickOnCreatedType() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(newElectricPlus)).click();
    }

    /**
     * Sets Electricplus name
     */
    public void setElectricPlusName() {
        final WebElement name = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(electricPlusName));
        name.clear();
        name.sendKeys(propertyFile.getElectricPlusName());
    }

    /**
     * Selects Electricplus category
     */
    public void selectElectricPlusCategory() {
        final WebElement category = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(electricPlusCategory));
        final Select select = new Select(category);
        select.selectByVisibleText(propertyFile.getElectricPlusCategroy());
    }

    /**
     * Selects Electricplus component
     */
    public void selectElectricPlusComponent() {
        final WebElement component = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(electricPlusComponent));
        final Select select = new Select(component);
        select.selectByVisibleText(propertyFile.getElectricPlusComponent());
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
     * Gets ElectricPlus name
     * 
     * @return electricPlus name
     */
    public String getValueFromInputFieldElectricPlusName() {
        return electricPlusName.getAttribute("value");
    }

    /**
     * Gets ElectricPlus category
     * 
     * @return electricPlus category
     */
    public String getValueFromSelectElectricPlusCategory() {
        final WebElement category = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricPlusCategory));
        return new Select(category).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets Electric plus component
     * 
     * @return electricPlus component
     */
    public String getValueFromSelectElectricPlusComponent() {
        final WebElement component = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(electricPlusComponent));
        return new Select(component).getFirstSelectedOption().getText().trim();
    }

    /**
     * Creates ElectricPlus and abort it
     */
    public void createElectricPlusAndAbort() {
        setElectricPlusName();
        selectElectricPlusCategory();
        selectElectricPlusComponent();
        clickOnAbortChanges();
    }

    /**
     * Creates ElectricPlus and save it
     */
    public void createElectricPlusAndSave() {
        setElectricPlusName();
        selectElectricPlusCategory();
        selectElectricPlusComponent();
        clickOnSaveChanges();

    }
}
