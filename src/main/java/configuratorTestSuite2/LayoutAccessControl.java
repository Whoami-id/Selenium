
package configuratorTestSuite2;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutAccessControl extends Base {

    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='layout/accesscontrols']")
    private WebElement layoutAccessControl;

    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'Type87')]")
    private WebElement accessControl;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[4]")
    private WebElement roomsRightSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[8]")
    private WebElement roomsLeftSide;

    private final By countOfAccessControl = By
            .xpath("//*[name()='svg']//*[local-name()='g' and @class='accessControlParent signParent']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutAccessControl(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on accessControl icon
     */
    public void clickOnAccessControlIcon() {
        click(layoutAccessControl, 20);
    }

    /**
     * Drags and drops accessContorl to rooms upper side
     *
     * @throws AWTException
     */
    public void dragAndDropRoomsRightSideAccessControl() throws AWTException {
        final WebElement src = dragAndDrop(accessControl, 20);
        final WebElement upperSide = dragAndDrop(roomsRightSide, 20);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, upperSide, 0, 0, 885, 680);

    }

    /**
     * Drags and drops accessContorl to rooms left side
     */
    public void dragAndDropRoomsLeftSideAccessControl() {
        final WebElement src = dragAndDrop(accessControl, 20);
        final WebElement leftSide = dragAndDrop(roomsLeftSide, 20);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, leftSide, 0, 0, 690, 1100);
    }

    /**
     * Checks count of accessControl after drag and drop
     *
     * @return count of accessControl
     */
    public int checkCountOfAccessControlAfterDragAndDrop() {
        return getCountOfElements(countOfAccessControl, 0);
    }

    /**
     * Checks count of access control before drag and drop
     *
     * @return count of access control
     */
    public int checkCountOfAccessControlBeforeDragAndDrop() {
        return driver.findElements(countOfAccessControl).size();
    }
}
