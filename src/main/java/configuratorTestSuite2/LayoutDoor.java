
package configuratorTestSuite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutDoor extends Base {

    WebDriver driver;

    // Finds correct element
    @FindBy(xpath = "//li[@data-target='layout/doors']")
    private WebElement layoutDoor;

    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'Type24')]")
    private WebElement door;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[10]")
    private WebElement roomsUpperSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[13]")
    private WebElement roomsLeftSide;

    private final By countOfDoor = By
            .xpath("//*[name()='svg']//*[local-name()='g' and @class='doorParent signParent']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutDoor(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on door icon
     */
    public void clickOnDoorIcon() {
        click(layoutDoor, 20);
    }

    /**
     * Drags and drops door to rooms upper side
     */
    public void dragAndDropRoomsUpperSideDoor() {
        final WebElement src = dragAndDrop(door, 10);
        final WebElement upperSide = dragAndDrop(roomsUpperSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, upperSide, 0, 0, 450, 0);
    }

    /**
     * Drags and drops door to rooms left side
     */
    public void dragAndDropRoomsLeftSideDoor() {
        final WebElement src = dragAndDrop(door, 10);
        final WebElement leftSide = dragAndDrop(roomsLeftSide, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, leftSide, 0, 0, 0, 900);
    }

    /**
     * Checks count of door after drag and drop
     *
     * @return count of doors
     */
    public int checkCountOfDoorAfterDragAndDrop() {
        return getCountOfElements(countOfDoor, 2);
    }

    /**
     * Checks count of door before drag and drop
     *
     * @return count of door
     */
    public int checkCountOfDoorBeforeDragAndDrop() {
        return driver.findElements(countOfDoor).size();
    }

}
