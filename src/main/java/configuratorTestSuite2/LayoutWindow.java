
package configuratorTestSuite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutWindow extends Base {

    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='layout/windows']")
    private WebElement layoutWindow;

    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'FensterType65')]")
    private WebElement window;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[2]")
    private WebElement roomsUpperSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[3]")
    private WebElement roomsRightSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[4]")
    private WebElement roomsLowerSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[5]")
    private WebElement roomsLeftSide;

    private final static By countOfWindows = By
            .xpath("//*[name()='svg']//*[local-name()='g' and @class='windowParent signParent']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutWindow(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on window icon
     */
    public void clickOnWindowIcon() {
        click(layoutWindow, 20);
    }

    /**
     * Drags and drops window to rooms upper side
     *
     * @throws InterruptedException
     */
    public void dragAndDropRoomsUpperSideWindow() {
        final WebElement src = dragAndDrop(window, 30);
        final WebElement dest = dragAndDrop(roomsUpperSide, 30);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 640, 0);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 380, 0);
    }

    /**
     * Drags and drops window to rooms right side
     *
     */
    public void dragAndDropRoomsRightSideWindow() {
        final WebElement src = dragAndDrop(window, 10);
        final WebElement dest = dragAndDrop(roomsRightSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 0, 800);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 0, 1000);
    }

    /**
     * Drags and drops window to rooms lower side
     *
     */
    public void dragAndDropRoomsLowerSideWindow() {
        final WebElement src = dragAndDrop(window, 10);
        final WebElement dest = dragAndDrop(roomsLowerSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 1100, 0);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 800, 0);
    }

    /**
     * Drags and drops window to rooms left side
     *
     */
    public void dragAndDropRoomsLeftSideWindow() {
        final WebElement src = dragAndDrop(window, 10);
        final WebElement dest = dragAndDrop(roomsLeftSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 0, 1000);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 0, 800);
    }

    /**
     * Checks count of windows after drag and drop
     *
     * @return count of windows
     */
    public int CheckCountOfWindowAfterDragAndDrop() {
        return getCountOfElements(countOfWindows, 8);
    }

    /**
     * Checks count of windows before drag and drop
     *
     * @return count of wall
     */
    public int checkCoutnOfWindowBeforeDragAndDrop() {
        return driver.findElements(countOfWindows).size();
    }

}
