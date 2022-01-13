
package configuratorTestSuite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutElectric extends Base {

    WebDriver driver;
    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='layout/electrics']")
    private WebElement layoutElectric;

    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'Type63')]")
    private WebElement electric;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[13]")
    private WebElement roomsRightSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[14]")
    private WebElement roomsLowerSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[12]")
    private WebElement roomsUpperSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[15]")
    private WebElement roomsLeftSide;

    private final By countOfElectric = By
            .xpath("//*[name()='svg']//*[local-name()='g' and @class='electricParent signParent']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutElectric(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on electrics icon
     */
    public void clickOnElectricIcon() {
        click(layoutElectric, 10);
    }

    /**
     * Drags and drops electric to rooms lower side
     */
    public void dragAndDropRoomsLowerSideElectric() {
        final WebElement src = dragAndDrop(electric, 10);
        final WebElement lowerSide = dragAndDrop(roomsLowerSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, lowerSide, 0, 0, 900, 1200);
    }

    /**
     * Drags and drops electric to rooms left side
     */
    public void dragAndDropRoomsLeftSideElectric() {
        final WebElement src = dragAndDrop(electric, 10);
        final WebElement lowerSide = dragAndDrop(roomsLeftSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, lowerSide, 0, 0, 689, 1300);
    }

    /**
     * Drags and drops electric to rooms right side
     */
    public void dragAndDropRoomsRightSideElectric() {
        final WebElement src = dragAndDrop(electric, 10);
        final WebElement lowerSide = dragAndDrop(roomsRightSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, lowerSide, 0, 0, 1169, 500);
    }

    /**
     * Drags and drops electric to rooms upper side
     */
    public void dragAndDropRoomsUpperSideElectric() {
        final WebElement src = dragAndDrop(electric, 10);
        final WebElement upperSide = dragAndDrop(roomsUpperSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, upperSide, 0, 0, 850, 679);
    }

    /**
     * Checks count of electrics after drag and drop
     *
     * @return count of electrics
     */
    public int checkCountOfElectricAferDragAndDrop() {
        return getCountOfElements(countOfElectric, 4);
    }

    /**
     * Checks count of electric before drag and drop
     *
     * @return count of electric
     */
    public int checkCountOfElectricBeforeDragAndDrop() {
        return driver.findElements(countOfElectric).size();
    }
}
