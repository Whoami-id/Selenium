
package configuratorTestSuite1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccessControl {

    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    // Finds correct element
    @FindBy(xpath = "//li[@data-target='template/accesscontrols']")
    WebElement accessControlIcon;

    @FindBy(id = "newAccessControl")
    WebElement createNewType;

    @FindBy(className = "itemDescription")
    WebElement newAccessControl;

    @FindBy(id = "accesscontrolname")
    WebElement accessControlName;

    @FindBy(id = "category-type")
    WebElement accessContorlCategory;

    @FindBy(id = "use-type")
    WebElement accessControlUseArt;

    @FindBy(xpath = "//span[contains(text(),'Speichern')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Löschen')]")
    WebElement delete;

    @FindBy(xpath = "//span[contains(text(),'Abbrechen')]")
    WebElement abortChanges;

    /**
     * Constructor has one parameter
     *
     * @param driver
     */
    public CreateAccessControl(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on AccessControlIcon
     */
    public void clickOnAccessControlIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(accessControlIcon)).click();
    }

    /**
     * Clicks On create new type
     */
    public void clickOnCreateNewType() {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(createNewType))
                .click();
    }

    /**
     * Clicks on created AccessControl type
     */
    public void clickOnCreatedAccessControl() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(newAccessControl)).click();
    }

    /**
     * Sets the name
     */
    public void setAcessControlName() {
        final WebElement name = new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(accessControlName));
        name.clear();
        name.sendKeys(propertyFile.getAccessControlName());
    }

    /**
     * Selects Category
     */
    public void selectAccessControlCategory() {
        final WebElement category = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(accessContorlCategory));
        final Select selectMaterialType = new Select(category);
        selectMaterialType.selectByVisibleText(propertyFile.getAccessControlCategory());
    }

    /**
     * Selects UseArt
     */
    public void selectAccessControlUseArt() {
        final WebElement useArt = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(accessControlUseArt));
        final Select selectMaterialType = new Select(useArt);
        selectMaterialType.selectByVisibleText(propertyFile.getAccessControlUseArt());
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
     * Gets value from name
     *
     * @return name
     */
    public String getValueFromInputFieldName() {
        return accessControlName.getAttribute("value");
    }

    /**
     * Gets value from Category
     *
     * @return category
     */
    public String getValueFromSelectAccessControlCategory() {
        final WebElement category = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(accessContorlCategory));
        return new Select(category).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets value from UseArt
     *
     * @return UseArt
     */
    public String getValueFromSelectAccessControlUseArt() {
        final WebElement useArt = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(accessControlUseArt));
        return new Select(useArt).getFirstSelectedOption().getText().trim();
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
