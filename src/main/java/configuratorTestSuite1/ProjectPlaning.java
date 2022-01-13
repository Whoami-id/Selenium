
package configuratorTestSuite1;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPlaning {
    ReadPropertyFile propertyFile = new ReadPropertyFile();
    WebDriver driver;

    // Finds correct element
    @FindBy(id = "name")
    WebElement projectName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "construction-type")
    WebElement constructionType;

    @FindBy(id = "start-date")
    WebElement startDate;

    @FindBy(id = "templateplanning")
    WebElement clickOnPlusIcon;

    @FindBy(id = "projectplanning")
    WebElement goBackToProjectPlaning;

    /**
     * Constructor from ProjectPlaning Class
     *
     * @param driver
     */
    public ProjectPlaning(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Writes Projectname in input field
     */
    public void setProjectName() {
        final String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        final WebElement name = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(projectName));
        name.click();
        name.clear();
        name.clear();
        name.sendKeys(Keys.chord(Keys.CONTROL + "a"), propertyFile.getProjectName() + date);
        name.sendKeys(Keys.RETURN);
        // name.clear();
        // name.sendKeys(propertyFile.getProjectName());
    }

    /**
     * Write PostaCode in input field
     */
    public void setPostalCode() {
        final WebElement pCode = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(postalCode));
        pCode.click();
        pCode.sendKeys(Keys.chord(Keys.CONTROL + "a"), propertyFile.getPostaCode());
        pCode.sendKeys(Keys.RETURN);
        pCode.sendKeys(Keys.UP);
        // pCode.sendKeys(propertyFile.getPostaCode());
    }

    /**
     * Writes City in input field
     */
    public void setCity() {
        final WebElement pCity = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(city));
        pCity.click();
        pCity.sendKeys(Keys.chord(Keys.CONTROL + "a"), propertyFile.getCity());
        pCity.sendKeys(Keys.RETURN);
        pCity.sendKeys(Keys.UP);
        // pCity.sendKeys(propertyFile.getCity());
    }

    /**
     * Selects Constructiontype from drop down menu
     */
    public void setConstructionType() {
        final WebElement projectConstructionType = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.elementToBeClickable(constructionType));
        final Select select = new Select(projectConstructionType);
        select.selectByVisibleText(propertyFile.getconstructionType());
    }

    /**
     * Writes Startdate
     */
    public void setStartDate() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(startDate))
                .sendKeys(propertyFile.getStartDate());

    }

    /**
     * Clicks on PlusSysmbol at the top
     */
    public void clickOnPlusSymbol() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(clickOnPlusIcon)).click();
    }

    /**
     * goes back to ProjectPlaning
     */
    public void goBackToProjectPlaning() {
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.elementToBeClickable(goBackToProjectPlaning)).click();
    }

    /**
     * Creates a Project
     */
    public void createAProject() throws InterruptedException {
        setProjectName();
        Thread.sleep(2000);
        setPostalCode();
        Thread.sleep(2000);
        setCity();
        Thread.sleep(2000);
        setConstructionType();
        Thread.sleep(2000);
        setStartDate();
        Thread.sleep(1000);
        clickOnPlusSymbol();
        Thread.sleep(1000);
    }

    /**
     * Gets entered projectname form input field
     *
     * @return projectname
     */
    public String getEnteredProjectName() {
        return projectName.getAttribute("value");
    }

    /**
     * Gets entered Password from input field
     *
     * @return Password
     */
    public String getEnteredPostalCode() {
        return postalCode.getAttribute("value");
    }

    /**
     * Gets entered City form input field
     *
     * @return City
     */
    public String getEnteredCity() {
        return city.getAttribute("value");
    }

    /**
     * Gets selected Constructiontype form drop down menu
     *
     * @return Constructiontype
     */
    public String getSelectedConstructionType() {
        return new Select(constructionType).getFirstSelectedOption().getText().trim();
    }

    /**
     * Gets entered Startdate
     *
     * @return Startdate
     */
    public String getEnteredStartDate() {
        final String date = startDate.getAttribute("value");
        return date;
    }

}
