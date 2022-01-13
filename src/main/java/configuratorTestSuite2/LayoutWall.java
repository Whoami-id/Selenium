
package configuratorTestSuite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutWall extends Base {

    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='layout/walls']")
    private WebElement layoutWall;

    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'WandType20')]")
    private WebElement insideWall;

    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'WandType21')]")
    private WebElement outerWall;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[2]")
    private WebElement roomsUpperSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[3]")
    private WebElement roomsRightSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[4]")
    private WebElement roomsLowerSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[5]")
    private WebElement roomsLeftSide;

    private final By countOfWall = By.xpath("//*[name()='svg']//*[local-name()='polygon' and @class='wall point']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutWall(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on wall icon
     */
    public void clickOnWallIcon() {
        click(layoutWall, 20);
    }

    /**
     * Drags and drops rooms upper wall
     */
    public void dragAndDropRoomsUpperSideInsideWall() {
        final WebElement src = dragAndDrop(insideWall, 30);
        final WebElement dest = dragAndDrop(roomsUpperSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 0, 0);
    }

    /**
     * Drags and drops rooms right wall
     */
    public void dragAndDropRoomsRightSideInsideWall() {
        final WebElement src = dragAndDrop(outerWall, 30);
        final WebElement dest = dragAndDrop(roomsRightSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 0, 0);
    }

    /**
     * Drags and drops rooms lower wall
     */
    public void dragAndDropRoomsLowerSideInsideWall() {
        final WebElement src = dragAndDrop(insideWall, 10);
        final WebElement dest = dragAndDrop(roomsLowerSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 0, 0);
    }

    /**
     * Drags and drops rooms left wall
     */
    public void dragAndDropRoomsLeftSideInsideWall() {
        final WebElement src = dragAndDrop(outerWall, 30);
        final WebElement dest = dragAndDrop(roomsLeftSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 0, 0);
    }

    /**
     * Checks count of wall before drag and drop
     *
     * @return count of wall
     */
    public int checkCountOfWallAfterDragAndDrop() {
        return getCountOfElements(countOfWall, 4);
    }

    /**
     * Checks count of wall after drag and drop
     * *
     *
     * @return count of wall
     */
    public int checkCountOfWallBeforeDragAndDrop() {
        return driver.findElements(countOfWall).size();
    }

}
