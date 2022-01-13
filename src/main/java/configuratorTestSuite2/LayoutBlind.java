
package configuratorTestSuite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutBlind extends Base {

    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'Type12')]")
    private WebElement blind;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='g'])//*[text()='F_001']")
    private WebElement firstWindow;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='g'])//*[text()='F_002']")
    private WebElement secondWindow;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='g'])//*[text()='F_003']")
    private WebElement thirdWindow;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='g'])//*[text()='F_004']")
    private WebElement fourthWindow;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='g'])//*[text()='F_005']")
    private WebElement fifthWindow;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='g'])//*[text()='F_006']")
    private WebElement sixthWindow;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='g'])//*[text()='F_007']")
    private WebElement seventhWindow;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='g'])//*[text()='F_008']")
    private WebElement eighthWindow;

    private final By countOfBlinds = By.xpath(
            "//*[name()='svg']//*[local-name()='g']//*[local-name()='use' and @*='/resources/img/layout/blind_motor.svg#Zeichen']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutBlind(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Drags and drop blind to window
     */
    public void dragAndDroptBlindToWindow() {
        final WebElement src = dragAndDrop(blind, 30);
        final WebElement windowF001 = dragAndDrop(firstWindow, 10);
        final WebElement windowF002 = dragAndDrop(secondWindow, 10);
        final WebElement windowF003 = dragAndDrop(thirdWindow, 10);
        final WebElement windowF004 = dragAndDrop(fourthWindow, 10);
        final WebElement windowF005 = dragAndDrop(fifthWindow, 10);
        final WebElement windowF006 = dragAndDrop(sixthWindow, 10);
        final WebElement windowF007 = dragAndDrop(seventhWindow, 10);
        final WebElement windowF008 = dragAndDrop(eighthWindow, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, windowF001, 0, 0, 0, 0);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, windowF002, 0, 0, 0, 0);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, windowF003, 0, 0, 0, 0);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, windowF004, 0, 0, 0, 0);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, windowF005, 0, 0, 0, 0);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, windowF006, 0, 0, 0, 0);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, windowF007, 0, 0, 0, 0);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, windowF008, 0, 0, 0, 0);
    }

    /**
     * Checks count of blinds after drag and drop
     *
     * @return count of blinds
     */
    public int CheckCountOfBlindAfterDragAndDrop() {
        return getCountOfElements(countOfBlinds, 8);
    }

    /**
     * Checks count of blinds before drag and drop
     *
     * @return count of blinds
     */
    public int checkCoutnOfBlindBeforeDragAndDrop() {
        return driver.findElements(countOfBlinds).size();
    }

}
