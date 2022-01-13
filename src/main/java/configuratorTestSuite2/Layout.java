
package configuratorTestSuite2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Layout extends Base {

    WebDriver driver;

    /** Finds correct element */
    @FindBy(id = "layout")
    private WebElement layoutIcon;

    @FindBy(xpath = "//li[@data-target='layout/draw']")
    private WebElement layoutDraw;

    @FindBy(xpath = "//div[@title='Neuer Raum/Bereich']")
    private WebElement newRoom;

    @FindBy(xpath = "//div[@class='layout-area dropzone draw']")
    private WebElement layoutZone;

    private final By countOfRooms = By.xpath("//*[name()='svg']//*[local-name()='polygon']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public Layout(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on Layout icon
     */
    public void clickOnLayoutIcon() {
        click(layoutIcon, 20);
    }

    /**
     * Clicks on Layout icon
     */
    public void clickOnLayoutDrawIcon() {
        click(layoutDraw, 20);
    }

    /**
     * Drags and drops new room
     *
     * @throws IOException
     */
    public void dragAndDropNewRoom() {
        final WebElement src = dragAndDrop(newRoom, 10);
        final WebElement dest = dragAndDrop(layoutZone, 20);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 800, 800);
    }

    /**
     * Checks count of rooms
     *
     * @return count of rooms
     */
    public int CheckIfRoomHasBeenDraggedAndDropped() {
        return getCountOfElements(countOfRooms, 1);
    }

}
