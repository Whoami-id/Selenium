
package configuratorTestSuite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutElectricPlus extends Base {

    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='layout/electricplus']")
    private WebElement layoutElectricPlus;

    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'Type91')]")
    private WebElement electricPlus;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[13]")
    private WebElement roomsRightSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[14]")
    private WebElement roomsLowerSide;

    private final By countOfElectricPlus = By
            .xpath("//*[name()='svg']//*[local-name()='g' and @class='ePlusParent signParent']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutElectricPlus(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on electricsPlus icon
     */
    public void clickOnElectricPlusIcon() {
        click(layoutElectricPlus, 30);
    }

    /**
     * Drags and drops electricPlus to rooms lower side
     */
    public void dragAndDropRoomsLowerSideElectricPlus() {
        final WebElement src = dragAndDrop(electricPlus, 10);
        final WebElement lowerSide = dragAndDrop(roomsLowerSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, lowerSide, 0, 0, 1100, 1350);
    }

    /**
     * Drags and drops electricPlus to rooms right side
     */
    public void dragAndDropRoomsRightSideElectricPlus() {
        final WebElement src = dragAndDrop(electricPlus, 10);
        final WebElement lowerSide = dragAndDrop(roomsRightSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, lowerSide, 0, 0, 900, 1000);
    }

    /**
     * Checks count of electric plus after drag and drop
     *
     * @return count of electric plus
     */
    public int checkCountOfElectricPlusAfterDragAndDrop() {
        return getCountOfElements(countOfElectricPlus, 2);
    }

    /**
     * Checks count of electric plus before drag and drop
     *
     * @return count of electric plus
     */
    public int checkCountOfElectricPlusBeforeDragAndDrop() {
        return driver.findElements(countOfElectricPlus).size();
    }

}
