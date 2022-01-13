
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccessControl extends Base {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='template/accesscontrols']")
    private WebElement accessControlIcon;

    @FindBy(id = "newAccessControl")
    private WebElement createNewType;

    @FindBy(className = "itemDescription")
    private WebElement newAccessControl;

    @FindBy(xpath = "//input[@id='accesscontrolname']")
    private WebElement accessControlName;

    @FindBy(id = "category-type")
    private WebElement accessContorlCategory;

    @FindBy(id = "use-type")
    private WebElement accessControlUseArt;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    private WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    private WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    private WebElement abort;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public CreateAccessControl(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on AccessControlIcon
     */
    public void clickOnAccessControlIcon() {
        click(accessControlIcon, 20);
    }

    /**
     * Clicks On create new type
     */
    public void clickOnCreateNewType() {
        click(createNewType, 20);
    }

    /**
     * Clicks on created AccessControl type
     */
    public void clickOnCreatedAccessControl() {
        click(newAccessControl, 20);
    }

    /**
     * Sets the name
     */
    public void setAcessControlName() {
        type(accessControlName, 20, propertyFile.getAccessControlName());
    }

    /**
     * Selects Category
     */
    public void selectAccessControlCategory() {
        select(accessContorlCategory, 20, propertyFile.getAccessControlCategory());
    }

    /**
     * Selects UseArt
     */
    public void selectAccessControlUseArt() {
        select(accessControlUseArt, 20, propertyFile.getAccessControlUseArt());
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
     * Gets value from name
     *
     * @return name
     */
    public String getValueFromInputFieldName() {
        return getValueFromInputField(accessControlName);
    }

    /**
     * Gets value from Category
     *
     * @return category
     */
    public String getValueFromSelectAccessControlCategory() {
        return getValueFromDropDownMenu(accessContorlCategory);
    }

    /**
     * Gets value from UseArt
     *
     * @return UseArt
     */
    public String getValueFromSelectAccessControlUseArt() {
        return getValueFromDropDownMenu(accessControlUseArt);
    }

    /**
     * Creates AccessControl and abort changes
     */
    public void createAccessControlAndAbort() {
        setAcessControlName();
        selectAccessControlCategory();
        selectAccessControlUseArt();
        clickOnAbortChanges();
    }

    /*
     * Creates AccessControl and save changes
     */
    public void createAccessControlAndSave() {
        setAcessControlName();
        selectAccessControlCategory();
        selectAccessControlUseArt();
        clickOnSaveChanges();
    }

}
