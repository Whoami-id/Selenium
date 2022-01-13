
package configuratorTestSuite2;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPlaning extends Base {
    ReadPropertyFile propertyFile = new ReadPropertyFile();
    final String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    WebDriver driver;

    /** Finds correct element */
    @FindBy(id = "projectplanning")
    private WebElement goBackToProjectPlaning;

    @FindBy(id = "templateplanning")
    private WebElement clickOnPlusIcon;

    @FindBy(id = "name")
    private WebElement projectName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "construction-type")
    private WebElement constructionType;

    @FindBy(id = "start-date")
    private WebElement startDate;

    /**
     * Constructor from ProjectPlaning Class
     *
     * @param driver
     */
    public ProjectPlaning(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Writes Project name in input field
     */
    public void setProjectName() {
        typeForProjectPalaning(projectName, 20, propertyFile.getProjectName() + date);
    }

    /**
     * Write PostaCode in input field
     */
    public void setPostalCode() {
        typeForProjectPalaning(postalCode, 20, propertyFile.getPostaCode());
    }

    /**
     * Writes City in input field
     */
    public void setCity() {
        typeForProjectPalaning(city, 20, propertyFile.getCity());
    }

    /**
     * Selects Construction type from drop down menu
     */
    public void setConstructionType() {
        select(constructionType, 20, propertyFile.getconstructionType());
    }

    /**
     * Writes Startdate
     */
    public void setStartDate() {
        // type(startDate, 20, propertyFile.getStartDate());
        final WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(startDate));
        element.sendKeys(propertyFile.getStartDate());
    }

    /**
     * goes back to ProjectPlaning
     */
    public void goBackToProjectPlaning() {
        click(goBackToProjectPlaning, 20);

    }

    /**
     * Clicks on PlusSysmbol at the top
     */
    public void clickOnPlusSymbol() {
        click(clickOnPlusIcon, 20);

    }

    /**
     * Gets entered project name form input field
     *
     * @return project name
     */
    public String getEnteredProjectName() {
        return getValueFromInputField(projectName);
    }

    /**
     * Gets entered Password from input field
     *
     * @return Password
     */
    public String getEnteredPostalCode() {
        return getValueFromInputField(postalCode);
    }

    /**
     * Gets entered City form input field
     *
     * @return City
     */
    public String getEnteredCity() {
        return getValueFromInputField(city);
    }

    /**
     * Gets selected Construction type form drop down menu
     *
     * @return Construction type
     */
    public String getSelectedConstructionType() {
        return getValueFromDropDownMenu(constructionType);
    }

    /**
     * Gets entered Startdate
     *
     * @return Startdate
     */
    public String getEnteredStartDate() {
        return getValueFromInputField(startDate);
    }

    /**
     * Formats date
     *
     * @return formated date
     */
    public StringBuilder formateDate() {
        return new StringBuilder().append(getEnteredStartDate().substring(8, 10)).append(".")
                .append(getEnteredStartDate().substring(5, 7)).append(".")
                .append(getEnteredStartDate().substring(0, 4));
    }

    /**
     * Creates a Project
     *
     */
    public void createAProject() {
        setProjectName();
        setPostalCode();
        setCity();
        setConstructionType();
        setStartDate();

    }

}
