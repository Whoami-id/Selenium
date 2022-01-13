
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateElectricPlus extends Base {

    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='template/electricplus']")
    private WebElement electricPlusIcon;

    @FindBy(id = "newElectroPlus")
    private WebElement createNewElectricPlusType;

    @FindBy(className = "itemDescription")
    private WebElement newElectricPlus;

    @FindBy(id = "electroplusname")
    private WebElement electricPlusName;

    @FindBy(id = "category-type")
    private WebElement electricPlusCategory;

    @FindBy(id = "component-type")
    private WebElement electricPlusComponent;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    private WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    /**
     * Constructor
     *
     * @param driver
     */
    public CreateElectricPlus(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on Electricplus icon
     */
    public void clickOnElectricPlusIcon() {
        click(electricPlusIcon, 20);
    }

    /**
     * Clicks on create new Type
     */
    public void clickOnCreateNewType() {
        click(createNewElectricPlusType, 20);
    }

    /**
     * Clicks on Created type
     */
    public void clickOnCreatedType() {
        click(newElectricPlus, 20);
    }

    /**
     * Sets Electricplus name
     */
    public void setElectricPlusName() {
        type(electricPlusName, 20, propertyFile.getElectricPlusName());
    }

    /**
     * Selects Electricplus category
     */
    public void selectElectricPlusCategory() {
        select(electricPlusCategory, 20, propertyFile.getElectricPlusCategroy());
    }

    /**
     * Selects Electricplus component
     */
    public void selectElectricPlusComponent() {
        select(electricPlusComponent, 20, propertyFile.getElectricPlusComponent());
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
     * Gets ElectricPlus name
     *
     * @return electricPlus name
     */
    public String getValueFromInputFieldElectricPlusName() {
        return getValueFromInputField(electricPlusName);
    }

    /**
     * Gets ElectricPlus category
     *
     * @return electricPlus category
     */
    public String getValueFromSelectElectricPlusCategory() {
        return getValueFromDropDownMenu(electricPlusCategory);
    }

    /**
     * Gets Electric plus component
     *
     * @return electricPlus component
     */
    public String getValueFromSelectElectricPlusComponent() {
        return getValueFromDropDownMenu(electricPlusComponent);
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
