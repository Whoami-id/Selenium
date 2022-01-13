
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dokuments extends Base {

    WebDriver driver;
    ReadPropertyFile propertyFile = new ReadPropertyFile();

    /** Finds correct Elements */
    @FindBy(id = "expose")
    private WebElement exposeIcon;

    @FindBy(xpath = "//span[@class='description wide' and contains(text(),'Leistungsverzeichnis Automation und Elektrik')]")
    private WebElement automationAndElectric;

    @FindBy(xpath = "(//span[@class='description wide' and contains(text(),'Leistungsverzeichnis Automation')])[2]")
    private WebElement automation;

    @FindBy(xpath = "//span[@class='description wide' and contains(text(),'Leistungsverzeichnis Elektrik')]")
    private WebElement electric;

    @FindBy(id = "automation-electric-gaeb-export")
    private WebElement outputAutomationAndElectric;

    @FindBy(id = "automation-gaeb-export")
    private WebElement outputAutomation;

    @FindBy(id = "electric-gaeb-export")
    private WebElement outputElectric;

    @FindBy(xpath = "//span[@id='AutomationElectricGaebExport']")
    private WebElement createAutomationAndElectricButton;

    @FindBy(id = "AutomationGaebExport")
    private WebElement createAutomationButton;

    @FindBy(id = "ElectricGaebExport")
    private WebElement createElectricButton;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public Dokuments(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on icon
     */
    public void clickOnDokumentIcon() {
        click(exposeIcon, 20);
    }

    /**
     * Clicks on automation and electric
     */
    public void clickOnAutomationAndElectric() {
        click(automationAndElectric, 20);
    }

    /**
     * Selects output
     */
    public void selectOutputAutomationAndElectric() {
        select(outputAutomationAndElectric, 20, propertyFile.getOutputWithPrice());
    }

    /**
     * Clicks on create
     */
    public void clickOnCreateAutomationAndElectric() {
        click(createAutomationAndElectricButton, 20);
    }

    /**
     * Clicks on automation
     */
    public void clickOnAutomation() {
        click(automation, 20);
    }

    /**
     * Selects output
     */
    public void selectOutputAutomation() {
        select(outputAutomation, 20, propertyFile.getOutputWithoutPrice());
    }

    /**
     * click on create
     */
    public void clickOnCreateAutomation() {
        click(createAutomationButton, 20);
    }

    /**
     * Clicks on electric
     */
    public void clickOnElectric() {
        click(electric, 20);
    }

    /**
     * selects output
     */
    public void selectOutputElectric() {
        select(outputElectric, 20, propertyFile.getOutputWithPrice());
    }

    /**
     * Clicks on create
     */
    public void clickOnCreateElectric() {
        click(createElectricButton, 20);
    }

    /**
     * Creates automation and electric
     */
    public void createAutomationAndElectric() {
        clickOnAutomationAndElectric();
        selectOutputAutomationAndElectric();
        clickOnCreateAutomationAndElectric();
    }

    /**
     * Creates automation
     */
    public void createAutomation() {
        clickOnAutomation();
        selectOutputAutomation();
        clickOnCreateAutomation();
    }

    /**
     * Creates electric
     */
    public void createElectric() {
        clickOnElectric();
        selectOutputElectric();
        clickOnCreateElectric();
    }

    /**
     * Checks if file size is bigger than 0
     *
     * @param downloadPath
     * @param fileName
     * @return
     */
    public boolean checkIfFileIsDownloaded(final String downloadPath, final String fileName) {
        if (isFileDownloaded(downloadPath, fileName) == false) {
            return false;
        }
        return true;
    }

}
